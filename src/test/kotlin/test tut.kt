import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class CalculatorTest {
    @Test
    fun `postfixToInt method test expression 1`(){
        val expected = 8.0
        val actual: Double? = Calculator().postfixNotationToAnswer("45 5- 68 29 2*-/ 2*")
        assertEquals(expected,actual)
    }
    @Test
    fun `postfixToInt method test expression 2`(){
        val expected = -134.0
        val actual: Double? = Calculator().postfixNotationToAnswer("2 2+ 2 2*+ 2+ 4 4* 2/ 2* 9*-")
        assertEquals(expected,actual)
    }
    @Test
    fun `postfixToInt method test "Division by 0"`(){
        val expected = null
        val actual: Double? = Calculator().postfixNotationToAnswer("55 10 2 5*-/")
        assertEquals(expected,actual)
    }
}