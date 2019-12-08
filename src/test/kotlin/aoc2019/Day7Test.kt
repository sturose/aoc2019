package aoc2019

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File
import java.util.stream.Collectors

class Day7Test {

    @Test
    fun testSample1() {
        val input = arrayListOf(3, 15, 3, 16, 1002, 16, 10, 16, 1, 16, 15, 15, 4, 15, 99, 0, 0)
        val phaseOrder = arrayListOf(4, 3, 2, 1, 0)
        val day7 = Day7(phaseOrder, input)
        assertEquals(43210, day7.process())
    }

    @Test
    fun testSample2() {
        val input = arrayListOf(3, 23, 3, 24, 1002, 24, 10, 24, 1002, 23, -1, 23, 101, 5, 23, 23, 1, 24, 23, 23, 4, 23, 99, 0, 0)
        val phaseOrder = arrayListOf(0, 1, 2, 3, 4)
        val day7 = Day7(phaseOrder, input)
        assertEquals(54321, day7.process())
    }

    @Test
    fun testSample3() {
        val input = arrayListOf(
            3, 31, 3, 32, 1002, 32, 10, 32, 1001, 31, -2, 31, 1007, 31, 0, 33,
            1002, 33, 7, 33, 1, 33, 31, 31, 1, 32, 31, 31, 4, 31, 99, 0, 0, 0
                               )
        val phaseOrder = arrayListOf(1, 0, 4, 3, 2)
        val day7 = Day7(phaseOrder, input)
        assertEquals(65210, day7.process())
    }

    @Test
    fun testProblem1() {
        val file = ClassLoader.getSystemResource("day7.txt").file
        val inputString = File(file).readText().trim()
        val input = inputString.split(',').stream().map { str -> str.toInt() }.collect(Collectors.toList())

        var largest = 0

        for (i in 0..4) {
            for (j in 0..4) {
                for (k in 0..4) {
                    for (l in 0..4) {
                        for (m in 0..4) {
                            val phaseOrder = arrayListOf(i, j, k, l, m)
                            if (phaseOrder.distinct().size == phaseOrder.size) {
                                val day7 = Day7(phaseOrder, ArrayList(input))
                                val output = day7.process()
                                if (output > largest) {
                                    largest = output
                                }
                            }
                        }
                    }
                }
            }
        }

        println("Day7Prob1: " + largest)
    }

    @Test
    fun testProb2Sample1() {
        val input = arrayListOf(
            3, 26, 1001, 26, -4, 26, 3, 27, 1002, 27, 2, 27, 1, 27, 26,
            27, 4, 27, 1001, 28, -1, 28, 1005, 28, 6, 99, 0, 0, 5
                               )
        val phaseOrder = arrayListOf(9, 8, 7, 6, 5)
        val day7 = Day7(phaseOrder, input)
        assertEquals(139629729, day7.feedback())
    }
}