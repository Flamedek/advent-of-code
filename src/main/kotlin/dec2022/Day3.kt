package dec2022

import Puzzle

/**
 * https://adventofcode.com/2022/day/3
 */
class Day3 : Puzzle(2022, 3) {

    override fun partOne(input: String): Any {
        return input.lineSequence()
            .map(::findSharedItemPerLine)
            .map(::scoreForItem)
            .sum()
    }

    override fun partTwo(input: String): Any {
        return input.lineSequence()
            .chunked(3)
            .filter { it.size == 3 }
            .map(::findSharedItemInGroups)
            .map(::scoreForItem)
            .sum()
    }

    private fun findSharedItemPerLine(line: String): Char {
        val parts = line.toList().chunked(line.length / 2)
        return parts[0].find { it in parts[1] } ?: error("No shared items")
    }

    private fun findSharedItemInGroups(group: List<String>): Char {
        val chars = group[0].toHashSet()
        group.drop(1).map{ it.toList() }.forEach(chars::retainAll)
        return chars.singleOrNull() ?: error("Not exactly one shared item")
    }

    private fun scoreForItem(char: Char): Int {
        return if (char.isUpperCase()) {
            char - 'A' + 26 + 1
        } else {
            char - 'a' + 1
        }
    }
}
