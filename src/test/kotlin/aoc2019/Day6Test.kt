package aoc2019

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File

class Day6Test {

    @Test
    fun testSample() {
        val day6 = Day6(
            "COM)B\n" +
                    "B)C\n" +
                    "C)D\n" +
                    "D)E\n" +
                    "E)F\n" +
                    "B)G\n" +
                    "G)H\n" +
                    "D)I\n" +
                    "E)J\n" +
                    "J)K\n" +
                    "K)L"
                       )

        assertEquals(42, day6.getDepth())
    }

    @Test
    fun testProblems() {
        val file = ClassLoader.getSystemResource("day6.txt").file
        val inputString = File(file).readText().trim()
        val day6 = Day6(inputString)

        println("Day6Problem1: " + day6.getDepth())
        println("Day6Problem2: " + day6.getTransferCount("YOU", "SAN"))
    }

    @Test
    fun testSample2() {
        val day6 = Day6(
            "COM)B\n" +
                    "B)C\n" +
                    "C)D\n" +
                    "D)E\n" +
                    "E)F\n" +
                    "B)G\n" +
                    "G)H\n" +
                    "D)I\n" +
                    "E)J\n" +
                    "J)K\n" +
                    "K)L\n" +
                    "K)YOU\n" +
                    "I)SAN"
                       )

        assertEquals(54, day6.getDepth())
        assertEquals(4, day6.getTransferCount("YOU", "SAN"))
    }
}