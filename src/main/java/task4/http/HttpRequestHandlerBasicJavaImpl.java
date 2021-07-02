package main.java.task4.http;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.logging.Logger;

/**
 * HttpRequestHandlerBasicJavaImpl class
 * implementation of {@link HttpRequestHandler} on native java
 */
public class HttpRequestHandlerBasicJavaImpl implements HttpRequestHandler {
    private static final Logger LOG = Logger.getLogger(HttpRequestHandlerBasicJavaImpl.class.getName());
    private static final String AUTHORIZATION_HEADER = "authorization";
    private static final String CONTENT_TYPE_HEADER = "content-type";

    /**
     * sendGetRequest method
     * Method that is used to send the GET http requests
     *
     * @param uri needed to form te request
     * @return HttpResponse - response from request
     */
    @Override
    public HttpResponse<String> sendGetRequest(URI uri) {
        HttpRequest request = HttpRequest
                .newBuilder(uri)
                .GET()
                .build();
        return getResponseForRequest(request);
    }

    /**
     * sendGetRequest method
     * Method that is used to send the POST http requests
     *
     * @param uri           needed to form te request
     * @param body          of the request
     * @param contentType   of the request
     * @param authorization for accessing the resources
     * @return HttpResponse - response from request
     */
    @Override
    public HttpResponse<String> sendPostRequest(URI uri, String body, String contentType, String authorization) {
        HttpRequest request = HttpRequest.newBuilder(uri)
                .header(AUTHORIZATION_HEADER, authorization)
                .header(CONTENT_TYPE_HEADER, contentType)
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .build();
        return getResponseForRequest(request);
    }

    private HttpResponse<String> getResponseForRequest(HttpRequest request) {
        HttpClient client = HttpClient.newBuilder().build();
        try {
            return client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            LOG.severe("response acquiring failed, null value will be returned");
            return null;
        }
    }
}
