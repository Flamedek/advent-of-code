package dec2022

import Puzzle

class Day4 : Puzzle(2022, 4) {

    override fun partOne(input: String): Any {
        return input.lineSequence()
            .map(::parseRanges)
            .count { (one, two) -> fullyOverlaps(one, two) }
    }

    override fun partTwo(input: String): Any {
        return input.lineSequence()
            .map(::parseRanges)
            .count { (one, two) -> partlyOverlaps(one, two) }
    }

    private fun fullyOverlaps(one: IntRange, two: IntRange): Boolean {
        return (one.first >= two.first && one.last <= two.last) ||
                (two.first >= one.first && two.last <= one.last)
    }

    private fun partlyOverlaps(one: IntRange, two: IntRange): Boolean {
        return one.first in two || one.last in two || two.first in one || two.last in one
    }

    private fun parseRanges(line: String): Pair<IntRange, IntRange> {
        return line.split(",")
            .map { part -> part.split("-")}
            .map { part -> part[0].toInt().rangeTo(part[1].toInt()) }
            .let { it[0] to it[1] }
    }
}