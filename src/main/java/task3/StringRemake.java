package main.java.task3;

import java.util.Arrays;

import static main.java.task3.StringBuilderFormatUtility.appendAllStringBuilders;
import static main.java.task3.StringBuilderFormatUtility.applyUpperCaseToFirstCharacter;
import static main.java.task3.StringRemakeValidator.validateString;

/**
 * StringRemake class
 * Class with doRemake() method that is needed to accomplish the task.
 *
 * @author Maksym V
 */
public class StringRemake {

    private static final String SPACING_REGEX = "\\s+";

    /**
     * doRemake method
     * Method that moves the first letter of each word to the end of the word.
     * Adds "ay" to the end of the word.
     * Words starting with a vowel (a,e,i,o,u, A, E, I, O, U) simply have "way" appended to the end.
     * Also preserves proper capitalization and punctuation.
     *
     * @param stringToRemake - string that will be remade
     * @return String result of remade string with proper punctuation and capitalization
     */
    public String doRemake(String stringToRemake) {
        validateString(stringToRemake);
        StringBuilder result = appendAllStringBuilders(
                Arrays.stream(stringToRemake
                        .toLowerCase()
                        .trim()
                        .split(SPACING_REGEX))
                        .map(string -> new StringBuilder(string))
                        .peek(StringBuilderFormatUtility::applyChangesToStringBuilder)
                        .toArray(StringBuilder[]::new)
        );
        return applyUpperCaseToFirstCharacter(result).toString();
    }
}
