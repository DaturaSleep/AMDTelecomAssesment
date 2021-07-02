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
    private static final PhoneURIAndDataStorage uriAndDataStorage = new RouteeOpenWeatherURIStorage();
    private static final HttpRequestHandler httpRequestHandler = new HttpRequestHandlerBasicJavaImpl();
    private static final RouteeAuthenticator authenticator = new RouteeAuthenticator();

    /**
     * sendSMS method
     * sends SMS with the passed temperature,
     * if temperature is more than 20, than number should be changed
     *
     * @param temperature to send
     * @return Integer - sending status
     */
    @Override
    public Integer sendSMS(Double temperature) {
        LOG.info("SMS sending process started");

        Map<DataType, String> dataForRequestMap = uriAndDataStorage.getPhoneURLAndData();
        String authToken = "Bearer " + authenticator.getAuthToken();
        String numberToSend = temperature >= 20 ?
                dataForRequestMap.get(DataType.NUMBER_TO_SEND_IN_HOT_WEATHER) :
                dataForRequestMap.get(DataType.NUMBER_TO_SEND_COLD_WEATHER);
        String messageText = temperature >= 20 ? "Temperature is more than 20C" : "Temperature is less than 20C";

        String body = SMSMessageBuilder.buildSMSMessage(dataForRequestMap.get(DataType.SENDER) + messageText,
                dataForRequestMap.get(DataType.SENDER),
                numberToSend);

        HttpResponse response = httpRequestHandler.sendPostRequest(
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
