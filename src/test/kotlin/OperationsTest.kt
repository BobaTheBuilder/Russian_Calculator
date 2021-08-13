import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class OperationsTest {
    @Test
    fun `Operation plus test`(){
        val actual = Operations().plus(8.0,-8.0)
        val expected: Double = 0.0
        assertEquals(expected,actual)
    }
}