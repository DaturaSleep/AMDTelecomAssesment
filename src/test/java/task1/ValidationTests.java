package test.java.task1;

import main.java.task1.NumberFinder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * ValidationTests class
 * <p>
 * Unit tests for {@link NumberFinder} validation
 */
@DisplayName("Array validation tests")
class ValidationTests {
    private static final NumberFinder NUMBER_FINDER = new NumberFinder();
    private static final int[] nullArray = null;
    private static final int[] emptyArray = {};

    @Test
    @DisplayName("Number finder should display not found message if array is null")
    void should_displayNotFoundMessage_when_arrayIsNull() {
        final String expected = NUMBER_FINDER.getNotFoundString();

        final String actual = NUMBER_FINDER.findSeven(nullArray);

        assertEquals(expected, actual,
                "number finder should display not found message if array is null");
    }

    @Test
    @DisplayName("Number finder should display not found message if array is empty")
    void should_displayNotFoundMessage_when_arrayIsEmpty() {
        final String expected = NUMBER_FINDER.getNotFoundString();

        final String actual = NUMBER_FINDER.findSeven(emptyArray);

        assertEquals(expected, actual,
                "number finder should display not found message if array is empty");
    }

}
