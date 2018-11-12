class BasicBacktrack : BacktrackAlg {

    /*
    Selects based on location in the puzzle
    most northwesterly unassigned node will be selected first
     */
    override fun selectUnassignedVariable(maze: MutableList<MutableList<Node>>): Node {
        var temp = mutableListOf<MutableList<Node>>()
        temp.addAll(maze)
        temp = temp.map { row -> row.filter { node -> node.type == '_' }.toMutableList() }
                .filter { row -> !row.isEmpty() }.toMutableList()
        return temp[0][0]
    }
}

