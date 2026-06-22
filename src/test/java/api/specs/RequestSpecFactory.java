package api.specs;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import utils.ConfigReader;

public class RequestSpecFactory {

    public static RequestSpecification getRequestSpec() {

        return new RequestSpecBuilder()
                .setBaseUri
                (ConfigReader.getProperty("apiUrl"))
                .setContentType("application/json")
                .build();
    }
}