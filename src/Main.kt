import java.io.File

//PUZZLE_PATH can be either a file or a directory
const val PUZZLE_PATH = "res/puzzles/12x12maze.txt"
const val OUTPUT_PATH = "res/output/"

fun main(args: Array<String>) {
    val startTime = System.currentTimeMillis()
    val file = File(PUZZLE_PATH)
    val maze = Maze(file.path)
    renderMaze(maze.nodes,
            "$OUTPUT_PATH${file.name.removeSuffix("maze.txt")}_input.png")
    val backtrack : BacktrackAlg = BasicBacktrack()
    backtrack.search(maze.nodes)
    renderMaze(maze.nodes,
                    "$OUTPUT_PATH${file.name.removeSuffix("maze.txt")}_output.png")
//    run on each file in PUZZLE_PATH
//    File(PUZZLE_PATH).walk().forEach { file ->
//        //        only try to import text files
//        if (file.path.endsWith(".txt")) {
//            renderMaze(Maze(file.path).nodes,
//                    "$OUTPUT_PATH${file.name.removeSuffix("maze.txt")}_input.png")
//        }
//        print("Looping")
//    }
    println("I ran")
    println("render finished: ${System.currentTimeMillis() - startTime}ms\n")
}



