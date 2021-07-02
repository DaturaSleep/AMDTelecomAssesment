package main.java.task4.api.phone;

import java.util.Map;

/**
 * PhoneURIAndDataStorage interface
 * <p>
 * interface that describes main function that returns map of data needed
 * to form http request
 */
public interface PhoneURIAndDataStorage {
    Map<DataType, String> getPhoneURLAndData();
}
