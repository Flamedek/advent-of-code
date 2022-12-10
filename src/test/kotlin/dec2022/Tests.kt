package dec2022

import TestRunner
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class Tests : TestRunner() {

    @Test
    fun day1() = runWithResource(Day1())

    @Test
    fun day2() = runWithResource(Day2())

    @Test
    fun day3() = runWithResource(Day3())

    @Test
    fun day4() {
        val puzzle = Day4()
        val input = "2-4,6-8\n2-3,4-5\n5-7,7-9\n2-8,3-7\n6-6,4-6\n2-6,4-8"
        assertEquals(2, puzzle.partOne(input))
        assertEquals(4, puzzle.partTwo(input))

        runWithResource(puzzle)
    }

    @Test
    fun day5() {
        val puzzle = Day5()
        val input = "    [D]    \n[N] [C]    \n[Z] [M] [P]\n 1   2   3 \n" +
                "\nmove 1 from 2 to 1\nmove 3 from 1 to 3\nmove 2 from 2 to 1\nmove 1 from 1 to 2"

        assertEquals("CMZ", puzzle.partOne(input))
        assertEquals("MCD", puzzle.partTwo(input))

        runWithResource(puzzle)
    }

    @Test
    fun day6() {
        val puzzle = Day6()

        assertEquals(7, puzzle.partOne("mjqjpqmgbljsphdztnvjfqwrcgsmlb"))
        assertEquals(5, puzzle.partOne("bvwbjplbgvbhsrlpgdmjqwftvncz"))
        assertEquals(10, puzzle.partOne("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg"))

        assertEquals(19, puzzle.partTwo("mjqjpqmgbljsphdztnvjfqwrcgsmlb"))
        assertEquals(23, puzzle.partTwo("bvwbjplbgvbhsrlpgdmjqwftvncz"))
        assertEquals(29, puzzle.partTwo("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg"))

        runWithResource(puzzle)
    }


}