import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import java.io.File
import java.io.IOException

open class TestRunner {

    fun Puzzle.runWithResource(
        resource: String = "day${day}.txt",
        sourceSet: String? = "main"
    ) {
        val input = readInput(resource, sourceSet) ?: return

        println("\nPuzzle Day $day")

        val one = try {
            partOne(input)
        } catch (e: NotImplementedError) {
            "Not yet implemented"
        }

        val two = try {
            partTwo(input)
        } catch (e: NotImplementedError) {
            "Not yet implemented"
        }

        println("Answer 1: $one")
        println("Answer 2: $two")
    }

    fun Puzzle.readInput(
        resource: String = "day${day}.txt",
        sourceSet: String? = "main"
    ) = try {
        File("./src/$sourceSet/resources/input/$year/$resource").readText()
    } catch (e: IOException) {
        null
    }

    fun Puzzle.testInput() = readInput(sourceSet = "test")!!

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