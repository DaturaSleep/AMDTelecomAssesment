package test.java.task2;

import main.java.task2.DigitSumCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

/**
 * DigitSumCalculatorTest class
 * Unit tests class for {@link DigitSumCalculator}
 */
@Nested
@DisplayName("Digit sum calculator tests")
class DigitSumCalculatorTests {

    private static final DigitSumCalculator DIGIT_SUM_CALCULATOR = new DigitSumCalculator();

    @Test
    @DisplayName("First example test")
    void first_example_test() {
        int number = 10;
        int expectedResult = 1;
        assertEquals(expectedResult, DIGIT_SUM_CALCULATOR.digitSum(number),
                String.format("Final sum should be equal to expected result: %d", expectedResult));
    }

    @Test
    @DisplayName("Second example test")
    void second_example_test() {
        int number = 38;
        int expectedResult = 2;
        assertEquals(expectedResult, DIGIT_SUM_CALCULATOR.digitSum(number),
                String.format("Final sum should be equal to expected result: %d", expectedResult));
    }

    @Test
    @DisplayName("Third example test")
    void third_example_test() {
        int number = 785;
        int expectedResult = 2; //expected result is 2, not 3, 7 + 8 + 5 = 20 => 2 + 0 = 2
        assertEquals(expectedResult, DIGIT_SUM_CALCULATOR.digitSum(number),
                String.format("Final sum should be equal to expected result: %d", expectedResult));
    }

    @Test
    @DisplayName("Fourth example test")
    void fourth_example_test() {
        int number = 99892;
        int expectedResult = 1;
        assertEquals(expectedResult, DIGIT_SUM_CALCULATOR.digitSum(number),
                String.format("Final sum should be equal to expected result: %d", expectedResult));
    }

    @Test
    @DisplayName("Negative numbers should be also calculated based on their absolute value")
    void should_calculateNegativeNumbers_based_onTheirAbsoluteValue() {
        int number1 = -10;
        int expectedResult1 = 1;

        int number2 = -38;
        int expectedResult2 = 2;

        int number3 = -785;
        int expectedResult3 = 2;

        int number4 = -99892;
        int expectedResult4 = 1;

        assertAll(() ->
                {
                    assertEquals(expectedResult1, DIGIT_SUM_CALCULATOR.digitSum(number1),
                            String.format("Final sum should be equal to expected result: %d", expectedResult1));
                    assertEquals(expectedResult2, DIGIT_SUM_CALCULATOR.digitSum(number2),
                            String.format("Final sum should be equal to expected result: %d", expectedResult2));
                    assertEquals(expectedResult3, DIGIT_SUM_CALCULATOR.digitSum(number3),
                            String.format("Final sum should be equal to expected result: %d", expectedResult3));
                    assertEquals(expectedResult4, DIGIT_SUM_CALCULATOR.digitSum(number4),
                            String.format("Final sum should be equal to expected result: %d", expectedResult4));
                }
        );
    }

    @Test
    @DisplayName("Integer MIN and MAX values should not throw any exceptions on execution")
    void should_doesNotThrowAnyException_whenGiven_integerMaxAndMinValue() {

        Executable executionWithMaxValue = () -> DIGIT_SUM_CALCULATOR.digitSum(Integer.MAX_VALUE);
        Executable executionWithMinValue = () -> DIGIT_SUM_CALCULATOR.digitSum(Integer.MIN_VALUE);

        assertAll(() -> {
            assertDoesNotThrow(executionWithMaxValue, "Integer.MAX_VALUE should not cause any exceptions");
            assertDoesNotThrow(executionWithMinValue, "Integer.MIN_VALUE should not cause any exceptions");
        });
    }

}

