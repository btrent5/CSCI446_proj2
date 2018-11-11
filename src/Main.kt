import java.io.File

//PUZZLE_PATH can be either a file or a directory
const val PUZZLE_PATH = "res/puzzles/"
const val OUTPUT_PATH = "res/output/"

fun main(args: Array<String>) {

//    run on each file in PUZZLE_PATH
    File(PUZZLE_PATH).walk().forEach { file ->
        //        only try to import text files
        if (file.path.endsWith(".txt")) {
            renderMaze(importMaze(file.path),
                    "$OUTPUT_PATH${file.name.removeSuffix("maze.txt")}_input.png")
        }
    }
}



