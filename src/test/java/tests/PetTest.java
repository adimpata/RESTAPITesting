package tests;

import DataManager.PetManager;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;
import requests.RequestUtils;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class PetTest extends Base {
    /**
     * Test case for getting a specific pet.
     */
    @Test
    public void getPetTest() {
        RestAssured.baseURI = Base.URI;
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("id", "1");
        Response response = RequestUtils.sendRequest("v2/pet/1", Method.GET, queryParams);
        printResponseDetails(response);
    }

    /**
     * Test case for comparing expected JSON response with actual response.
     */
    @Test
    public void getRespJsonTest() {
        RestAssured.baseURI = Base.URI;
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("id", "1");
        Response response = RequestUtils.sendRequest("v2/pet/1", Method.GET, queryParams);
        String actualResponse = response.getBody().asString();
        String expectedResponse = PetManager.serializePetToJson();
        System.out.println("Expected: " + expectedResponse);
        System.out.println("Actual: " + actualResponse);
        assertEquals(expectedResponse, actualResponse);
    }

    /**
     * Test case for finding pets by status.
     */
    @Test
    public void getFindByStatusTest() {
        RestAssured.baseURI = Base.URI;
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("status", "sold");
        Response response = RequestUtils.sendRequest("v2/pet/findByStatus", Method.GET, queryParams);
        printResponseDetails(response);
    }

    /**
     * Test case for posting a new pet.
     */
    @Test
    public void postPetTest() {
        RestAssured.baseURI = Base.URI;
        String request = "{\n" + "  \"id\": 0,\n" + "  \"category\": {\n" + "    \"id\": 0,\n" + "    \"name\": \"string\"\n" + "  },\n" + "  \"name\": \"doggie\",\n" + "  \"photoUrls\": [\n" + "    \"string\"\n" + "  ],\n" + "  \"tags\": [\n" + "    {\n" + "      \"id\": 0,\n" + "      \"name\": \"string\"\n" + "    }\n" + "  ],\n" + "  \"status\": \"available\"\n" + "}";
        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.header("Content-Type", "application/json");
        httpRequest.body(request);
        Response response = httpRequest.request(Method.POST, "/v2/pet");
        printResponseDetails(response);
    }

    /**
     * Test case for deleting a pet.
     */
    @Test
    public void deletePetTest() {
        RestAssured.baseURI = Base.URI;
        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.header("Content-Type", "application/json").header("accept", "application/json");
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("id", "1");
        Response response = RequestUtils.sendRequest("/v2/pet/1", Method.DELETE, queryParams);
        printResponseDetails(response);
    }

}
