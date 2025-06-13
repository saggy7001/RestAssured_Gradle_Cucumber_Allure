package utils;

import io.restassured.http.Header;
import io.restassured.response.Response;

import java.util.Map;

public class ApiResponse<T> {
    private final int statusCode;
    private final T body;
    private final String rawBody;
    private final Response response;
    private final Map<String, String> headers;

    public ApiResponse(Response response, Class<T> responseType) {
        this.response = response;
        this.statusCode = response.getStatusCode();
        this.headers = response.getHeaders().asList().stream()
                .collect(java.util.stream.Collectors.toMap(
                        Header::getName,
                        Header::getValue));

        String contentType = response.getContentType();
        if (contentType != null && contentType.toLowerCase().contains("application/json")) {
            // Deserialize if JSON
            this.body = response.as(responseType);
            this.rawBody = null;
        } else {
            // Otherwise, don't deserialize; keep raw response string
            this.body = null;
            this.rawBody = response.asString();
        }
    }

    public int getStatusCode() {
        return statusCode;
    }

    public T getBody() {
        return body;
    }

    /**
     * Returns the raw response body as a String, useful if deserialization is not possible.
     * May be null if response was deserialized to an object.
     */
    public String getRawBody() {
        return rawBody;
    }

    public Response getRaw() {
        return response;
    }

    /**
     * Returns headers as a Map<String, String>
     */
    public Map<String, String> getHeaders() {
        return headers;
    }

    /**
     * Returns a specific header value by name (case-insensitive)
     */
    public String getHeader(String name) {
        if (name == null) return null;
        return headers.entrySet().stream()
                .filter(entry -> entry.getKey().equalsIgnoreCase(name))
                .map(Map.Entry::getValue)
                .findFirst()
                .orElse(null);
    }
}
