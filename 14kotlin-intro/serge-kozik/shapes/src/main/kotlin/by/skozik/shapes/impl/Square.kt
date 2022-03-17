package by.skozik.shapes.impl

import by.skozik.shapes.api.Shape

class Square(val height : Int) : Shape {
    override fun square(): Int {
        return height * height;
    }
}