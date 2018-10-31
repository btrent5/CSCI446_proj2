class Node(val x: Int = -1, val y: Int = -1, character: Char = '?') {
    //    make neighbors for wall themselves?
    lateinit var north: Node
    lateinit var east: Node
    lateinit var south: Node
    lateinit var west: Node
    val neighbors get() = mutableListOf(north, east, south, west)
    var type = character

    fun assignNeighbors(northNode: Node, eastNode: Node, southNode: Node, westNode: Node) {
        this.north = northNode
        this.east = eastNode
        this.south = southNode
        this.west = westNode
    }
}
