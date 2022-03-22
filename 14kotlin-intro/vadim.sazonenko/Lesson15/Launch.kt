package Lesson15
import Lesson15.Shuttle.SpaceX
import Lesson15.Shuttle.Spaceport

fun main(args: Array<String>) {
    val spaceX = SpaceX()
    val captainFirst = Spaceport(spaceX)
    captainFirst.launch()
}
