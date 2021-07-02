package test.java.task4;

import main.java.task4.phone.RouteeSendSMS;
import main.java.task4.phone.SendSMS;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * RouteeSendSMSTests class
 *
 * Unit tests for {@link RouteeSendSMS}
 */
@DisplayName("SMS sender tests")
class RouteeSendSMSTests {
    @Test
    @DisplayName("SMS should be sent successfully when temperature is less that 20 and higher than 20")
    void should_sendSMS_without_anyExceptions() {
        SendSMS smsSender = new RouteeSendSMS();

        Double temperature1 = 19.0;
        Double temperature2 = 21.0;

        assertAll(() -> {
            assertEquals(200, smsSender.sendSMS(temperature1), "SMS should be sent successfully when temperature is less that 20 and higher than 20");
            assertEquals(200, smsSender.sendSMS(temperature2), "SMS should be sent successfully when temperature is less that 20 and higher than 20");
        });
    }

}
