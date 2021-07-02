package main.java.task4.weather;

import main.java.task4.api.RouteeOpenWeatherURIStorage;
import main.java.task4.api.weather.WeatherURIStorage;
import main.java.task4.http.HttpRequestHandler;
import main.java.task4.http.HttpRequestHandlerBasicJavaImpl;
import main.java.task4.parser.weather.TemperatureInformationParser;
import main.java.task4.parser.weather.TemperatureInformationParserOpenWeatherImpl;

/**
 * TemperatureGathererOpenWeatherImpl class
 * implementation of {@link TemperatureGatherer} for Open Weather API
 */
public class TemperatureGathererOpenWeatherImpl implements TemperatureGatherer {

    private static final HttpRequestHandler REQUEST_HANDLER = new HttpRequestHandlerBasicJavaImpl();
    private static final WeatherURIStorage WEATHER_STORAGE = new RouteeOpenWeatherURIStorage();
    private static final TemperatureInformationParser PARSER = new TemperatureInformationParserOpenWeatherImpl();

    @Override
    /**
     * getTemperature method
     * method for getting temperature at OpenWeatherAPI
     *
     * return Double - parsed temperature in Celsius
     */
    public Double getTemperature() {
        return PARSER.parseTemperature(REQUEST_HANDLER.sendGetRequest(WEATHER_STORAGE.getWeatherURI()).body());
    }
}
