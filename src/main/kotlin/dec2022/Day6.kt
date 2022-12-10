package dec2022

import Puzzle

class Day6 : Puzzle(2022, 6) {

    override fun partOne(input: String): Any {
        return detectPacket(input, 4)
    }

    override fun partTwo(input: String): Any {
        return detectPacket(input, 14)
    }

    private fun detectPacket(input: String, uniqueSymbols: Int): Int {
        if (input.length < uniqueSymbols) {
            return -1
        }

        val set = HashSet<Char>(uniqueSymbols)
        for (i in uniqueSymbols .. input.lastIndex) {
            val chars = input.toCharArray(i - uniqueSymbols, i)
            set.clear()
            chars.forEach(set::add)
            if (set.size == uniqueSymbols) {
                return i
            }
        }
        return -1
    }

}