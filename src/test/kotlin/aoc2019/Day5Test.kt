package aoc2019

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.io.File

class Day5Test {


    @Test
    fun testProcess() {
        var attempt1 = Day5("3,0,4,0,99", 5)
        val processedOpCodes = attempt1.processOpCodes()
        Assertions.assertEquals(5, processedOpCodes)

        var attempt2 = Day5("3,0,4,0,99", 8)
        val processedOpCodes2 = attempt2.processOpCodes()
        Assertions.assertEquals(8, processedOpCodes2)
    }

    @Test
    fun testImmediateMode() {
        var attempt1 = Day5("1002,4,3,4,33", 5)
        val processedOpCodes = attempt1.processOpCodes()
        Assertions.assertEquals(5, processedOpCodes)
    }

    @Test
    fun day5problem1() {
        val file = ClassLoader.getSystemResource("day5.txt").file
        val inputString = File(file).readText().trim()

        var day5 = Day5(inputString, 1)
        val processedOpCodes = day5.processOpCodes()
        println(processedOpCodes)

    }

    @Test
    fun testProcess2() {
        var attempt1 = Day5("3,9,8,9,10,9,4,9,99,-1,8", 8)
        var processedOpCodes = attempt1.processOpCodes()
        Assertions.assertEquals(1, processedOpCodes)

        attempt1 = Day5("3,9,8,9,10,9,4,9,99,-1,8", 12)
        processedOpCodes = attempt1.processOpCodes()
        Assertions.assertEquals(0, processedOpCodes)

        attempt1 = Day5("3,9,7,9,10,9,4,9,99,-1,8", 7)
        processedOpCodes = attempt1.processOpCodes()
        Assertions.assertEquals(1, processedOpCodes)

        attempt1 = Day5("3,9,7,9,10,9,4,9,99,-1,8", 8)
        processedOpCodes = attempt1.processOpCodes()
        Assertions.assertEquals(0, processedOpCodes)

        attempt1 = Day5("3,3,1108,-1,8,3,4,3,99", 8)
        processedOpCodes = attempt1.processOpCodes()
        Assertions.assertEquals(1, processedOpCodes)

        attempt1 = Day5("3,3,1108,-1,8,3,4,3,99", 18)
        processedOpCodes = attempt1.processOpCodes()
        Assertions.assertEquals(0, processedOpCodes)


        attempt1 = Day5(
            "3,21,1008,21,8,20,1005,20,22,107,8,21,20,1006,20,31,1106,0,36,98,0,0,1002,21,125,20,4,20,1105,1,46,104,999,1105,1,46,1101,1000,1,20,4,20,1105,1,46,98,99",
            5
                       )
        processedOpCodes = attempt1.processOpCodes()
        Assertions.assertEquals(999, processedOpCodes)


        attempt1 = Day5(
            "3,21,1008,21,8,20,1005,20,22,107,8,21,20,1006,20,31,1106,0,36,98,0,0,1002,21,125,20,4,20,1105,1,46,104,999,1105,1,46,1101,1000,1,20,4,20,1105,1,46,98,99",
            8
                       )
        processedOpCodes = attempt1.processOpCodes()
        Assertions.assertEquals(1000, processedOpCodes)


        attempt1 = Day5(
            "3,21,1008,21,8,20,1005,20,22,107,8,21,20,1006,20,31,1106,0,36,98,0,0,1002,21,125,20,4,20,1105,1,46,104,999,1105,1,46,1101,1000,1,20,4,20,1105,1,46,98,99",
            15
                       )
        processedOpCodes = attempt1.processOpCodes()
        Assertions.assertEquals(1001, processedOpCodes)

    }

    @Test
    fun testJumpTests() {

        var attempt1 = Day5("3,12,6,12,15,1,13,14,13,4,13,99,-1,0,1,9", 0)
        var processedOpCodes = attempt1.processOpCodes()
        Assertions.assertEquals(0, processedOpCodes)

        attempt1 = Day5("3,12,6,12,15,1,13,14,13,4,13,99,-1,0,1,9", 6)
        processedOpCodes = attempt1.processOpCodes()
        Assertions.assertEquals(1, processedOpCodes)

        attempt1 = Day5("3,3,1105,-1,9,1101,0,0,12,4,12,99,1", 6)
        processedOpCodes = attempt1.processOpCodes()
        Assertions.assertEquals(1, processedOpCodes)

        attempt1 = Day5("3,3,1105,-1,9,1101,0,0,12,4,12,99,1", 0)
        processedOpCodes = attempt1.processOpCodes()
        Assertions.assertEquals(0, processedOpCodes)
    }

    @Test
    fun day5problem2() {
        val file = ClassLoader.getSystemResource("day5.txt").file
        val inputString = File(file).readText().trim()

        var day5 = Day5(inputString, 5)
        val processedOpCodes = day5.processOpCodes()
        println(processedOpCodes)

    }
}