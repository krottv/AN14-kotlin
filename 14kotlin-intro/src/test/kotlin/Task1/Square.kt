package Task1

data class Square(var height: Int) : Shape {

    override fun square(): Int {
        return height * height
    }
}