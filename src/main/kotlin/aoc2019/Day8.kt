package aoc2019

class Day8 {

    val input: String
    var layers: List<List<Int>>
    var image = arrayListOf<Int?>()
    val pixelWidth: Int
    val pixelDepth: Int

    constructor(input: String, pixelWidth: Int, pixelDepth: Int) {
        this.input = input
        this.pixelWidth = pixelWidth
        this.pixelDepth = pixelDepth
        var intArray = arrayListOf<Int>()
        for (char in input) {
            intArray.add(char.toString().toInt())
        }
        layers = intArray.chunked(pixelWidth * pixelDepth)

        for (i in 0 until pixelWidth * pixelDepth) {
            image.add(null)
            for (layer in layers) {
                if (image[i] == null && layer[i] != 2) {
                    image[i] = layer[i]
                }
            }
        }
    }

    fun print() {
        var count = 0
        var string = ""
        for (pixel in image) {
            if (count == pixelWidth) {
                count = 0
                string += "\n"
            }
            if (pixel == 0) {
                string += " "
            } else {
                string += pixel
            }
            count += 1
        }

        println(string)

    }


    fun getLeastOccurrences(value: Int): List<Int> {
        var currentIndex = 1
        var layerToReturn = listOf<Int>()
        var highestCount = 0;
        for (layer in layers) {
            val count = layer.filter { it != value }.size
            if (count > highestCount) {
                highestCount = count
                layerToReturn = layer
            }
            currentIndex += 1
        }
        return layerToReturn
    }

}