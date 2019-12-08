package aoc2019

import java.util.*

class Day7 {


    private var phaseOrder: ArrayList<Int>
    private var input: ArrayList<Int>

    constructor(
        phaseOrder: ArrayList<Int>,
        input: ArrayList<Int>
               ) {
        this.phaseOrder = phaseOrder
        this.input = input
    }

    fun process(): Int {
        var output = 0
        for (phase in phaseOrder) {
            val stack = Stack<Int>()
            stack.push(output)
            stack.push(phase)
            val day5 = Day5(input, stack)
            output = day5.processOpCodes()
        }
        return output
    }

    fun feedback(): Int {
        var stack = Stack<Int>()
        stack.push(0)
        var output = Pair(true, stack)
        var amps = mutableListOf<Day5>()
        for (phase in phaseOrder) {
            val stack = Stack<Int>()
            val day5 = Day5(input, stack)
            amps.add(day5)
        }
        var firstRun = true
        var count = 0
        while (output.first) {
            for (amp in amps) {
                if (firstRun) {
                    amp.inputStack.push(phaseOrder[count])
                }
                for (value in output.second) {
                    amp.inputStack.push(value)
                }
                output = amp.processOpCodesInterrupt()
                count += 1
                if (!output.first) {
                    return output.second[0]
                }
            }
            firstRun = false
            count = 0
        }
        return output.second[0]
    }
}