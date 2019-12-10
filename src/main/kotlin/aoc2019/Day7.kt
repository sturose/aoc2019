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
            val day5 = Day5(input, phase)
            day5.addInput(output)
            do {
                val result = day5.processOpCodesInterrupt()
                output = result.second
            } while (!result.first)
        }
        return output
    }

    fun feedback(): Int {
        var output = Pair(false, 0)
        var amps = mutableListOf<Day5>()
        for (phase in phaseOrder) {
            val day5 = Day5(input, phase)
            amps.add(day5)
        }
        while (!output.first) {
            for (amp in amps) {
                amp.addInput(output.second)
                output = amp.processOpCodesInterrupt()
            }
        }
        return output.second
    }
}