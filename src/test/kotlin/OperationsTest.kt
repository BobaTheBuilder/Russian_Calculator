import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class OperationsTest {
    @Test
    fun `Multiply method test`(){
        val actual = Operations().multiply(5.0, 2.5)
        val expected = 12.5
        assertEquals(expected, actual)
    }
}