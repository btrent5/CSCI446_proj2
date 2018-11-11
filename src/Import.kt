import java.io.File

fun importMaze(fileName: String): MutableList<MutableList<Node>> {
    val startTime = System.currentTimeMillis()
    val input = File(fileName).readLines()
    var maze: MutableList<MutableList<Node>> = mutableListOf()

    for (i in 0 until input.size) {
        maze.add(mutableListOf())
        for (j in 0 until input[i].length) {
//            creates a node for each character in the input
            maze[i].add(Node(i, j, input[i][j]))
        }
    }

    for (i in 0 until maze.size) {
        for (j in 0 until maze[i].size) {
//            if a node is on the border that neighbor is set to to type '?'
            if (j == 0) {
                maze[i][j].west = Node()
            } else {
                maze[i][j].west = maze[i][j - 1]
            }

            if (j == maze[i].lastIndex) {
                maze[i][j].east = Node()
            } else {
                maze[i][j].east = maze[i][j + 1]
            }

            if (i == maze.lastIndex) {
                maze[i][j].south = Node()
            } else {
                maze[i][j].south = maze[i + 1][j]
            }

            if (i == 0) {
                maze[i][j].north = Node()
            } else {
                maze[i][j].north = maze[i - 1][j]
            }
            maze[i][j].calculateConstrain()
        }
    }
    println("imported \"$fileName\": ${System.currentTimeMillis() - startTime}ms")
    return maze
}