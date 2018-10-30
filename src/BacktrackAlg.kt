interface BacktrackAlg {
    fun search(domain: MutableList<MutableList<Node>>)
    fun renderSolution(solution: MutableList<MutableList<Node>>)
}