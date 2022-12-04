import java.io.File

abstract class Puzzle(val year: Int, val day: Int) {

    abstract fun partOne(input: String): Any

    open fun partTwo(input: String): Any = TODO("Not yet implemented")

    protected fun readInput(path: String): String {
        return File("./src/main/resources/input/$year")
            .resolve(path)
            .readText()
    }

}