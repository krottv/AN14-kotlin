package Lesson15.Shuttle
import Lesson15.Interface.IStart

class Spaceport(shuttle: Any) {
    val check: IStart = SpaceX()
    fun launch() {
        while (true) {
            if (check.prelaunchCheck()) {
                check.startMotor()
                println("Обратный остчёт: ")
                countDown()
                check.start()
                break
            } else {
                println(
                    """
                    Предстартовая проверка провалена
                    Попробуйте ещё раз
                    """.trimIndent()
                )
            }
        }
    }

    private fun countDown() {
        for (i in 10 downTo 0) {
            print(i)
            Thread.sleep(200)
            print(".")
            Thread.sleep(200)
            print(".")
            Thread.sleep(200)
            print(".")
            Thread.sleep(200)
        }
        println()
    }
}