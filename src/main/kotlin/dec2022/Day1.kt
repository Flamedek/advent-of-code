package dec2022

import Puzzle

/**
 * https://adventofcode.com/2022/day/1
 */
class Day1 : Puzzle(2022, 1) {

    override fun solve() {
        val input = readInput("day1.txt")
        val list = groupNumbers(input)

        printOne(part1(list))
        printTwo(part2(list))
    }

    private fun part1(list: List<Int>) = list.max()

    private fun part2(list: List<Int>) = list.sortedDescending().take(3).sum()

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
