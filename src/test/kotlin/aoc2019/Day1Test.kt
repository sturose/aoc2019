package aoc2019

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.io.File

internal class Day1Test {

    @Test
    fun calcFuelRequired() {
        var day1 = Day1()
        assertEquals(2, day1.calcFuelRequired(12))
        assertEquals(2, day1.calcFuelRequired(14))
        assertEquals(654, day1.calcFuelRequired(1969))
        assertEquals(33583, day1.calcFuelRequired(100756))
    }

    @Test
    fun calcFuelRequiredWithFuel() {
        var day1 = Day1()
        assertEquals(2, day1.calcFuelRequiredPlusFuel(12))
        assertEquals(2, day1.calcFuelRequiredPlusFuel(14))
        assertEquals(966, day1.calcFuelRequiredPlusFuel(1969))
        assertEquals(50346, day1.calcFuelRequiredPlusFuel(100756))
    }

    @Test
    fun day1test1() {
        val file = ClassLoader.getSystemResource("day1.txt").file
        val inputString = File(file).readText().trim()
        val lines = inputString.split("\n")
        var masses = mutableListOf<Int>()
        for (line in lines) {
            val numbersString = line.split(' ')
            var value = numbersString[0].toInt()
            masses.add(value)
        }


        var day1 = Day1()

        println(day1.totalFuelRequired(masses))
    }

    @Test
    fun day1test2() {
        val file = ClassLoader.getSystemResource("day1.txt").file
        val inputString = File(file).readText().trim()
        val lines = inputString.split("\n")
        var masses = mutableListOf<Int>()
        for (line in lines) {
            val numbersString = line.split(' ')
            var value = numbersString[0].toInt()
            masses.add(value)
        }


        var day1 = Day1()

        println(day1.totalFuelRequiredPlusFuel(masses))
    }
}