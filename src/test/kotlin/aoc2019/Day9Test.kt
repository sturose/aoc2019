package aoc2019

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.io.File
import java.util.stream.Collectors

class Day9Test {

    @Test
    fun testProcessDay9_1() {
        val input = arrayListOf<Long>(104, 1125899906842624, 99)
        var attempt1 = Day5(input)
        var processedOpCodes = attempt1.processOpCodesInterrupt()
        while (!processedOpCodes.first) {
            processedOpCodes = attempt1.processOpCodesInterrupt()
        }
        Assertions.assertEquals(1125899906842624, processedOpCodes.second)
    }

    @Test
    fun testProcessDay9_2() {
        val input = arrayListOf<Long>(1102, 34915192, 34915192, 7, 4, 7, 99, 0)
        var attempt1 = Day5(input)
        var processedOpCodes = attempt1.processOpCodesInterrupt()
        while (!processedOpCodes.first) {
            processedOpCodes = attempt1.processOpCodesInterrupt()
        }
        Assertions.assertEquals(1219070632396864, processedOpCodes.second)
    }

    @Test
    fun testProcessDay9_26() {
        val input = arrayListOf<Long>(109, 12, 204, -11, 99)
        var attempt1 = Day5(input)
        var processedOpCodes = attempt1.processOpCodesInterrupt()
        while (!processedOpCodes.first) {
            processedOpCodes = attempt1.processOpCodesInterrupt()
        }
        Assertions.assertEquals(12, processedOpCodes.second)
    }

    @Test
    fun testProcessDay9_3() {
        val input = arrayListOf<Long>(109, 1, 204, -1, 1001, 100, 1, 100, 1008, 100, 16, 101, 1006, 101, 0, 99)
        var attempt1 = Day5(input)
        var processedOpCodes = attempt1.processOpCodesInterrupt()
        Assertions.assertEquals(109, processedOpCodes.second)
        processedOpCodes = attempt1.processOpCodesInterrupt()
        Assertions.assertEquals(1, processedOpCodes.second)
        processedOpCodes = attempt1.processOpCodesInterrupt()
        Assertions.assertEquals(204, processedOpCodes.second)
        processedOpCodes = attempt1.processOpCodesInterrupt()
        Assertions.assertEquals(-1, processedOpCodes.second)
    }

    @Test
    fun problem1() {
        val file = ClassLoader.getSystemResource("day9.txt").file
        val inputString = File(file).readText().trim()
        val input = inputString.split(',').stream().map { str -> str.toLong() }.collect(Collectors.toList())
        var attempt1 = Day5(input, 1)
        var processedOpCodes = attempt1.processOpCodesInterrupt()
        while (!processedOpCodes.first) {
            processedOpCodes = attempt1.processOpCodesInterrupt()
        }
        Assertions.assertEquals(2494485073, processedOpCodes.second)
    }

    @Test
    fun problem2() {
        val file = ClassLoader.getSystemResource("day9.txt").file
        val inputString = File(file).readText().trim()
        val input = inputString.split(',').stream().map { str -> str.toLong() }.collect(Collectors.toList())
        var attempt1 = Day5(input, 2)
        var processedOpCodes = attempt1.processOpCodesInterrupt()
        while (!processedOpCodes.first) {
            processedOpCodes = attempt1.processOpCodesInterrupt()
        }
        Assertions.assertEquals(44997, processedOpCodes.second)
    }


}