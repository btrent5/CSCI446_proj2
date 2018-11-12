class BasicBacktrack : BacktrackAlg {

    override fun search(maze: MutableList<MutableList<Node>>) : Boolean
    {
        // if assignment is complete then return
        if(isComplete(maze)){
            print("Assignment complete")
            return true
        }
        var node = SelectUnassignedVariable(maze)
        // for each value in OrderDomainValue(var, assignment, csp)
        for (value in OrderDomainValue(node)) {
            node.type = value
            // if value is consistent with assignment then
            if(node.validateConstraints()) {
                // add {var = value} to assignment
                // inferences = Inference(csp, var, value)
                // if inferences != failure then
                // add inferences to assignment
                var result = search(maze)
                // if result != failure then
                if(result) {
                    return true
                }
                // remove { var = value} and inferences from assignment
            }
            node.type = '_'
        }
        // return failure
        return false
    }

    // SelectUnassignedVariable will be first variable found unassigned
    // Need function to check for assignment being complete
    // OrderDomainValue can just return an unordered list of domain values

    /*
        Returns true if the assignment is complete, false otherwise.
     */
    fun isComplete(maze : MutableList<MutableList<Node>>) : Boolean
    {
        return maze.all { row -> row.all { node -> node.type != '_' } }
    }

    /*
        Selects an unassigned node from the maze
     */
    fun SelectUnassignedVariable(maze : MutableList<MutableList<Node>>) : Node
    {
        var temp = mutableListOf<MutableList<Node>>()
        temp.addAll(maze)
        temp = temp.map { row -> row.filter { node -> node.type == '_' }.toMutableList() }.filter { row -> !row.isEmpty() }.toMutableList()
        return temp[0][0]
    }

    /*
        Returns domain of node
     */
    fun OrderDomainValue(node : Node) : MutableList<Char>
    {
        return node.domain
    }
}

