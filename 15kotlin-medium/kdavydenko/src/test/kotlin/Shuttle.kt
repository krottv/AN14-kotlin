class Shuttle : IStart {
    override fun engineStart() {
        println("Двигатели Шатла запущены. Все системы в норме.")
    }

    override fun prelaunchCheck(): Boolean {
        return Math.random() * 10 > 3
    }

    override fun start() {
        println("Старт Шатла")
    }
}