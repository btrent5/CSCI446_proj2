import java.io.File

fun importMaze(fileName: String): MutableList<MutableList<Node>> {

    val input = File(fileName).readLines()
    var maze: MutableList<MutableList<Node>> = mutableListOf()

    for (i in 0 until input.size) {
        maze.add(mutableListOf())
        for (j in 0 until input[i].length) {
//            creates a node for each character in the input
            maze[i].add(Node(i, j, input[i][j]))
        }
    }

    for (row: MutableList<Node> in maze) {
        for (node: Node in row) {
//            if a node is on the border that neighbor is set to to type '?'
            if (node.x == 0 || node.x == row.lastIndex || node.y == 0 || node.y == row.lastIndex) {
                node.assignNeighbors(
                        Node(),
                        Node(),
                        Node(),
                        Node()
                )
            } else {
                node.assignNeighbors(
                        maze[node.x][node.y + 1],
                        maze[node.x + 1][node.y],
                        maze[node.x][node.y - 1],
                        maze[node.x - 1][node.y]
                )
            }
        }
    }
    return maze
}