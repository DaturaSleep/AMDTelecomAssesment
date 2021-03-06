package test.java.task1;

import main.java.task1.NumberFinder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * NumberFinderTests class
 * <p>
 * Unit tests for {@link NumberFinder}
 */
@DisplayName("NumberFinder tests")
class NumberFinderTests {
    private static final NumberFinder NUMBER_FINDER = new NumberFinder();

    @Test
    @DisplayName("First example test")
    void task_first_example_test() {
        final int[] array = {1, 2, 3, 4, 5, 6, 7};
        final String expected = NUMBER_FINDER.getFoundString();

        final String actual = NUMBER_FINDER.findSeven(array);

        assertEquals(expected, actual,
                "Number finder should display found message if number is found");
    }

    @Test
    @DisplayName("Second example test")
    void task_second_example_test() {
        final int[] array = {8, 6, 33, 100};
        final String expected = NUMBER_FINDER.getNotFoundString();

        final String actual = NUMBER_FINDER.findSeven(array);

        assertEquals(expected, actual,
                "Number finder should display not found message if there is no number present");
    }

    @Test
    @DisplayName("Third example test")
    void task_third_example_test() {
        final int[] array = {2, 55, 60, 97, 86};
        final String expected = NUMBER_FINDER.getFoundString();

        final String actual = NUMBER_FINDER.findSeven(array);

        assertEquals(expected, actual,
                "number finder should display found message if number is found");
    }

    @Test
    @DisplayName("Number finder should find number in negative digit")
    void should_findNumber_when_digitIsNegative() {
        final int[] array = {-97};
        final String expected = NUMBER_FINDER.getFoundString();

        final String actual = NUMBER_FINDER.findSeven(array);

        assertEquals(expected, actual,
                "number finder should display found message if number is found");
    }

    @Test
    @DisplayName("Number finder should find number in array of negative digits")
    void should_findNumber_forArrayOfNegativeDigits() {
        final int[] array = {-2, -55, -60, -907, -86};
        final String expected = NUMBER_FINDER.getFoundString();

        final String actual = NUMBER_FINDER.findSeven(array);

        assertEquals(expected, actual,
                "Number finder should display found message if number is found");
    }

    @Test
    @DisplayName("Number finder should return not found message if there is no number in array of negative digits")
    void should_returnNotFoundMessage_when_arrayDoesNotContainSearchedDigit() {
        final int[] array = {-2, -55, -60, -907, -86};
        final String expected = NUMBER_FINDER.getFoundString();

        final String actual = NUMBER_FINDER.findSeven(array);

        assertEquals(NUMBER_FINDER.getFoundString(), NUMBER_FINDER.findSeven(array),
                "Number finder should return not found message if there is no number in array of negative digits");
    }
}
