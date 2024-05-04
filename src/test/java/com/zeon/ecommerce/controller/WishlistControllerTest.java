package com.zeon.ecommerce.controller;

import org.junit.jupiter.api.Test;
import org.hamcrest.Matchers;

public class WishlistControllerTest extends BaseCotrollerTest{
    @Test
    public void testGetWishlistForUser() {

        // Test endpoint
        getRequestSpec().when().get("/wishlist/user/{userId}", 1L) // Assuming
                                                                                   // userId = 1
                .then().statusCode(200) // Ensure successful response
                .log().all()
                .body("$", Matchers.notNullValue()); // Ensure response is not null
    }

}
