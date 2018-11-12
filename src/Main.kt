import java.io.File
import kotlin.system.measureTimeMillis

//PUZZLE_PATH can be either a file or a directory
const val PUZZLE_PATH = "res/puzzles/"
const val OUTPUT_PATH = "res/output/"

fun main(args: Array<String>) {
    val startTime = System.currentTimeMillis()
    File(PUZZLE_PATH).walk().forEach { file ->
        //        only try to import text files
        if (file.path.endsWith(".txt")) {
            var currentMaze = Maze(file.path).nodes
//            render input state
            renderMaze(currentMaze,
                    "$OUTPUT_PATH${file.name.removeSuffix("maze.txt")}_input.png")
//            find solution
            val time = measureTimeMillis {
                BasicBacktrack().search(currentMaze)
            }
            println("solved in ${time}ms")
//            render solution
            renderMaze(currentMaze,
                    "$OUTPUT_PATH${file.name.removeSuffix("maze.txt")}_output.png")
        }
    }
    println("Solved $PUZZLE_PATH in ${System.currentTimeMillis() - startTime}ms\n")
}



