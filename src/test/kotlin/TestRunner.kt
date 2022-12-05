import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import java.io.File

open class TestRunner {

    fun runWithResource(
        puzzle: Puzzle,
        resource: String = "day${puzzle.day}.txt",
        sourceSet: String? = "main"
    ) {
        val input = File("./src/$sourceSet/resources/input/${puzzle.year}/$resource").readText()
        runWithInput(puzzle, input)
    }

    fun runWithInput(puzzle: Puzzle, input: String = "") {
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

    companion object {

        @BeforeAll
        @JvmStatic
        fun before() {
            println("\n${"-".repeat(20)}")
            println("Advent Of Code 2022")
            println("-".repeat(20))
        }


        @AfterAll
        @JvmStatic
        fun after() {
            println("\n${"-".repeat(20)}\n")
        }
    }

}