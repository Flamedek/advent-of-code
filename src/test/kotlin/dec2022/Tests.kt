package dec2022

import TestRunner
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class Tests : TestRunner() {

    @Test
    fun day1() = Day1().runWithResource()

    @Test
    fun day2() = Day2().runWithResource()

    @Test
    fun day3() = Day3().runWithResource()

    @Test
    fun day4() = with(Day4()) {
        val input = "2-4,6-8\n2-3,4-5\n5-7,7-9\n2-8,3-7\n6-6,4-6\n2-6,4-8"
        assertEquals(2, partOne(input))
        assertEquals(4, partTwo(input))

        runWithResource()
    }

    @Test
    fun day5() = with(Day5()) {
        val input = "    [D]    \n[N] [C]    \n[Z] [M] [P]\n 1   2   3 \n" +
                "\nmove 1 from 2 to 1\nmove 3 from 1 to 3\nmove 2 from 2 to 1\nmove 1 from 1 to 2"

        assertEquals("CMZ", partOne(input))
        assertEquals("MCD", partTwo(input))

        runWithResource()
    }

    @Test
    fun day6() = with(Day6()) {
        assertEquals(7,partOne("mjqjpqmgbljsphdztnvjfqwrcgsmlb"))
        assertEquals(5,partOne("bvwbjplbgvbhsrlpgdmjqwftvncz"))
        assertEquals(10, partOne("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg"))

        assertEquals(19, partTwo("mjqjpqmgbljsphdztnvjfqwrcgsmlb"))
        assertEquals(23, partTwo("bvwbjplbgvbhsrlpgdmjqwftvncz"))
        assertEquals(29, partTwo("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg"))
        
        runWithResource()
    }


}