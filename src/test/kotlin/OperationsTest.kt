import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import java.lang.IllegalArgumentException


class OperationsTest {
    @Test
    fun `Divide method test`(){
        val actual = Operations().divide(25.0,5.0)
        val expected = 5.0
        assertEquals(expected, actual)
    }
    @Test
    fun `Divide method negative test`(){
        val exception : Exception = assertThrows(Exception::class.java) {
            Operations().divide(1.0, 0.0)
        }
        val actual = exception.message
        val expected = "Division by zero!"
        assertEquals(expected, actual)
    }
}