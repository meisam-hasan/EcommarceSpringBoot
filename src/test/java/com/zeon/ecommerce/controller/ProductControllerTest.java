package com.zeon.ecommerce.controller;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

public class ProductControllerTest extends BaseCotrollerTest {

    @Test
    public void testGetTop5SellingItems() {
        getRequestSpec().when().get("/products/top5SellingItems") // Assuming
                                                                           // userId = 1
                .then().statusCode(200) // Ensure successful response
                .log().all().body("$", Matchers.notNullValue());
    }
    
    @Test
    public void testGetTop5SellingItemsLastMonth() {
        getRequestSpec().when().get("/products/top5SellingItemsLastMonth") // Assuming
                                                                                   // userId = 1
                .then().statusCode(200) // Ensure successful response
                .log().all()
                .body("$", Matchers.notNullValue());
    }

}
