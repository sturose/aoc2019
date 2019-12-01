package aoc2019

class Day1 {

    fun totalFuelRequired(masses: List<Int>): Int {
        var total = 0
        for (mass in masses) {
            total += calcFuelRequired(mass)
        }
        return total
    }

    fun totalFuelRequiredPlusFuel(masses: List<Int>): Int {
        var total = 0
        for (mass in masses) {
            total += calcFuelRequiredPlusFuel(mass)
        }
        return total
    }

    fun calcFuelRequired(mass: Int): Int {
        return (mass / 3).minus(2).toInt()
    }

    fun calcFuelRequiredPlusFuel(mass: Int): Int {
        var total = 0
        var fraction = 0
        var remainder = mass
        do {
            fraction = calcFuelRequired(remainder)
            remainder = fraction
            if(fraction > 0) {
                total += fraction
            }
        } while ( fraction > 0)

        return total
    }
}