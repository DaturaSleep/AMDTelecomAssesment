package main.java.task1;

/**
 * NumberFinderValidator class
 * Validation class for checking if array of numbers contains
 * any number in it.
 *
 * @author Maksym V
 */
class NumberFinderValidator {

    protected static boolean isValid(int[] numbers) {
        return !(numbers == null || numbers.length == 0);
    }
}
