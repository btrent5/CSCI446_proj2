class BasicBacktrack : BacktrackAlg {
    // esp =

    override fun search(maze: MutableList<MutableList<Node>>) : Boolean
    {
        // if assignment is complete then return
        if(isComplete(maze)){
            return true
        }
        var node = SelectUnassignedVariable(maze)
        // for each value in OrderDomainValue(var, assignment, esp)
            // if value is consistent with assignment then
                // add {var = value} to assignment
                // inferences = Inference(esp, var, value)
                // if inferences != failure then
                    // add inferences to assignment
                    // result = search(assignment, esp)
                    // if result != failure then
                        // return result
            // remove { var = value} and inferences from assignment
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
        return false
    }

    /*
        Selects an unassigned node from the maze
     */
    fun SelectUnassignedVariable(maze : MutableList<MutableList<Node>>) : Node
    {
        return maze[0][0];
    }
}

