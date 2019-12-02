package aoc2019

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File

internal class Day2Test {

    @Test
    fun testInit() {
        var day2 = Day2("1,9,10,3,2,3,11,0,99,30,40,50")
        assertEquals("[1, 9, 10, 3, 2, 3, 11, 0, 99, 30, 40, 50]", day2.opcodesString())
    }

    @Test
    fun testProcess() {
        var attempt1 = Day2("1,0,0,0,99")
        val processedOpCodes = attempt1.processOpCodes()
        assertEquals(2, processedOpCodes[0])

        var attempt2 = Day2("2,3,0,3,99")
        val processedOpCodes2 = attempt2.processOpCodes()
        assertEquals(2, processedOpCodes2[0])
        assertEquals(6, processedOpCodes2[3])
    }

    @Test
    fun day2problem1() {
        val file = ClassLoader.getSystemResource("day2.txt").file
        val inputString = File(file).readText().trim()

        var day2 = Day2(inputString)
        val processedOpCodes = day2.processOpCodes()
        println(processedOpCodes[0])

    }

    @Test
    fun day2problem2() {
        val file = ClassLoader.getSystemResource("day2.txt").file
        val inputString = File(file).readText().trim()
        for (noun in 0..99) {
            for (verb in 0..99) {
                var day2 = Day2(inputString)
                day2.editNounAndVerb(noun, verb)
                val processedOpCodes = day2.processOpCodes()
                if (processedOpCodes[0] == 19690720) {
                    println(noun * 100 + verb)
                }
            }
        }
    }
}