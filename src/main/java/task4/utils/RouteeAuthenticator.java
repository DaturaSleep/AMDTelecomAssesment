package main.java.task4.utils;

import main.java.task4.http.HttpRequestHandler;
import main.java.task4.http.HttpRequestHandlerBasicJavaImpl;
import main.java.task4.parser.phone.RouteTokenParser;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpResponse;
import java.util.Base64;
import java.util.logging.Logger;

/**
 * RouteAuthenticator class
 * class for generating the security token from API
 */
public class RouteeAuthenticator {
    private static final Logger LOG = Logger.getLogger(RouteeAuthenticator.class.getName());

    private static final String APPLICATION_URL = "https://auth.routee.net/oauth/token";
    private static final String CONTENT_TYPE_HEADER = "application/x-www-form-urlencoded";
    private static final String BODY = "grant_type=client_credentials";

    private static final String APPLICATION_KEY = "5c5d5e28e4b0bae5f4accfec";
    private static final String APPLICATION_SECRET = "MGkNfqGud0";

    private final HttpRequestHandler httpRequestMaker = new HttpRequestHandlerBasicJavaImpl();
    private final RouteTokenParser routeTokenParser = new RouteTokenParser();

    /**
     * getAuthToken method
     * method that is used to obtain security token from Routee API
     * HttpResponse<String> response = null;
     *
     * @return String - security token for POST requests
     */
    public String getAuthToken() {
        return routeTokenParser.parse(authenticate().body());
    }

    private HttpResponse<String> authenticate() {
        StringBuilder authHeaderBuilder = new StringBuilder("Basic " + encode(APPLICATION_KEY + ":" + APPLICATION_SECRET));
        URI applicationURI = null;
        try {
            applicationURI = new URI(APPLICATION_URL);
        } catch (URISyntaxException e) {
            LOG.severe("Application URI is not well formed, check url provided");
        }
        return httpRequestMaker.sendPostRequest(applicationURI, BODY, CONTENT_TYPE_HEADER, authHeaderBuilder.toString());
    }


    private String encode(String stringToEncode) {
        return Base64.getEncoder().encodeToString(stringToEncode.getBytes());
    }


}
