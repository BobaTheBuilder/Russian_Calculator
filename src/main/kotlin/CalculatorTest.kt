import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class CalculatorTest {
    @Test
    fun checkingCorrectExpressionTest() {
        val expected = true
        val calculator = Calculator()
        val expression = "(12+(3-4)/6)/(34-65*2+2)"
        assertEquals(expected, calculator.checkingExpression(expression))
    }

    @Test
    fun checkingInvalidExpressionTest() {
        val expected = false
        val calculator = Calculator()
        val expression = "(12+(3-4)/6)/(34-65*+2+2)"
        assertEquals(expected, calculator.checkingExpression(expression))
    }
}
