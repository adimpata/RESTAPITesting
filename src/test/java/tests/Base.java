package tests;

import config.ConfigReader;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

/**
 * This class serves as the base for API test classes.
 * It provides common functionality such as retrieving the base URI from the configuration,
 * and printing details of the API response.
 */
public class Base {
    public static final String URI = ConfigReader.readBaseURI();

    public void printResponseDetails(Response response) {
        int statusCode = response.getStatusCode();
        System.out.println("Response status code is : " + statusCode);

        Headers headers = response.getHeaders();
        System.out.println("Headers is : " + headers);

        ResponseBody body = response.getBody();
        body.prettyPrint();
        System.out.println("Response body is : " + body.asString());
    }
}
