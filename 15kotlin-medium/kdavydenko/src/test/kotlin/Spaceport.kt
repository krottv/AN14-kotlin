class Spaceport {

    fun launch(iStart: IStart){
        if (iStart.prelaunchCheck()) {
            iStart.engineStart()
            for (i in 10 downTo 0)
                println(i)
            iStart.start()
        } else
            println("Предстартовая проверка провалена")
    }
}