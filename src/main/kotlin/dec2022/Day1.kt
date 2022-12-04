package dec2022

import Puzzle

/**
 * https://adventofcode.com/2022/day/1
 */
class Day1 : Puzzle(2022, 1) {

    override fun partOne(input: String): Any {
        val list = groupNumbers(input)
        return list.max()
    }

    override fun partTwo(input: String): Any {
        val list = groupNumbers(input)
        return list.sortedDescending().take(3).sum()
    }

    private fun groupNumbers(input: String) = buildList {
        input.lines().fold(0) { acc, line ->
            val num = line.toIntOrNull()
            if (num != null) {
                acc + num
            } else {
                add(acc)
                0
            }
        }
    }
}
