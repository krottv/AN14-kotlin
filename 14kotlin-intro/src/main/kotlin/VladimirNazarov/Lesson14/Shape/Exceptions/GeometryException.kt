package TMSTasks.Lesson14.Shape.Exceptions

import java.lang.Exception

open class GeometryException: Exception() {
    override fun toString(): String {
        return "Impossible to find the square of a figure due to lack of data"
    }
}