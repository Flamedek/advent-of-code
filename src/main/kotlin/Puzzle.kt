import java.io.File

abstract class Puzzle(
    private val year: Int,
    private val day: Int
    ) : Runnable {

    override fun run() {
        println("\nPuzzle Day $day")
        solve()
    }

    abstract fun solve()

    protected fun printOne(result: Any) {
        println("Answer 1: $result")
    }

    protected fun printTwo(result: Any) {
        println("Answer 2: $result")
    }

    protected fun readInput(path: String): String {
        return File("./src/main/resources/input/$year")
            .resolve(path)
            .readText()
    }

}