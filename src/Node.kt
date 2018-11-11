class Node(val x: Int = -1, val y: Int = -1, character: Char = '?') {
    lateinit var north: Node
    lateinit var east: Node
    lateinit var south: Node
    lateinit var west: Node
    val neighbors get() = mutableListOf(north, east, south, west)
    var type = character
    var constrainValue = -1

    @Deprecated(message = "Functionality moved into Import.kt")
    fun assignNeighbors(northNode: Node, eastNode: Node, southNode: Node, westNode: Node) {
        this.north = northNode
        this.east = eastNode
        this.south = southNode
        this.west = westNode
    }

//    constrainValue is 0-4 representing how many of north, east, south, west are blocked
//    use (4 - constrainValue) for how many of north, east, south, west are open
    fun calculateConstrain() {
        this.constrainValue = 0
        this.neighbors.forEach { node: Node -> if (node.type != '_') this.constrainValue++ }
    }

}
