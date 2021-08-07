import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class CalculatorTest {

    @Test
    fun translationToPostfixRecordWithIntegersTest() {
        val expression = mutableListOf('1', '2', ' ', '+', ' ', '2', '6', ' ', '/', ' ', '2')
        val calculator = Calculator()
        val expected = mutableListOf('1', '2', ' ', '2', '6', ' ', '2', '/', '+')
        assertEquals(expected, calculator.translationToPostfixRecord(expression))
    }

    @Test
    fun translationToPostfixRecordWithFloatingPointNumbersTest() {
        val expression = mutableListOf(' ', '(', '1', '.', '4', ' ', '-', ' ', '4', '.', '9', ' ', ')', ' ', '/', ' ', '5')
        val calculator = Calculator()
        val expected = mutableListOf(' ', '1', '.', '4', ' ', '4', '.', '9', '-', ' ', '5', '/')
        assertEquals(expected, calculator.translationToPostfixRecord(expression))
    }
}
