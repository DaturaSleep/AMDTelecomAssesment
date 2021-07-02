package test.java.task4;

import main.java.task4.utils.RouteeAuthenticator;
import main.java.task4.utils.SMSMessageBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * UtilityTests class
 *
 * Unit tests for {@link SMSMessageBuilder} and {@link RouteeAuthenticator}
 */
@DisplayName("Utility tests")
class UtilityTests {
    @Test
    @DisplayName("Routee message builder should build correct message")
    void should_buildRouteeMessage_given_stringParameters() {

        String result = SMSMessageBuilder.buildSMSMessage("This test message.", "222", "Maks");
        String expected = "{\"body\":\"This test message.\",\"to\":\"Maks\",\"from\":\"222\"}";

        assertEquals(expected, result, "Routee message builder should build correct message");

    }

    @Test
    @DisplayName("Authentication should pass successfully")
    void should_authenticate_without_anyExceptions() {
        RouteeAuthenticator authenticator = new RouteeAuthenticator();
        assertTrue(Objects.nonNull(authenticator.getAuthToken()), "Authentication should pass successfully");
    }
}
