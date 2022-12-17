package dec2022

import Puzzle
import kotlin.math.abs
import kotlin.math.sign

class Day9 : Puzzle(2022, 9) {

    override fun partOne(input: String): Any {
        val board = Board(2)
        executeInstructions(board, input.lines())
        return board.visitedCells.size
    }

    override fun partTwo(input: String): Any {
        val board = Board(10)
        executeInstructions(board, input.lines())
        return board.visitedCells.size
    }

    private fun executeInstructions(board: Board, instructions: List<String>) {
        for (instruction in instructions) {
            val (dir, count) = instruction.split(' ')
            val amount = count.toInt()
            when (dir) {
                "L" -> board.moveHead(-amount, 0)
                "U" -> board.moveHead(0, -amount)
                "R" -> board.moveHead(amount, 0)
                "D" -> board.moveHead(0, amount)
            }
        }
    }

    class Board(knots: Int = 2) {

        private val stack = MutableList(knots) { Cell(0, 0) }

        private val head get() = stack.first()
        private val tail get() = stack.last()

        val visitedCells = hashSetOf(tail)

        fun moveHead(dx: Int, dy: Int) {
            if (dx != 0) {
                repeat(abs(dx)) { moveStep(dx.sign, 0) }
            }
            if (dy != 0) {
                repeat(abs(dy)) { moveStep(0, dy.sign) }
            }
        }

        private fun moveStep(dx: Int, dy: Int) {
            stack[0] = head.moved(dx, dy)

            for (i in 1 .. stack.lastIndex) {
                stack[i] = stack[i].movedTowards(stack[i - 1])
            }

            visitedCells += tail
        }
    }

    data class Cell(val x: Int, val y: Int) {

        fun moved(dX: Int, dy: Int) = Cell(x + dX, y + dy)

        fun movedTowards(parent: Cell): Cell {
            val dX = parent.x - x
            val dY = parent.y - y
            if (abs(dX) > 1 || abs(dY) > 1) {
                return moved(dX.sign, dY.sign)
            }
            return this
        }

    }

}