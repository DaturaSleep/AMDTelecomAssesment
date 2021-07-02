package main.java.task4.api;

import main.java.task4.api.phone.DataType;
import main.java.task4.api.phone.PhoneURIAndDataStorage;
import main.java.task4.api.weather.WeatherURIStorage;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * RouteeOpenWeatherURIStorage class
 * <p>
 * implementation of {@link WeatherURIStorage} and {@link PhoneURIAndDataStorage}
 * this class main function to provide {@link main.java.task4.http.HttpRequestHandler} with data needed
 * to form the request
 */
public class RouteeOpenWeatherURIStorage implements WeatherURIStorage, PhoneURIAndDataStorage {
    private static final Logger LOG = Logger.getLogger(RouteeOpenWeatherURIStorage.class.getName());

    private static final String OPEN_WEATHER_URL = "https://api.openweathermap.org/data/2.5/weather";
    private static final String CITY_NAME_IDENTIFIER = "q";
    private static final String CITY_NAME = "Thessaloniki";
    private static final String UNIT_SYSTEM_IDENTIFIER = "units";
    private static final String UNIT_SYSTEM = "metric";
    private static final String API_KEY_IDENTIFIER = "appid";
    private static final String API_KEY = "b385aa7d4e568152288b3c9f5c2458a5";

    private static final String ROUTEE_URL = "https://connect.routee.net/sms";
    private static final String NUMBER_TO_SEND_IN_HOT_WEATHER = "+306922222222";
    private static final String NUMBER_TO_SEND_COLD_WEATHER = "+306922222222";
    private static final String SENDER = "Maksym V";
    private static final String CONTENT_TYPE_HEADER = "application/json";

    /**
     * getPhoneURLAndData method
     *
     * @return Map of DataType as key and String as value.
     * This is the map for proper http request forming.
     */
    @Override
    public Map<DataType, String> getPhoneURLAndData() {
        Map<DataType, String> dataMap = new HashMap();
        dataMap.put(DataType.NUMBER_TO_SEND_COLD_WEATHER, NUMBER_TO_SEND_COLD_WEATHER);
        dataMap.put(DataType.NUMBER_TO_SEND_IN_HOT_WEATHER, NUMBER_TO_SEND_IN_HOT_WEATHER);
        dataMap.put(DataType.SENDER, SENDER);
        dataMap.put(DataType.CONTENT_TYPE_HEADER, CONTENT_TYPE_HEADER);
        dataMap.put(DataType.APPLICATION_URL, ROUTEE_URL);
        return dataMap;
    }

    /**
     * getWeatherURI method
     * This method returns URI that is needed to form http request
     *
     * @return URI for http request
     */
    @Override
    public URI getWeatherURI() {
        StringBuilder uriBuilder = new StringBuilder(OPEN_WEATHER_URL)
                .append("?")
                .append(CITY_NAME_IDENTIFIER + "=" + CITY_NAME)
                .append("&")
                .append(UNIT_SYSTEM_IDENTIFIER + "=" + UNIT_SYSTEM)
                .append("&")
                .append(API_KEY_IDENTIFIER + "=" + API_KEY);
        try {
            return new URI(uriBuilder.toString());
        } catch (URISyntaxException e) {
            LOG.severe("Weather URI can't be generated, please check your parameters, null value will be returned");
            return null;
        }

    }
}
