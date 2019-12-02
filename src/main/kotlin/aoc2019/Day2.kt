package aoc2019


class Day2 {

    constructor(input: String) {
        opcodes = input.split(",").map { it.trim().toInt() }.toMutableList()
    }

    var opcodes = mutableListOf<Int>()

    fun opcodesString(): String {
        return opcodes.toIntArray().contentToString()
    }

    fun editNounAndVerb(noun: Int, verb: Int) {
        opcodes[1] = noun
        opcodes[2] = verb
    }

    fun processOpCodes(): MutableList<Int> {
        val newcodes = opcodes.toMutableList()
        var index = 0
        var action = newcodes[index]

        while(action != 99){
            val val1 = newcodes[newcodes[index +1]]
            val val2 = newcodes[newcodes[index +2]]
            val position = newcodes[index +3]
            when(action){
                1 -> newcodes[position] = val1 + val2
                2 -> newcodes[position] = val1 * val2

            }
            index = index + 4;
            action = newcodes[index]
        }

        return newcodes
    }

}