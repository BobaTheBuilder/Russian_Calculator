import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class CalculatorTest {
    @Test
    fun translationToPostfixRecordTest() {
        val expression = "(12+(3*2)/8)/(5-3)"
        val calculator = Calculator()
        val expected = " 12 3 2* 8/+ 5 3-/"
        assertEquals(expected, calculator.translationToPostfixRecord(expression))
    }

    @Test
    fun translationToPostfixRecordWithFloatingPointNumbersTest() {
        val expression = "(4.1+6)/(2.9*9.6-7)"
        val calculator = Calculator()
        val expected = " 4.1 6+ 2.9 9.6* 7-/"
        assertEquals(expected, calculator.translationToPostfixRecord(expression))
    }
}
