package aoc2019

import java.util.*

class Day7 {


    private var phaseOrder: ArrayList<Long>
    private var input: ArrayList<Long>

    constructor(
        phaseOrder: ArrayList<Long>,
        input: ArrayList<Long>
               ) {
        this.phaseOrder = phaseOrder
        this.input = input
    }

    fun process(): Long {
        var output: Long = 0
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

    fun feedback(): Long {
        var output: Pair<Boolean, Long> = Pair(false, 0)
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