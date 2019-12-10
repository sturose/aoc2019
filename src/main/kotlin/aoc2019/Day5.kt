package aoc2019

import java.util.*

class Day5 {

    constructor(instructions: String, input: Int) {
        opcodes = instructions.split(",").map { it.trim().toInt() }.toMutableList()
        inputStack = LinkedList()
        inputStack.add(input)
    }

    constructor(instructions: ArrayList<Int>, input: Int) {
        opcodes.addAll(instructions)
        inputStack = LinkedList()
        inputStack.add(input)
    }

    var inputStack: LinkedList<Int>
    var opcodes = mutableListOf<Int>()
    var index = 0
    var output = 0

    fun addInput(addition: Int) {
        inputStack.add(addition)
    }

    fun processOpCodesInterrupt(): Pair<Boolean, Int> {
        var action = opcodes[index]

        while (action != 99) {

            var instructionLength = 4
            var param1Immediate = false
            var param2Immediate = false
            var param3Immediate = false

            if (action > 10) {
                if (action / 100 % 10 == 1) {
                    param1Immediate = true
                }
                if (action / 1000 % 10 == 1) {
                    param2Immediate = true
                }
                if (action / 10000 % 10 == 1) {
                    param3Immediate = true
                }
                action %= 10
            }

            when (action) {
                1 -> {
                    val val1 = if (param1Immediate) opcodes[index + 1] else opcodes[opcodes[index + 1]]
                    val val2 = if (param2Immediate) opcodes[index + 2] else opcodes[opcodes[index + 2]]
                    val position = if (param3Immediate) index + 3 else opcodes[index + 3]
                    opcodes[position] = val1 + val2
                }
                2 -> {
                    val val1 = if (param1Immediate) opcodes[index + 1] else opcodes[opcodes[index + 1]]
                    val val2 = if (param2Immediate) opcodes[index + 2] else opcodes[opcodes[index + 2]]
                    val position = if (param3Immediate) index + 3 else opcodes[index + 3]
                    opcodes[position] = val1 * val2
                }
                3 -> {
                    val position = if (param1Immediate) index + 1 else opcodes[index + 1]
                    instructionLength = 2
                    opcodes[position] = inputStack.poll()
                }
                4 -> {
                    val position = if (param1Immediate) index + 1 else opcodes[index + 1]
                    output = opcodes[position]
                    index += 2;
                    return Pair(false, output)
                }
                5 -> {
                    val val1 = if (param1Immediate) opcodes[index + 1] else opcodes[opcodes[index + 1]]
                    val val2 = if (param2Immediate) opcodes[index + 2] else opcodes[opcodes[index + 2]]
                    instructionLength = 3
                    if (val1 != 0) {
                        instructionLength = 0
                        index = val2
                    }
                }
                6 -> {
                    val val1 = if (param1Immediate) opcodes[index + 1] else opcodes[opcodes[index + 1]]
                    val val2 = if (param2Immediate) opcodes[index + 2] else opcodes[opcodes[index + 2]]
                    instructionLength = 3
                    if (val1 == 0) {
                        instructionLength = 0
                        index = val2
                    }
                }
                7 -> {
                    val val1 = if (param1Immediate) opcodes[index + 1] else opcodes[opcodes[index + 1]]
                    val val2 = if (param2Immediate) opcodes[index + 2] else opcodes[opcodes[index + 2]]
                    val position = if (param3Immediate) index + 3 else opcodes[index + 3]
                    val value = if (val1 < val2) 1 else 0
                    opcodes[position] = value
                }
                8 -> {
                    val val1 = if (param1Immediate) opcodes[index + 1] else opcodes[opcodes[index + 1]]
                    val val2 = if (param2Immediate) opcodes[index + 2] else opcodes[opcodes[index + 2]]
                    val position = if (param3Immediate) index + 3 else opcodes[index + 3]
                    val value = if (val1 == val2) 1 else 0
                    opcodes[position] = value
                }

            }
            index += instructionLength;
            action = opcodes[index]
        }

        return Pair(true, output)
    }

}