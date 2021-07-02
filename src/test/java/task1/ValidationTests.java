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
        assertEquals(NUMBER_FINDER.getNotFoundString(), NUMBER_FINDER.findSeven(nullArray),
                "number finder should display not found message if array is null");
    }

    @Test
    @DisplayName("Number finder should display not found message if array is empty")
    void should_displayNotFoundMessage_when_arrayIsEmpty() {
        assertEquals(NUMBER_FINDER.getNotFoundString(), NUMBER_FINDER.findSeven(emptyArray),
                "number finder should display not found message if array is empty");
    }

}
