import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class OperationsTest {
    @Test
    fun `Minus method test`(){
        val actual = Operations().minus(-20.0,-5.0)
        val expected = -15.0
        assertEquals(expected, actual)
    }
}