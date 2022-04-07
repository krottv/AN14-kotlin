class Soyuz : IStart {

    override fun start() {
        println("Старт Союза")
    }

    override fun engineStart() {
        println("Двигатели Союза запущены. Все системы в норме.")
    }

    override fun prelaunchCheck(): Boolean {
        return Math.random() * 10 > 3
    }
}