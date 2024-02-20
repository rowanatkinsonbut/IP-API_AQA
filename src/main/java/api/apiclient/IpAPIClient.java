package api.apiclient;

import com.fasterxml.jackson.databind.ObjectMapper;
import utils.PropertiesReader;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

public class IpAPIClient {
    private final String baseUrl;
    private final HttpClient httpClient;
    private final ObjectMapper objectMapper;
    private final Map<String, String> headers = new HashMap<>();


    public IpAPIClient() {
        this.baseUrl = new PropertiesReader().getMainUrl();
        this.objectMapper = new ObjectMapper();
        this.httpClient = HttpClient.newHttpClient();
        this.headers.put("accept", "application/json");
    }

    /**
     * Sends a GET request to the IP API with the specified query parameter.
     *
     * @param queryParameter The query parameter to be appended to the base URL.
     * @param modelType      The class type of the response model.
     * @return The response object of the specified model type.
     * @throws RuntimeException if an error occurs during the request.
     */
    public Object getWithQueryParameter(String queryParameter, Class<?> modelType) {
        try {
            String apiUrl = baseUrl + queryParameter;
            HttpRequest.Builder requestBuilder = HttpRequest.newBuilder()
                    .GET()
                    .uri(URI.create(apiUrl));
            headers.forEach(requestBuilder::header);
            HttpResponse<String> response = httpClient.send(requestBuilder.build(), HttpResponse.BodyHandlers.ofString());
            return verifyStatusCode(response, modelType);
        } catch (InterruptedException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Verifies the status code of the HTTP response and processes the response body.
     *
     * @param response  The HTTP response object.
     * @param modelType The class type of the response model.
     * @return The response object of the specified model type.
     * @throws RuntimeException if the response status code is not 200 (OK) or an error occurs during processing.
     */
    private Object verifyStatusCode(HttpResponse<String> response, Class<?> modelType) {
        if (response.statusCode() == 200) {
            try {
                return objectMapper.readValue(response.body(), modelType);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            throw new RuntimeException("API Request failed with status code: " + response.statusCode() + " Error message: " + response.body());
        }
    }
}
