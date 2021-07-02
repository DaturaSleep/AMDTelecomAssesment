package test.java.task3;

import main.java.task3.StringBuilderFormatUtility;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * StringBuilderFormatUtility_test class
 * <p>
 * Unit tests for {@link StringBuilderFormatUtility}
 */
@Nested
@DisplayName("StringBuilderFormatUtility tests")
class StringBuilderFormatUtilityTests {
    StringBuilderFormatUtility stringBuilderFormatUtility = new StringBuilderFormatUtility();

    @Test
    @DisplayName("hasDelimiters should return true if there is delimiters in StringBuilder and false if not")
    void should_returnTrue_when_stringContainsDelimiters_and_returnFalse_when_stringDoesNotContainsDelimiters() {
        StringBuilder sb1 = new StringBuilder(",");
        StringBuilder sb2 = new StringBuilder("abc,sda!");
        StringBuilder sb3 = new StringBuilder("abc");

        assertAll(() -> {
            assertTrue(stringBuilderFormatUtility.hasDelimiters(sb1), "hasDelimiters should return true if there is delimiters in StringBuilder and false if not");
            assertTrue(stringBuilderFormatUtility.hasDelimiters(sb2), "hasDelimiters should return true if there is delimiters in StringBuilder and false if not");
            assertFalse(stringBuilderFormatUtility.hasDelimiters(sb3), "hasDelimiters should return true if there is delimiters in StringBuilder and false if not");
        });
    }

    @Test
    @DisplayName("containsAlphaCharacters should return true if there is [a-zA-Z] characters present and false if not")
    void should_returnTrue_when_stringContainsAlphaCharacters() {
        StringBuilder sb1 = new StringBuilder(",))!");
        StringBuilder sb2 = new StringBuilder("abc dgf,");
        StringBuilder sb3 = new StringBuilder("hello my name is");

        assertAll(() -> {
            assertFalse(stringBuilderFormatUtility.containsAlphaCharacters(sb1), "hasDelimiters should return true if there is delimiters in StringBuilder and false if not");
            assertTrue(stringBuilderFormatUtility.containsAlphaCharacters(sb2), "hasDelimiters should return true if there is delimiters in StringBuilder and false if not");
            assertTrue(stringBuilderFormatUtility.containsAlphaCharacters(sb3), "hasDelimiters should return true if there is delimiters in StringBuilder and false if not");
        });
    }

    @Test
    @DisplayName("appendAllStringBuilders should append StringBuilders adding space between them but without spacing for the last append")
    void should_appendStringBuildersWithSpacing_whenGiven_arrayOfStringBuilders() {
        StringBuilder sb1 = new StringBuilder(",))!");
        StringBuilder sb2 = new StringBuilder("abc dgf,");
        StringBuilder sb3 = new StringBuilder("hello my name is");

        assertEquals(",))! abc dgf, hello my name is", stringBuilderFormatUtility.appendAllStringBuilders(sb1, sb2, sb3).toString(),
                "appendAllStringBuilders should append StringBuilders adding space between them but without spacing for the last append");
    }

    @Test
    @DisplayName("putFirstCharToTheEnd should put first char to the end in the word without delimiter")
    void should_putFirstCharToTheEnd_when_stringDoesNotContainDelimiters() {
        StringBuilder sb1 = new StringBuilder("a");
        StringBuilder sb2 = new StringBuilder("dgf");
        StringBuilder sb3 = new StringBuilder("welcome");

        String expected1 = "a";
        String expected2 = "gfd";
        String expected3 = "elcomew";

        assertAll(() -> {
            assertEquals(expected1, stringBuilderFormatUtility.putFirstCharToTheEnd(sb1).toString(), "putFirstCharToTheEnd should put first char to the end in the word without delimiter");
            assertEquals(expected2, stringBuilderFormatUtility.putFirstCharToTheEnd(sb2).toString(), "putFirstCharToTheEnd should put first char to the end in the word without delimiter");
            assertEquals(expected3, stringBuilderFormatUtility.putFirstCharToTheEnd(sb3).toString(), "putFirstCharToTheEnd should put first char to the end in the word without delimiter");
        });
    }

    @Test
    @DisplayName("putFirstCharToTheEnd should put first char from StringBuffer to the end but before delimiter")
    void should_putFirstCharToTheEndButBeforeDelimiter_when_stringContainsDelimiter() {
        StringBuilder sb1 = new StringBuilder("a,))!");
        StringBuilder sb2 = new StringBuilder("dgf,");
        StringBuilder sb3 = new StringBuilder("welcome!!");

        String expected1 = "a,))!";
        String expected2 = "gfd,";
        String expected3 = "elcomew!!";

        assertAll(() -> {
            assertEquals(expected1, stringBuilderFormatUtility.putFirstCharToTheEnd(sb1).toString(), "putFirstCharToTheEnd should put first char from StringBuffer to the end but before delimiter");
            assertEquals(expected2, stringBuilderFormatUtility.putFirstCharToTheEnd(sb2).toString(), "putFirstCharToTheEnd should put first char from StringBuffer to the end but before delimiter");
            assertEquals(expected3, stringBuilderFormatUtility.putFirstCharToTheEnd(sb3).toString(), "putFirstCharToTheEnd should put first char from StringBuffer to the end but before delimiter");
        });
    }

    @Test
    @DisplayName("findDelimiterIndex should return first delimiter index or -1 if there is any delimiters")
    void should_returnDelimiterIndex_when_stringContainsDelimiter() {
        StringBuilder sb1 = new StringBuilder("aaaa,,");
        StringBuilder sb2 = new StringBuilder(",");
        StringBuilder sb3 = new StringBuilder("");

        assertAll(() -> {
            assertEquals(4, stringBuilderFormatUtility.findDelimiterIndex(sb1), "findDelimiterIndex should return delimiter index or -1 if there is any delimiters");
            assertEquals(0, stringBuilderFormatUtility.findDelimiterIndex(sb2), "findDelimiterIndex should return delimiter index or -1 if there is any delimiters");
            assertEquals(-1, stringBuilderFormatUtility.findDelimiterIndex(sb3), "findDelimiterIndex should return delimiter index or -1 if there is any delimiters");
        });
    }

    @Test
    @DisplayName("applyUpperCaseToFirstCharacter should replace first character with it's upper-case version")
    void should_changeFirstCharacterToUpperCase() {
        StringBuilder sb1 = new StringBuilder("a,))!");
        StringBuilder sb2 = new StringBuilder("dgf,");
        StringBuilder sb3 = new StringBuilder("welcome!!");

        String expected1 = "A,))!";
        String expected2 = "Dgf,";
        String expected3 = "Welcome!!";

        assertAll(() -> {
            assertEquals(expected1, stringBuilderFormatUtility.applyUpperCaseToFirstCharacter(sb1).toString(), "applyUpperCaseToFirstCharacter should replace first character with it's upper-case version");
            assertEquals(expected2, stringBuilderFormatUtility.applyUpperCaseToFirstCharacter(sb2).toString(), "applyUpperCaseToFirstCharacter should replace first character with it's upper-case version");
            assertEquals(expected3, stringBuilderFormatUtility.applyUpperCaseToFirstCharacter(sb3).toString(), "applyUpperCaseToFirstCharacter should replace first character with it's upper-case version");
        });
    }

}

