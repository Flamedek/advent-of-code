package dec2022

import Puzzle
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import java.io.File
import kotlin.test.assertEquals

internal object Tests {

    @BeforeAll
    @JvmStatic
    fun before() {
        println("\n${"-".repeat(20)}")
        println("Advent Of Code 2022")
        println("-".repeat(20))
    }

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

    @AfterAll
    @JvmStatic
    fun after() {
        println("\n${"-".repeat(20)}\n")
    }

    private fun runWithResource(
        puzzle: Puzzle,
        resource: String = "day${puzzle.day}.txt",
        sourceSet: String? = "main"
    ) {
        val input = File("./src/$sourceSet/resources/input/${puzzle.year}/$resource").readText()
        runWithInput(puzzle, input)
    }

    private fun runWithInput(puzzle: Puzzle, input: String = "") {
        println("\nPuzzle Day ${puzzle.day}")

        val one = try {
            puzzle.partOne(input)
        } catch (e: NotImplementedError) {
            "Not yet implemented"
        }

        val two = try {
            puzzle.partTwo(input)
        } catch (e: NotImplementedError) {
            "Not yet implemented"
        }

        println("Answer 1: $one")
        println("Answer 2: $two")
    }

}