package eveshtard.lab14

class Square(val height: Int, val name: String) : IShape {
    override fun square(): Int {
        return height * height
    }

    override fun view(): String {
        return "Square: height=${height}, square=${square()}"
    }
}

