package main.java.task4.api.weather;

import java.net.URI;

/**
 * WeatherURIStorage interface
 * <p>
 * interface that describes main function that returns URI, needed
 * to form http request
 */
public interface WeatherURIStorage {
    URI getWeatherURI();
}
