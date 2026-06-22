package api.tests;


import org.testng.Assert;
import org.testng.annotations.Test;

import api.ApiClient.ApiClient;
import api.ApiValidator.ApiValidator;
import base.ApiBaseTest;
import io.restassured.response.Response;
import models.ProductsResponse;
import utils.ExtentLogger;

public class GetProductsTest extends ApiBaseTest {

    @Test
    public void getProducts()
    {

      
        Response response=ApiClient.get("/productsList");
       System.out.println(response.getStatusCode());
        System.out.println(response.getContentType());
       //ProductsResponse productsResponse=response.as(ProductsResponse.class);
        
         ApiValidator.validateStatusCode(response, 200);

            

      //ApiValidator.validateProductCount(productsResponse,200);
      ApiValidator.validateSchema(response, "productsSchema.json");
    }

    

    
}
