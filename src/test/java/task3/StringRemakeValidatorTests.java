package test.java.task3;

import main.java.task3.StringRemakeValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * StringRemakeValidator_test class
 * <p>
 * Unit tests for {@link StringRemakeValidator}
 */
@Nested
@DisplayName("StringRemakeValidator tests")
class StringRemakeValidatorTests {

    StringRemakeValidator stringRemakeValidator = new StringRemakeValidator();

    @Test
    @DisplayName("Validation should throw exception if string is not properly formed")
    void should_throwIllegalArgumentException_when_stringIsNotProperlyFormed() {
        String string1 = null;
        String string2 = "";
        String string3 = ".";
        String string4 = " . ";
        Executable execution1 = () -> {
            stringRemakeValidator.validateString(string1);
        };
        Executable execution2 = () -> {
            stringRemakeValidator.validateString(string2);
        };
        Executable execution3 = () -> {
            stringRemakeValidator.validateString(string3);
        };
        Executable execution4 = () -> {
            stringRemakeValidator.validateString(string4);
        };

        assertAll(() -> {
            assertThrows(IllegalArgumentException.class, execution1, "Validation should throw exception if string is not properly formed");
            assertThrows(IllegalArgumentException.class, execution2, "Validation should throw exception if string is not properly formed");
            assertThrows(IllegalArgumentException.class, execution3, "Validation should throw exception if string is not properly formed");
            assertThrows(IllegalArgumentException.class, execution4, "Validation should throw exception if string is not properly formed");
        });
    }

}
