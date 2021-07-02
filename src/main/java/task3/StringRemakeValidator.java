package main.java.task3;

/**
 * StringRemakeValidator class
 *
 * @author Maksym V
 */
public class StringRemakeValidator {

    /**
     * isValid method is used to validate if string is well formed and contains some data to operate at
     *
     * @param stringToValidate
     */
    public static void validateString(String stringToValidate) {
        if (stringToValidate == null || stringToValidate.isEmpty() || stringToValidate.isBlank()) {
            throw new IllegalArgumentException("Could not remake as string is not well formed");
        }

        String stringWithoutDot = stringToValidate.replaceAll("\\.", "");
        if (stringWithoutDot.isEmpty() || stringWithoutDot.isBlank()) {
            throw new IllegalArgumentException("There is no other characters in string except of dot");
        }
    }
}
