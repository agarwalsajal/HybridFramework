package api.ApiClient;

import api.specs.RequestSpecFactory;
import io.restassured.response.Response;
import utils.ExtentLogger;

import static io.restassured.RestAssured.*;
public class ApiClient {

    public static Response get(String endpoint)
    {
        System.out.println("test abc");
         ExtentLogger.info(
                "HTTP Method : GET");

        ExtentLogger.info(
                "Endpoint : " + endpoint);

        Response response =
                given()
                    .spec(RequestSpecFactory.getRequestSpec())
                .when()
                    .get(endpoint);

        ExtentLogger.info(
                "Status Code : "
                        + response.statusCode());

        ExtentLogger.info(
                "Response Time : "
                        + response.time()
                        + " ms");

        ExtentLogger.info(
                "Response Body : \n"
                        + response.getBody()
                                  .asPrettyString());

        return response;

    }

    public static Response post(
            String endpoint,
            Object body) {

        return given()
                .spec(RequestSpecFactory.getRequestSpec())
                .body(body)
                .when()
                .post(endpoint);
    }
    
}
