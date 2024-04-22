package requests;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

public class RequestUtils {
    /**
     * Sends an HTTP request with the specified method, endpoint, and query parameters.
     *
     * @param endpoint    The endpoint or URL of the request.
     * @param method      The HTTP method (GET, POST, DELETE, etc.).
     * @param queryParams The query parameters to be included in the request, if any.
     * @return The response object containing the result of the request.
     * @throws IllegalArgumentException If an unsupported HTTP method is provided.
     */
    public static Response sendRequest(String endpoint, Method method, Map<String, String> queryParams) {
        RequestSpecification httpRequest = RestAssured.given();

        if (queryParams != null) {
            httpRequest = httpRequest.queryParams(queryParams);
        }
        switch (method) {
            case GET:
                return httpRequest.request(Method.GET, endpoint);
            case POST:
                return httpRequest.request(Method.POST, endpoint);
            case DELETE:
                return httpRequest.request(Method.DELETE, endpoint);
            default:
                throw new IllegalArgumentException("Unsupported HTTP method: " + method);
        }
    }
}
