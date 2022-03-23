class SpaceX : IStart {
    override fun engineStart() {
        println("Двигатели SpaceX запущены. Все системы в норме.")
    }

    override fun prelaunchCheck(): Boolean {
        return Math.random() * 10 > 3
    }

    override fun start() {
        println("Старт SpaceX")
    }
}