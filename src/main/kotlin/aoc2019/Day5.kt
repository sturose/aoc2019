package aoc2019

import java.util.*

class Day5 {

    constructor(instructions: String, input: Long) {
        opcodes = instructions.split(",").map { it.trim().toLong() }.toMutableList()
        inputStack = LinkedList()
        inputStack.add(input)
    }

    constructor(instructions: List<Long>) {
        opcodes.addAll(instructions)
        inputStack = LinkedList()
    }

    constructor(instructions: List<Long>, input: Long) {
        opcodes.addAll(instructions)
        inputStack = LinkedList()
        inputStack.add(input)
    }

    var inputStack: LinkedList<Long>
    var opcodes = mutableListOf<Long>()
    var index = 0
    var output: Long = 0
    var relativeBase = 0

    fun addInput(addition: Long) {
        inputStack.add(addition)
    }

    fun processOpCodesInterrupt(): Pair<Boolean, Long> {
        var action = opcodes[index].toInt()

        while (action != 99) {

            var instructionLength = 4

            val param1Mode = action / 100 % 10
            val param2Mode = action / 1000 % 10
            val param3Mode = action / 10000 % 10
            action %= 10

            when (action) {
                1 -> {
                    val val1 = getOpcode(getIndex(param1Mode, 1))
                    val val2 = getOpcode(getIndex(param2Mode, 2))
                    setOpcode(getIndex(param3Mode, 3), val1 + val2)
                }
                2 -> {
                    val val1 = getOpcode(getIndex(param1Mode, 1))
                    val val2 = getOpcode(getIndex(param2Mode, 2))
                    setOpcode(getIndex(param3Mode, 3), val1 * val2)
                }
                3 -> {
                    instructionLength = 2
                    setOpcode(getIndex(param1Mode, 1), inputStack.poll())
                }
                4 -> {
                    output = opcodes[getIndex(param1Mode, 1)]
                    index += 2;
                    return Pair(false, output)
                }
                5 -> {
                    val val1 = getOpcode(getIndex(param1Mode, 1))
                    val val2 = getOpcode(getIndex(param2Mode, 2))
                    instructionLength = 3
                    if (val1 != 0.toLong()) {
                        instructionLength = 0
                        index = val2.toInt()
                    }
                }
                6 -> {
                    val val1 = getOpcode(getIndex(param1Mode, 1))
                    val val2 = getOpcode(getIndex(param2Mode, 2))
                    instructionLength = 3
                    if (val1 == 0.toLong()) {
                        instructionLength = 0
                        index = val2.toInt()
                    }
                }
                7 -> {
                    val val1 = getOpcode(getIndex(param1Mode, 1))
                    val val2 = getOpcode(getIndex(param2Mode, 2))
                    val value = if (val1 < val2) 1 else 0
                    setOpcode(getIndex(param3Mode, 3), value.toLong())
                }
                8 -> {
                    val val1 = getOpcode(getIndex(param1Mode, 1))
                    val val2 = getOpcode(getIndex(param2Mode, 2))
                    val value = if (val1 == val2) 1 else 0
                    setOpcode(getIndex(param3Mode, 3), value.toLong())
                }
                9 -> {
                    instructionLength = 2
                    relativeBase += getOpcode(getIndex(param1Mode, 1)).toInt()
                }

            }
            index += instructionLength;
            action = opcodes[index].toInt()
        }

        return Pair(true, output)
    }

    fun getOpcode(index: Int): Long {
        while (opcodes.size < index + 1) {
            opcodes.add(0)
        }
        return opcodes[index]
    }

    fun setOpcode(index: Int, value: Long) {
        while (opcodes.size < index + 1) {
            opcodes.add(0)
        }
        opcodes[index] = value
    }

    fun getIndex(mode: Int, offset: Int): Int {
        return when (mode) {
            0    -> opcodes[index + offset].toInt()
            1    -> index + offset
            2    -> relativeBase + opcodes[index + offset].toInt()
            else -> opcodes[index + offset].toInt()
        }
    }

}