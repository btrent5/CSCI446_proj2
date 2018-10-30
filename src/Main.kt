import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO

fun main(args: Array<String>) {
    importMaze("res/puzzles/5x5maze.txt")
    renderMaze()
}

fun importMaze(fileName: String): MutableList<MutableList<Node>> {
    val input = File(fileName).readLines()
    var maze: MutableList<MutableList<Node>> = mutableListOf()

    for (i in 0 until input.size) {
        maze.add(mutableListOf())
        for (j in 0 until input[i].length) {
            print(input[i][j])
        }
        println()
    }
    return mutableListOf()
}

fun renderMaze() {

//    assuming rectangular with top row widest
    var image = BufferedImage(500, 500, BufferedImage.TYPE_INT_RGB)
//    for (i in 0 until input.size) {
//        for (j in 0 until input[i].size) {
    for (i in 0 until 500) {
        for (j in 0 until 500) {
//            val current = input[i][j]
            image.setRGB(j, i, ColorPalette.QUARTZ.rgb)

        }
    }
    var out = File("res/output/test.png")
    ImageIO.write(image, "png", out)
}