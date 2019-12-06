package aoc2019

class Day5 {

    constructor(instructions: String) {
        opcodes = instructions.split(",").map { it.trim().toInt() }.toMutableList()
        register = 0
    }

    constructor(instructions: String, input: Int) {
        opcodes = instructions.split(",").map { it.trim().toInt() }.toMutableList()
        register = input
    }

    var register: Int
    var opcodes = mutableListOf<Int>()

    fun opcodesString(): String {
        return opcodes.toIntArray().contentToString()
    }

    fun editNounAndVerb(noun: Int, verb: Int) {
        opcodes[1] = noun
        opcodes[2] = verb
    }

    fun processOpCodes(): Int {
        val newcodes = opcodes.toMutableList()
        var index = 0
        var action = newcodes[index]

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
                    val val1 = if (param1Immediate) newcodes[index + 1] else newcodes[newcodes[index + 1]]
                    val val2 = if (param2Immediate) newcodes[index + 2] else newcodes[newcodes[index + 2]]
                    val position = if (param3Immediate) index + 3 else newcodes[index + 3]
                    newcodes[position] = val1 + val2
                }
                2 -> {
                    val val1 = if (param1Immediate) newcodes[index + 1] else newcodes[newcodes[index + 1]]
                    val val2 = if (param2Immediate) newcodes[index + 2] else newcodes[newcodes[index + 2]]
                    val position = if (param3Immediate) index + 3 else newcodes[index + 3]
                    newcodes[position] = val1 * val2
                }
                3 -> {
                    val position = if (param1Immediate) index + 1 else newcodes[index + 1]
                    instructionLength = 2
                    newcodes[position] = register
                }
                4 -> {
                    val position = if (param1Immediate) index + 1 else newcodes[index + 1]
                    instructionLength = 2
                    register = newcodes[position]
                    println(register)
                }
                5 -> {
                    val val1 = if (param1Immediate) newcodes[index + 1] else newcodes[newcodes[index + 1]]
                    val val2 = if (param2Immediate) newcodes[index + 2] else newcodes[newcodes[index + 2]]
                    instructionLength = 3
                    if (val1 != 0) {
                        instructionLength = 0
                        index = val2
                    }
                }
                6 -> {
                    val val1 = if (param1Immediate) newcodes[index + 1] else newcodes[newcodes[index + 1]]
                    val val2 = if (param2Immediate) newcodes[index + 2] else newcodes[newcodes[index + 2]]
                    instructionLength = 3
                    if (val1 == 0) {
                        instructionLength = 0
                        index = val2
                    }
                }
                7 -> {
                    val val1 = if (param1Immediate) newcodes[index + 1] else newcodes[newcodes[index + 1]]
                    val val2 = if (param2Immediate) newcodes[index + 2] else newcodes[newcodes[index + 2]]
                    val position = if (param3Immediate) index + 3 else newcodes[index + 3]
                    val value = if (val1 < val2) 1 else 0
                    newcodes[position] = value
                }
                8 -> {
                    val val1 = if (param1Immediate) newcodes[index + 1] else newcodes[newcodes[index + 1]]
                    val val2 = if (param2Immediate) newcodes[index + 2] else newcodes[newcodes[index + 2]]
                    val position = if (param3Immediate) index + 3 else newcodes[index + 3]
                    val value = if (val1 == val2) 1 else 0
                    newcodes[position] = value
                }

            }
            index += instructionLength;
            action = newcodes[index]
        }

        return register
    }
}