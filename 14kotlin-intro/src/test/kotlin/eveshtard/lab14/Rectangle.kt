package eveshtard.lab14

class Rectangle(val height: Int, val length: Int) : IShape {
    override fun square(): Int {
        return height * length
    }

    override fun view(): String {
        return "Rectangle: height=${height}, length=${length}, square=${square()}"
    }
}

