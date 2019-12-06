package aoc2019

class Day4 {


    fun passwordsInRange(start: Int, end: Int): Int {
        var total = 0
        for (range in start..end) {
            if (validPassword(range.toString())) {
                total++
            }
        }
        return total
    }

    fun validPassword(input: String): Boolean {
        var numbers = input.map { Character.getNumericValue(it) }
        var repeated = false
        var increases = true
        var lastNumber = -1
        for (number in numbers) {
            if (number == lastNumber) {
                repeated = true
            }
            if (number < lastNumber) {
                increases = false
                break
            }
            lastNumber = number
        }
        return (increases && repeated)
    }

    fun passwordsInRange2(start: Int, end: Int): Int {
        var total = 0
        for (range in start..end) {
            if (validPassword2(range.toString())) {
                total++
            }
        }
        return total
    }

    fun validPassword2(input: String): Boolean {
        var numbers = input.map { Character.getNumericValue(it) }
        var repeated = false
        var increases = true
        var lastNumber = -1
        var repeatCount = 0
        for (number in numbers) {
            if (number == lastNumber) {
                repeatCount++
            } else {
                if (repeatCount == 1) {
                    repeated = true
                }
                repeatCount = 0
            }
            if (number < lastNumber) {
                increases = false
                break
            }
            lastNumber = number
        }
        if (repeatCount == 1) {
            repeated = true
        }
        return (increases && repeated)
    }

}