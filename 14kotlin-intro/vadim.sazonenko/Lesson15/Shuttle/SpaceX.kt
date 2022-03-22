package Lesson15.Shuttle
import Lesson15.Interface.IStart
class SpaceX : IStart {

    override fun prelaunchCheck(): Boolean {
        println("Предстартовая проверка")
        print("Введите число: ")
        val number: Int = readLine()!!.toInt()
        return number == 4
    }

    override fun startMotor() {
        println("Двигатели SpaceX запущены. Все системы в норме")
    }

    override fun start() {
        println("Старт SpaceX")
        println(" ")
    }
}