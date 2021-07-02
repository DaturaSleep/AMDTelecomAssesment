package main.java.task4.parser.weather;

import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * TemperatureInformationParserOpenWeatherImpl class
 * Implementation of {@link TemperatureInformationParser} for Open Weather API
 */
public class TemperatureInformationParserOpenWeatherImpl implements TemperatureInformationParser {

    private static final Logger LOG = Logger.getLogger(TemperatureInformationParserOpenWeatherImpl.class.getName());

    private static final String API_TEMPERATURE_PATTERN = "\"temp\":";
    private static final Integer API_TEMPERATURE_AMOUNT_OF_DIGITS = 5;

    /**
     * parseTemperature method
     * parses temperature from String body received on Open Weather API
     *
     * @param stringToParseAt - String that contains temperature
     * @return Double - parsed temperature
     */
    @Override
    public Double parseTemperature(String stringToParseAt) {
        Pattern pattern = Pattern.compile(API_TEMPERATURE_PATTERN);
        Matcher matcher = pattern.matcher(stringToParseAt);

        if (matcher.find()) {
            String temperature = stringToParseAt.substring(matcher.end(), matcher.end() + API_TEMPERATURE_AMOUNT_OF_DIGITS);
            try {
                return Double.parseDouble(temperature);
            } catch (NumberFormatException exception) {
                LOG.severe("Could not parse temperature, null value will be returned: " + exception.getMessage());
            }
        }
        return null;
    }
}
