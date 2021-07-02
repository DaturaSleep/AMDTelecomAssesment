package main.java.task4.http;

import java.net.URI;
import java.net.http.HttpResponse;

/**
 * HttpRequestHandler interface
 * Describes two main methods for http interaction
 */
public interface HttpRequestHandler {

    HttpResponse<String> sendGetRequest(URI uri);

    HttpResponse<String> sendPostRequest(URI uri, String body, String contentType, String authorization);

}
