package dec2022

import Puzzle

/**
 * https://adventofcode.com/2022/day/2
 */
class Day2 : Puzzle(2022, 2) {

    override fun solve() {
        val input = readInput("day2.txt")
        val lines = input.lines()

        printOne(part1(lines))
        printTwo(part2(lines))
    }

    private fun part1(list: List<String>) = list.sumOf(::pointsForRoundPart1)

    private fun pointsForRoundPart1(line: String): Int {
        val them = line.first() - 'A'
        val you = line.last() - 'X'
        val result = when {
            them == you -> 3
            you - 1 == them -> 6
            you - 1 == them - 3 -> 6
            else -> 0
        }

        return result + (you + 1)
    }

    private fun part2(list: List<String>) =  list.sumOf(::pointsForRoundPart2)

    private fun pointsForRoundPart2(line: String): Int {
        val them = line.first() - 'A'
        val result = line.last() - 'X'
        val you = them + (result - 1)
        val wrapped = if (you < 0) you + 3 else you % 3

        return result * 3 + (wrapped + 1)
    }

}
