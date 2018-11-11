interface BacktrackAlg {
    fun search(domain: MutableList<MutableList<Node>>) : Boolean
}