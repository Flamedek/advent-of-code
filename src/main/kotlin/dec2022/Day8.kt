package dec2022

import Puzzle
import kotlin.math.max

class Day8 : Puzzle(2022, 8) {

    override fun partOne(input: String): Any {
        val field = parseField(input)
        var count = 0
        for (x in field[0].indices) {
            for (y in field.indices) {
                if (hasLos(field, x, y)) {
                    count++
                }
            }
        }
        return count
    }


    override fun partTwo(input: String): Any {
        val field = parseField(input)
        var max = 0
        for (x in field[0].indices) {
            for (y in field.indices) {
                max = max(max, getScenicScore(field, x, y))
            }
        }
        return max
    }

    private fun parseField(input: String): Array<Array<Int>> {
        val lines = input.lines()
        val cols = lines[0].length
        val rows = lines.size

        return Array(cols) { x -> Array(rows) { y -> lines[y][x].digitToInt() } }
    }

    private fun hasLos(field: Array<Array<Int>>, x: Int, y: Int): Boolean {
        val maxX = field[0].lastIndex
        val maxY = field.lastIndex
        if (x == 0 || x == maxX || y == 0 || y == maxY) {
            // outer edges
            return true
        }
        val height = field[x][y]
        val visibility = Array(4) { true }
        // left
        for (i in 0 until x) {
            if (field[i][y] >= height) {
                visibility[0] = false
                break
            }
        }
        // right
        for (i in x + 1 .. maxX) {
            if (field[i][y] >= height) {
                visibility[1] = false
                break
            }
        }
        // up
        for (j in 0 until y) {
            if (field[x][j] >= height) {
                visibility[2] = false
                break
            }
        }
        // down
        for (j in y + 1 .. maxY) {
            if (field[x][j] >= height) {
                visibility[3] = false
                break
            }
        }
        return visibility.any { it }
    }

    private fun getScenicScore(field: Array<Array<Int>>, x: Int, y: Int): Int {
        val maxX = field[0].lastIndex
        val maxY = field.lastIndex

        val height = field[x][y]
        val scores = Array(4) { 0 }
        // left
        for (i in x - 1 downTo  0) {
            scores[0]++
            if (field[i][y] >= height) {
                break
            }
        }
        // right
        for (i in x + 1 .. maxX) {
            scores[1]++
            if (field[i][y] >= height) {
                break
            }
        }
        // up
        for (j in y - 1 downTo 0 ) {
            scores[2]++
            if (field[x][j] >= height) {
                break
            }
        }
        // down
        for (j in y + 1 .. maxY) {
            scores[3]++
            if (field[x][j] >= height) {
                break
            }
        }
        return scores.fold(1) { acc, i -> i * acc }
    }

}