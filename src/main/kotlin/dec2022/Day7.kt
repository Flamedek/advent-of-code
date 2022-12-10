package dec2022

import Puzzle

class Day7 : Puzzle(2022, 7) {

    override fun partOne(input: String): Any {
        val system = buildFileSystem(input)

        var output = 0L
        system.walkFiles { item ->
            val size = item.size
            if (item is Dir && size < 100000) {
                output += size
            }
        }
        return output
    }

    override fun partTwo(input: String): Any {
        val system = buildFileSystem(input)

        val totalSize = 70000000
        val requiredSize = 30000000

        val sizeNeeded = requiredSize - (totalSize - system.size)
        if (sizeNeeded <= 0) {
            return 0
        }

        val candidates = mutableListOf(system)
        system.walkFiles {
            if (it is Dir && it.size >= sizeNeeded) {
                candidates += it
            }
        }
        return candidates.minBy { it.size }.size
    }

    private fun buildFileSystem(input: String): Dir {
        val commands = input.split("\$")
        val program = Program()
        for (command in commands) {
            val lines = command.trim().lines()
            program.executeCommand(lines.first(), lines.drop(1))
        }
        return program.root
    }

    class Program {

        val path = ArrayDeque<String>()
        val root = Dir("/")

        var currentDir = root

        fun executeCommand(command: String, output: List<String>) {
            val args = command.substringAfter(' ')
            when (command.substringBefore(' ')) {
                "cd" -> {
                    if (args.first() == '/') {
                        path.clear()
                    }
                    for (part in args.split('/')) {
                        when (part) {
                            "" -> continue
                            ".." -> path.removeLast()
                            else -> path.add(part)
                        }
                    }
                    updateCurrentDir()
                }
                "ls" -> {
                    currentDir.contents.clear()

                    for (line in output) {
                        val parts = line.split(" ")
                        currentDir.contents += if (parts[0] == "dir") {
                            Dir(parts[1])
                        } else {
                            File(parts[1], parts[0].toLong())
                        }
                    }
                }
            }
        }

        private fun updateCurrentDir() {
            currentDir = root
            for (part in path) {
                currentDir = currentDir.contents.find {
                    it is Dir && it.name == part
                } as Dir
            }
        }

    }

    sealed interface FileSystem {
        val name: String
        val size: Long
    }

    data class Dir(override val name: String) : FileSystem {

        override val size get() = contents.sumOf(FileSystem::size)

        val contents = mutableListOf<FileSystem>()

        fun walkFiles(action: (FileSystem) -> Unit) {
            contents.forEach(action)
            for (item in contents) {
                if (item is Dir) {
                    item.walkFiles(action)
                }
            }
        }
    }

    data class File(
        override val name: String,
        override val size: Long
    ): FileSystem


}