package by.skozik.shapes

import by.skozik.shapes.api.GeometryException
import by.skozik.shapes.api.Shape
import by.skozik.shapes.impl.*
import org.junit.Test
import kotlin.test.BeforeTest
import kotlin.test.assertFailsWith
import kotlin.test.assertTrue

class ShapePrinterTest {

    private val AREA_FORMAT = "area = %s";
    private var predefinedCollection: Collection<Shape>? = null
    private val printer = ShapePrinter()

    @BeforeTest
    fun initMocks() {
        predefinedCollection =
            listOf<Shape>(Square(10), Circle(4), Triangle(1, 1, 1), Rectangle(2, 10), Rectangle(10, 9))
    }

    @Test
    fun printShapeTest() {
        val actualOutput: String? = predefinedCollection?.map { printer.printShape(it) }?.joinToString()

        predefinedCollection?.forEach {
            validateShape(actualOutput, it)
        }
    }

    fun validateShape(output: String?, shape: Shape) {
        val validatedOutput = output ?: throw AssertionError("output is null")
        if (shape is Triangle) {
            assertFailsWith<GeometryException>(message = "No area calculation should be for a Triangular",
                block = {
                    AREA_FORMAT.format(shape.square())
                })
            return
        }
        val expectedMessage = AREA_FORMAT.format(shape.square())
        assertTrue(validatedOutput.contains(expectedMessage), "$expectedMessage is missing")
    }
}