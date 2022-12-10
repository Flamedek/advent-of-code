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

    @Test
    fun day7() = with(Day7()) {
        val input = "\$ cd /\n" +
                "\$ ls\n" +
                "dir a\n" +
                "14848514 b.txt\n" +
                "8504156 c.dat\n" +
                "dir d\n" +
                "\$ cd a\n" +
                "\$ ls\n" +
                "dir e\n" +
                "29116 f\n" +
                "2557 g\n" +
                "62596 h.lst\n" +
                "\$ cd e\n" +
                "\$ ls\n" +
                "584 i\n" +
                "\$ cd ..\n" +
                "\$ cd ..\n" +
                "\$ cd d\n" +
                "\$ ls\n" +
                "4060174 j\n" +
                "8033020 d.log\n" +
                "5626152 d.ext\n" +
                "7214296 k"

        assertEquals(95437L, partOne(input))
        assertEquals(24933642L, partTwo(input))

        runWithResource()
    }

}