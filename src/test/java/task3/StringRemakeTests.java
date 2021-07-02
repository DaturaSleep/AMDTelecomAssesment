package test.java.task3;

import main.java.task3.StringRemake;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * StringRemake_test class
 * <p>
 * Unit tests for {@link StringRemake}
 */
@Nested
@DisplayName("StringRemake tests")
class StringRemakeTests {
    StringRemake stringRemake = new StringRemake();

    @Test
    @DisplayName("Task test examples")
    void test_examples() {
        String string1 = "Cats are great pets.";
        String expected1 = "Atscay areway reatgay etspay.";

        String string2 = "Tom got a small piece of pie.";
        String expected2 = "Omtay otgay away mallsay iecepay ofway iepay."; // in the task there are allsmay as the expected but the result should be mallsay

        String string3 = "He told us a very exciting tale.";
        String expected3 = "Ehay oldtay usway away eryvay excitingway aletay.";

        assertAll(() -> {
            assertEquals(expected1, stringRemake.doRemake(string1), "Result should be the same as provided in the task");
            assertEquals(expected2, stringRemake.doRemake(string2), "Result should be the same as provided in the task");
            assertEquals(expected3, stringRemake.doRemake(string3), "Result should be the same as provided in the task");
        });
    }

    @Test
    @DisplayName("doRemake should not replace non characters words but just skip them")
    void should_skipString_when_stringDoesNotContainAlphaCharacters() {
        String sentence = "Tom 98553 got a 33320 small piece !0))) of pie.";
        String expected = "Omtay 98553 otgay away 33320 mallsay iecepay !0))) ofway iepay.";

        assertEquals(expected, stringRemake.doRemake(sentence), "doRemake should not replace non characters words but just skip them");
    }

    @Test
    @DisplayName("doRemake should be able to handle different separators")
    void should_handleDifferentSeparators() {
        String sentence = "Cats   \t are \t great \n pets.";
        String expected = "Atscay areway reatgay etspay.";

        assertEquals(expected, stringRemake.doRemake(sentence), "doRemake should be able to handle different separators");
    }

    @Test
    @DisplayName("doRemake should be able to handle punctuation in a proper way")
    void should_handlePunctuation() {
        String sentence = "Cats are,, great, pets...";
        String expected = "Atscay areway,, reatgay, etspay...";

        assertEquals(expected, stringRemake.doRemake(sentence), "doRemake should be able to handle punctuation in a proper way");
    }
}

