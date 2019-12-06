package aoc2019

class Day6 {

    class TreeNode<T>(value: T) {
        var value: T = value
        var weight: Int = 0
            get() = field
            set(value) {
                field = value
            }
        var parent: TreeNode<T>? = null

        var children: MutableList<TreeNode<T>> = mutableListOf()

        fun addChild(node: TreeNode<T>) {
            children.add(node)
            node.parent = this
        }

        override fun toString(): String {
            var s = "${value}"
            if (!children.isEmpty()) {
                s += " {" + children.map { it.toString() } + " }"
            }
            return s
        }
    }

    var tree: TreeNode<String> = TreeNode("COM")

    constructor(input: String) {
        val lines = input.split("\n")

        var leftToProcess = mutableListOf<String>()
        leftToProcess.addAll(lines)

        while (leftToProcess.isNotEmpty()) {
            var newLeftToProcess = mutableListOf<String>()

            for (line in leftToProcess) {
                val split = line.split(')')
                val parent = split[0]
                val child = split[1]
                val findNode = findNode(parent, tree)
                if (findNode != null) {
                    val childNode = TreeNode(child)
                    findNode.addChild(childNode)
                } else {
                    newLeftToProcess.add(line)
                }
            }
            leftToProcess = newLeftToProcess
        }
    }


    private fun findNode(nodeValue: String, parentNode: TreeNode<String>): TreeNode<String>? {
        if (parentNode.value == nodeValue) {
            return parentNode
        }
        for (node in parentNode.children) {
            val findNode = findNode(nodeValue, node)
            if (findNode != null) {
                return findNode
            }
        }
        return null
    }

    fun getDepth(): Int {
        return getDepth(tree, 0)
    }

    private fun getDepth(parentNode: TreeNode<String>, weight: Int): Int {
        var total = 0
        parentNode.weight = weight
        if (parentNode.children.size == 0) {
            return weight
        }
        for (node in parentNode.children) {
            total += getDepth(node, weight + 1)
        }
        return total + weight
    }

    fun getTransferCount(obj1: String, obj2: String): Int {
        val node1 = findNode(obj1, tree)
        val node2 = findNode(obj2, tree)
        val commonParent = commonNode(node1!!, node2!!)
        if (commonParent != null) {
            return (node1.weight - 1) + (node2.weight - 1) - (commonParent.weight * 2)
        }
        return -1
    }

    private fun commonNode(node1: TreeNode<String>?, node2: TreeNode<String>?): TreeNode<String>? {
        var parents = mutableListOf<String>()
        var tempNode = node1
        while (tempNode != null) {
            parents.add(tempNode.value)
            tempNode = tempNode.parent
        }

        tempNode = node2
        while (tempNode != null) {
            if (parents.contains(tempNode.value)) {
                return tempNode
            }
            tempNode = tempNode.parent
        }
        return null
    }
}