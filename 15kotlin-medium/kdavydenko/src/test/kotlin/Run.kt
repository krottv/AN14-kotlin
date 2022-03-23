import org.junit.Test

class Run {

    @Test
    fun Run() {
        val shuttle = Shuttle()
        val spaceport = Spaceport()
        spaceport.launch(shuttle)

        val spaceX = SpaceX()
        spaceport.launch(spaceX)

        val soyuz = Soyuz()
        spaceport.launch(soyuz)

    }
}