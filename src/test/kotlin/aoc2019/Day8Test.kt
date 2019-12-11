package aoc2019

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import java.io.File
import java.util.stream.Collectors

class Day8Test {

    @Test
    fun sample1() {
        val input = "123456789012"
        val pixelWidth = 3
        val pixelDepth = 2
        val day8 = Day8(input, pixelWidth, pixelDepth)
        assertNotNull(day8)
        val leastOccurrences = day8.getLeastOccurrences(0)

        val oneDigits = leastOccurrences.filter { it == 1 }.size
        val twoDigits = leastOccurrences.filter { it == 4 }.size

        assertEquals(1, twoDigits)
        assertEquals(1, oneDigits)


    }

    @Test
    fun problem1() {

        val file = ClassLoader.getSystemResource("day8.txt").file
        val input = File(file).readText().trim()
        val pixelWidth = 25
        val pixelDepth = 6
        val day8 = Day8(input, pixelWidth, pixelDepth)
        assertNotNull(day8)
        val leastOccurrences = day8.getLeastOccurrences(0)
        val oneDigits = leastOccurrences.filter { it == 1 }.size
        val twoDigits = leastOccurrences.filter { it == 2 }.size
        println( "Day8Problem1: " + oneDigits * twoDigits)

    }

    @Test
    fun problem2() {

        val file = ClassLoader.getSystemResource("day8.txt").file
        val input = File(file).readText().trim()
        val pixelWidth = 25
        val pixelDepth = 6
        val day8 = Day8(input, pixelWidth, pixelDepth)
        day8.print()
    }
}