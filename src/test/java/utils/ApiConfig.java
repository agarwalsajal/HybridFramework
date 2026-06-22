package utils;
import io.restassured.RestAssured;
public class ApiConfig {

     public static void setup() {

        RestAssured.baseURI =
                ConfigReader.getProperty("apiUrl");
    }
    
}
