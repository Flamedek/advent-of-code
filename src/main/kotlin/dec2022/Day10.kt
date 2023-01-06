package dec2022

import Puzzle
import kotlin.math.abs

class Day10 : Puzzle(2022, 10) {

    override fun partOne(input: String): Any {
        val cpu = Cpu()
        cpu.loadInstructions(input.lines())

        var output = 0
        while (!cpu.isIdle()) {
            cpu.startTick()

            if ((cpu.cycles - 20) % 40 == 0) {
                output += cpu.cycles * cpu.xRegister
            }

            cpu.finishTick()
        }
        return output
    }

    override fun partTwo(input: String): Any {
        val cpu = Cpu()
        cpu.loadInstructions(input.lines())

        val output = StringBuilder()
        output.appendLine()

        while (!cpu.isIdle()) {
            cpu.startTick()

            val ctrPosition = cpu.cycles - 1
            val crtColumn = ctrPosition % 40

            val doDraw = abs(cpu.xRegister - crtColumn) <= 1
            output.append(if (doDraw) "#" else ".")

            if (crtColumn == 39) {
                output.appendLine()
            }

            cpu.finishTick()
        }
        return output.toString()
    }

    class Cpu {

        var xRegister = 1
            private set

        var cycles = 0
            private set

        private val instructionCache = ArrayDeque<String>()

        private var instruction = Instruction.Noop
        private var instructionArgs = ""
        private var instructionCycles = 0

        fun loadInstructions(instructions: List<String>) {
            instructionCache.addAll(instructions)
        }

        fun startTick() {
            if (instructionCycles <= 0) {
                fetchInstruction()
            }
            cycles++
        }

        fun finishTick() {
            if (instructionCycles == 1) {
                executeInstruction()
            }
            instructionCycles--
        }

        fun isIdle() = instructionCache.isEmpty()

        private fun fetchInstruction() {
            if (instructionCache.isNotEmpty()) {
                val input = instructionCache.removeFirst()
                val parts = input.split(" ")
                instruction = Instruction.parse(parts[0])
                instructionArgs = parts.getOrElse(1) { "" }
                instructionCycles = instruction.cycles
            } else {
                instruction = Instruction.Noop
                instructionArgs = ""
                instructionCycles = 0
            }
        }

        private fun executeInstruction() {
            when (instruction) {
                Instruction.AddX -> xRegister += instructionArgs.toInt()
                else -> {}
            }
        }

    }

    enum class Instruction(val cycles: Int, val instruction: String) {
        Noop(1, "noop"),
        AddX(2, "addx");

        companion object {
            fun parse(instruction: String): Instruction {
                if (instruction.isEmpty()) {
                    return Noop
                }

                return values().find { it.instruction == instruction }
                    ?: throw IllegalArgumentException("Instruction '$instruction' not found")
            }
        }
    }

}