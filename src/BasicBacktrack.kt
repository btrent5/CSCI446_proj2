class BasicBacktrack : BacktrackAlg {

    /*
    Selects based on location in the puzzle
    most northwesterly unassigned node will be selected first
     */
    override fun selectUnassignedVariable(maze: MutableList<MutableList<Node>>): Node {
        var temp = maze.flatten()
                .filter { node -> node.type == '_' }
//                .sortedByDescending { node -> node.constrainValue }
//                .shuffled()
        return temp.first()
    }
}

