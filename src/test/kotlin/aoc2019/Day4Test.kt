package aoc2019

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class Day4Test {

    @Test
    fun testValidPassword() {
        val day4 = Day4()
        assertTrue(day4.validPassword("122345"))
        assertFalse(day4.validPassword("135679"))
        assertTrue(day4.validPassword("111111"))
        assertFalse(day4.validPassword("223450"))
    }


    @Test
    fun testPasswordsInRange() {
        val day4 = Day4()
        println("Day4Problem1: " + day4.passwordsInRange(307237, 769058))
    }

    @Test
    fun testValidPassword2() {
        val day4 = Day4()
        assertTrue(day4.validPassword2("122345"))
        assertTrue(day4.validPassword2("112233"))
        assertTrue(day4.validPassword2("111122"))
        assertFalse(day4.validPassword2("123444"))
        assertFalse(day4.validPassword2("135679"))
        assertFalse(day4.validPassword2("111111"))
        assertFalse(day4.validPassword2("223450"))
    }


    @Test
    fun testPasswordsInRange2() {
        val day4 = Day4()
        println("Day4Problem2: " + day4.passwordsInRange2(307237, 769058))
    }
}