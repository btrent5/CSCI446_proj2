class SmartBacktrack : BacktrackAlg {
    override var assignments: Int = 0

    /*
    Selects based on constrainValue
    node with the highest constrainValue will be selected first
    in event of ties, location based order (northwest first) is preserved
     */
    override fun selectUnassignedVariable(maze: MutableList<MutableList<Node>>): Node {
        var temp = maze.flatten()
                .filter { node -> node.type == '_' }
                .sortedByDescending { node -> node.constrainValue }
        return temp.first()
    }
}

