package dec2022

import Puzzle

class Day5 : Puzzle(2022, 5) {

    override fun partOne(input: String): Any {
        return parseAndExecute(input, false)
    }

    override fun partTwo(input: String): Any {
        return parseAndExecute(input, true)
    }

    private fun parseAndExecute(input: String, transferAsStack: Boolean): String {
        val stacks = input.substringBefore("\n\n")
        val instructions = input.substringAfter("\n\n")

        val crates = parseStacks(stacks)
        val cratesMap = crates.associateBy { it.id }
        instructions.lines().forEach { line -> executeInstruction(cratesMap, line, transferAsStack) }

        return buildString { crates.forEach { append(it.getTop()) } }
    }

    private fun parseStacks(input: String): List<CrateStack> {
        val lines = input.lines()
        val stackLines = lines.dropLast(1).reversed()
        val idLine = lines.last()

        val columnCount = (lines.maxOf(String::length) + 1) / 4

        val result = mutableListOf<CrateStack>()
        for (i in 0 until  columnCount) {
            val startIndex = i * 4
            val stack = CrateStack(idLine[startIndex + 1].toString())
            result += stack

            for (line in stackLines) {
                val char = line.getOrNull(startIndex + 1) ?: continue
                if (char != ' ') {
                    stack.add(char)
                }
            }
        }
        return result
    }

    private fun executeInstruction(stacks: Map<String, CrateStack>, instruction: String, transferAsStack: Boolean) {
        val (amount, from, to) = instruction.split(" ").let { arrayOf(it[1], it[3], it[5]) }

        if (transferAsStack) {
            stacks[from]!!.transferStack(amount.toInt(), stacks[to]!!)
        } else {
            repeat(amount.toInt()) {
                stacks[from]!!.transferCrate(stacks[to]!!)
            }
        }
    }

    class CrateStack(val id: String) {

        private val list = ArrayDeque<Char>()

        fun add(item: Char) = list.add(item)

        fun addAll(items: List<Char>) = list.addAll(items)

        fun transferCrate(other: CrateStack) {
            other.add(list.removeLast())
        }

        fun transferStack(amount: Int, other: CrateStack) {
            other.addAll(list.takeLast(amount))
            repeat(amount) { list.removeLast() }
        }

        fun getTop(): Char {
            return list.lastOrNull() ?: ' '
        }
    }
}
