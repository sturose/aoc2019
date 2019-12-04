package aoc2019

import kotlin.math.abs

class Day3 {
    constructor(gridSize: Int) {
        this.gridSize = gridSize
        wire1x = gridSize / 2
        wire1y = gridSize / 2
        wire2x = gridSize / 2
        wire2y = gridSize / 2


        grid = Array(gridSize) { BooleanArray(gridSize) }

    }

    private var gridSize: Int
    private var wire1x: Int
    private var wire1y: Int
    private var wire2x: Int
    private var wire2y: Int

    private var grid: Array<BooleanArray>

    val crosses = mutableListOf<Pair<Int, Int>>()


    fun leastDistance(): Int {
        var lowest = Int.MAX_VALUE
        for (cross in crosses) {
            val value = abs(cross.first - (gridSize / 2)) + abs(cross.second - (gridSize / 2))
            if (value <= lowest) {
                lowest = value
            }
        }
        return lowest
    }


    fun addWire(occupation: Int, directions: String) {

        var wireX: Int
        var wireY: Int
        if (occupation == 1) {
            wireX = wire1x
            wireY = wire1y
        } else {
            wireX = wire2x
            wireY = wire2y
        }

        val split = directions.split(",")
        for (vector in split) {
            val direction = vector[0]
            val distance = vector.substring(1).toInt()
            for (range in 1..distance) {
                when (direction) {
                    'U' -> wireX++
                    'D' -> wireX--
                    'R' -> wireY++
                    'L' -> wireY--
                }
                if (occupation == 1) {
                    grid[wireX][wireY] = true
                } else if (occupation == 2 && grid[wireX][wireY]) {
                    crosses.add(Pair(wireX, wireY))
                }
            }
        }
    }

    fun shortestIntersection(directions1: String, directions2: String): Int {
        var lowest = Int.MAX_VALUE
        for (cross in crosses) {
            val steps1 = stepsUntilIntersection(1, directions1, cross)
            val steps2 = stepsUntilIntersection(2, directions2, cross)
            val total = steps1 + steps2
            if (lowest > total) {
                lowest = total
            }
        }

        return lowest
    }

    fun stepsUntilIntersection(occupation: Int, directions: String, intersection: Pair<Int, Int>): Int {
        var wireX = gridSize / 2
        var wireY = gridSize / 2
        var count = 0

        val split = directions.split(",")
        for (vector in split) {
            val direction = vector[0]
            val distance = vector.substring(1).toInt()
            for (range in 1..distance) {
                when (direction) {
                    'U' -> wireX++
                    'D' -> wireX--
                    'R' -> wireY++
                    'L' -> wireY--
                }
                count++
                if (wireX == intersection.first && wireY == intersection.second) {
                    return count
                }
            }
        }
        return 0
    }
}