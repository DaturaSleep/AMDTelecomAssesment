package test.java.task4;

import main.java.task4.parser.weather.TemperatureInformationParser;
import main.java.task4.parser.weather.TemperatureInformationParserOpenWeatherImpl;
import main.java.task4.weather.TemperatureGatherer;
import main.java.task4.weather.TemperatureGathererOpenWeatherImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 * TemperatureTests class
 *
 * Unit tests for {@link TemperatureGathererOpenWeatherImpl}
 */
@DisplayName("Temperature tests")
class TemperatureTests {
    @Test
    @DisplayName("Temperature should be extracted successfully from API")
    void should_extractTemperatureFromApi_without_anyExceptions() {
        TemperatureGatherer gatherer = new TemperatureGathererOpenWeatherImpl();
        assertTrue(Objects.nonNull(gatherer.getTemperature()), "Temperature should be extracted sucessfully from API");
    }

    @Test
    @DisplayName("There should be no errors in parsing temperature")
    void should_parseTemperature_without_anyExceptions() {
        TemperatureInformationParser parser = new TemperatureInformationParserOpenWeatherImpl();
        String temperature = "\"temp\":20.00";
        Double expected = 20.0;

        assertEquals(expected, parser.parseTemperature(temperature), "There should be no errors in parsing temperature");
    }
}
