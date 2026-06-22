package api.ApiValidator;
import io.restassured.response.Response;
//
import models.ProductsResponse;
import utils.ExtentLogger;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import org.testng.Assert;

public class ApiValidator {

    public static void validateStatusCode(Response response, int expectedStatusCode)
    {
     
        Assert.assertEquals(response.statusCode(), expectedStatusCode, "Status Code Validation Failed");
        ExtentLogger.pass(
            "Status Code Validation Passed");
    }

    /* public static void validateProductCount(
            ProductsResponse response,
            int expectedCount)
    {
        Assert.assertEquals(
                response.getProducts().size(),
                expectedCount,
                "Product Count Validation Failed");
    }

    public static void validateFirstProductName(
            ProductsResponse response,
            String expectedName)
    {
        Assert.assertEquals(
                response.getProducts()
                        .get(0)
                        .getName(),
                expectedName,
                "Product Name Validation Failed");
    }*/

    public static void validateResponseBody(Response response, int expectedStatusCode)
    {
        int actualCode=response.jsonPath().getInt("responseCode");
        Assert.assertEquals(actualCode,expectedStatusCode,"Response Code Mismatch");
    }
    
   
    public static void validateJsonValue(
        Response response,
        String jsonPath,
        String expectedValue) {

    String actualValue =
            response.jsonPath()
                    .getString(jsonPath);

    Assert.assertEquals(
            actualValue,
            expectedValue);
}

public static void validateHeader(
        Response response,
        String headerName,
        String expectedValue) {

    Assert.assertEquals(
            response.getHeader(headerName),
            expectedValue);
}

public static void validateResponseTime(
        Response response,
        long maxTime) {

    Assert.assertTrue(
            response.getTime() < maxTime,
            "Response Time Exceeded");
}


public static void validateArraySize(
        Response response,
        String path,
        int expectedSize) {

    int actualSize =
            response.jsonPath()
                    .getList(path)
                    .size();

    Assert.assertEquals(
            actualSize,
            expectedSize);
}


public static void validateContains(
        Response response,
        String expectedText) {

    Assert.assertTrue(
            response.asString()
                    .contains(expectedText));
}
public static void validateSchema(
        Response response,
        String schemaFile)
{
    response.then()
            .assertThat()
            .body(
                matchesJsonSchemaInClasspath(
                    "schemas/" + schemaFile));
}

}
