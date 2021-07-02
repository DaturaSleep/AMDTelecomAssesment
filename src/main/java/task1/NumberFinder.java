package main.java.task1;

import java.util.Arrays;

import static main.java.task1.NumberFinderValidator.isValid;

/**
 * NumberFinder class
 * Utility class that finds the NUMBER_TO_FIND occurrence in digit array
 *
 * @author Max V
 */
public class NumberFinder {

    private final Integer NUMBER_TO_FIND = 7;
    private final String NOT_FOUND = String.format("there is no %d in the array", NUMBER_TO_FIND);
    private final String FOUND = "Found";


    /**
     * Method that returns the string FOUND if any number
     * in array contains NUMBER_TO_FIND
     * and NOT_FOUND if not or if array is not valid {@link NumberFinderValidator}.
     *
     * @param numbers
     * @return string result
     */
    public String findSeven(int[] numbers) {
        return isValid(numbers) && Arrays.stream(numbers)
                .map(Math::abs)
                .anyMatch(this::containsNumberToFind) ?
                FOUND : NOT_FOUND;
    }

    private boolean containsNumberToFind(int number) {
        while (number > 0) {
            if (number % 10 == NUMBER_TO_FIND) {
                return true;
            }
            number = number / 10;
        }
        return false;
    }


    /**
     * Get Method for testing purposes
     *
     * @return FOUND string
     */
    public String getFoundString() {
        return FOUND;
    }

    /**
     * Get Method for testing purposes
     *
     * @return NOT_FOUND string
     */
    public String getNotFoundString() {
        return NOT_FOUND;
    }

    /**
     * Get Method for testing purposes
     *
     * @return NUMBER_TO_FIND integer
     */
    public Integer getNumberToFind() {
        return NUMBER_TO_FIND;
    }
}
