package clients;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.http.ContentType;
import utils.ApiResponse;
import utils.Config;

public class BaseApiClient {
    protected static final String baseUrl;

    static {
        baseUrl = Config.getBaseUrl();
        RestAssured.baseURI = baseUrl;
    }

    public BaseApiClient() {
        // No need to set baseURI here since static initializer already does it
    }

    private Response post(String endpoint, Object body) {
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .body(body)
                .log().all()                      // Log full request details
                .post(endpoint)
                .then()
                .log().all()                      // Log full response details
                .extract()
                .response();
    }

    protected <T> ApiResponse<T> post(String endpoint, Object body, Class<T> responseClass) {
        Response response = post(endpoint, body);
        return new ApiResponse<>(response, responseClass);
    }

    protected <T> ApiResponse<T> get(String endpoint, Class<T> responseClass) {
        Response response = RestAssured.given()
                .log().all()                     // Log full request details
                .get(endpoint)
                .then()
                .log().all()                     // Log full response details
                .extract()
                .response();
        return new ApiResponse<>(response, responseClass);
    }
}
