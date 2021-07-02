package main.java.task4.phone;

import main.java.task4.api.RouteeOpenWeatherURIStorage;
import main.java.task4.api.phone.DataType;
import main.java.task4.api.phone.PhoneURIAndDataStorage;
import main.java.task4.http.HttpRequestHandler;
import main.java.task4.http.HttpRequestHandlerBasicJavaImpl;
import main.java.task4.utils.RouteeAuthenticator;
import main.java.task4.utils.SMSMessageBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpResponse;
import java.util.Map;
import java.util.logging.Logger;

/**
 * RouteeSendSMS class
 * implementation of {@link SendSMS} interface for Routee API
 */
public class RouteeSendSMS implements SendSMS {
    private static final Logger LOG = Logger.getLogger(RouteeSendSMS.class.getName());
    private static final PhoneURIAndDataStorage URI_AND_DATA_STORAGE = new RouteeOpenWeatherURIStorage();
    private static final HttpRequestHandler HTTP_REQUEST_HANDLER = new HttpRequestHandlerBasicJavaImpl();
    private static final RouteeAuthenticator AUTHENTICATOR = new RouteeAuthenticator();
    private static final String BEARER = "Bearer ";

    private final Integer temperatureLimit;
    private final String temperatureLessLimitMessage;
    private final String temperatureMoreLimitMessage;

    public RouteeSendSMS(Integer temperatureLimit) {
        this.temperatureLimit = temperatureLimit;
        this.temperatureLessLimitMessage = "Temperature is less than " + temperatureLimit + "C";
        this.temperatureMoreLimitMessage = "Temperature is more than " + temperatureLimit + "C";
    }

    /**
     * sendSMS method
     * sends SMS with the passed temperature,
     * if temperature is more than temperatureLimit variable, than number should be changed
     *
     * @param temperature to send
     * @return Integer - sending status
     */
    @Override
    public Integer sendSMS(Double temperature) {
        LOG.info("SMS sending process started");

        Map<DataType, String> dataForRequestMap = URI_AND_DATA_STORAGE.getPhoneURLAndData();
        String authToken = BEARER + AUTHENTICATOR.getAuthToken();
        String numberToSend = temperature >= temperatureLimit ?
                dataForRequestMap.get(DataType.NUMBER_TO_SEND_IN_HOT_WEATHER) :
                dataForRequestMap.get(DataType.NUMBER_TO_SEND_COLD_WEATHER);
        String messageText = temperature >= temperatureLimit ? temperatureMoreLimitMessage : temperatureLessLimitMessage;

        String body = SMSMessageBuilder.buildSMSMessage(dataForRequestMap.get(DataType.SENDER) + messageText,
                dataForRequestMap.get(DataType.SENDER),
                numberToSend);

        HttpResponse response = HTTP_REQUEST_HANDLER.sendPostRequest(
                getURIFromStringURL(dataForRequestMap.get(DataType.APPLICATION_URL)),
                body,
                dataForRequestMap.get(DataType.CONTENT_TYPE_HEADER),
                authToken);
        LOG.info("SMS has been send, response status is:" + response.statusCode());
        return response.statusCode();
    }

    private URI getURIFromStringURL(String url) {
        try {
            return new URI(url);
        } catch (URISyntaxException e) {
            LOG.severe("Cant form URI, null value will be returned");
            return null;
        }
    }
}
