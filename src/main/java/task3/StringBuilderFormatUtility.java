package main.java.task3;

import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static main.java.task3.StringRemakeValidator.validateString;

public class StringBuilderFormatUtility {

    private static final Set<Character> VOWEL_SET = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
    private static final Pattern NO_LETTER_CHARACTER_PATTERN = Pattern.compile("[^a-zA-Z]");
    private static final Pattern NO_LETTER_IN_STRING_CHARACTER_PATTERN = Pattern.compile("[^a-zA-Z]*");
    private static final String WAY = "way";
    private static final String AY = "ay";

    public static StringBuilder applyUpperCaseToFirstCharacter(StringBuilder stringBuilderToApplyPrettyFormAt) {
        validateString(stringBuilderToApplyPrettyFormAt.toString());
        return stringBuilderToApplyPrettyFormAt
                .replace(0, 1, stringBuilderToApplyPrettyFormAt.substring(0, 1).toUpperCase());
    }

    public static void applyChangesToStringBuilder(StringBuilder stringBuilder) {
        if (VOWEL_SET.contains(stringBuilder.charAt(0))) {
            wayAppend(stringBuilder);
        } else if (containsAlphaCharacters(stringBuilder)) {
            putFirstCharToTheEnd(stringBuilder);
            ayAppend(stringBuilder);
        }
    }

    public static StringBuilder wayAppend(StringBuilder stringBuilderToAppend) {
        if (hasDelimiters(stringBuilderToAppend)) {
            return appendStringToTheEnd(stringBuilderToAppend, findDelimiterIndex(stringBuilderToAppend), WAY);
        } else {
            return appendStringToTheEnd(stringBuilderToAppend, WAY);
        }
    }

    public static StringBuilder ayAppend(StringBuilder stringBuilderToAppend) {
        if (hasDelimiters(stringBuilderToAppend)) {
            return appendStringToTheEnd(stringBuilderToAppend, findDelimiterIndex(stringBuilderToAppend), AY);
        } else {
            return appendStringToTheEnd(stringBuilderToAppend, AY);
        }
    }

    public static int findDelimiterIndex(StringBuilder stringBuilderThatContainsDelimiter) {
        Matcher matcher = NO_LETTER_CHARACTER_PATTERN.matcher(stringBuilderThatContainsDelimiter);
        return matcher.find() ? matcher.start() : -1;
    }

    public static StringBuilder putFirstCharToTheEnd(StringBuilder stringBuilderToChange) {
        if (hasDelimiters(stringBuilderToChange)) {
            return appendFirstCharToTheEnd(stringBuilderToChange, findDelimiterIndex(stringBuilderToChange));
        } else {
            return appendFirstCharToTheEnd(stringBuilderToChange);
        }
    }

    private static StringBuilder appendStringToTheEnd(StringBuilder stringBuilderToChange, String stringToAppend) {
        return stringBuilderToChange.append(stringToAppend);
    }

    private static StringBuilder appendStringToTheEnd(StringBuilder stringBuilderToChange, int indexToPutAt, String stringToPut) {
        return stringBuilderToChange
                .insert(indexToPutAt, stringToPut);
    }

    private static StringBuilder appendFirstCharToTheEnd(StringBuilder stringBuilderToChange) {
        return stringBuilderToChange
                .append(stringBuilderToChange.charAt(0))
                .deleteCharAt(0);
    }

    private static StringBuilder appendFirstCharToTheEnd(StringBuilder stringBuilderToChange, int indexToPutAt) {
        return stringBuilderToChange
                .insert(indexToPutAt, stringBuilderToChange.charAt(0))
                .deleteCharAt(0);
    }

    public static StringBuilder appendAllStringBuilders(StringBuilder... stringBuilders) {
        StringBuilder result = new StringBuilder();
        for (StringBuilder stringBuilder : stringBuilders) {
            result.append(stringBuilder).append(" ");
        }
        return result.deleteCharAt(result.length() - 1);
    }

    public static boolean hasDelimiters(StringBuilder stringBuilderToCheck) {
        Matcher matcher = NO_LETTER_CHARACTER_PATTERN.matcher(stringBuilderToCheck);
        if (matcher.find()) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean containsAlphaCharacters(StringBuilder stringBuilderToCheck) {
        Matcher matcher = NO_LETTER_IN_STRING_CHARACTER_PATTERN.matcher(stringBuilderToCheck);
        if (matcher.matches()) {
            return false;
        } else {
            return true;
        }
    }
}
