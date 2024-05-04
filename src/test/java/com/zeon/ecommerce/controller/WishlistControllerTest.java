package com.zeon.ecommerce.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import com.zeon.ecommerce.TestContainerExtension;
import org.hamcrest.Matchers;
import static io.restassured.RestAssured.given;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ExtendWith(TestContainerExtension.class)
public class WishlistControllerTest {
    @LocalServerPort
    private int port;


    @Test
    public void testGetWishlistForUser() {

        // Test endpoint
        given().basePath("/").port(port).when().get("/wishlist/user/{userId}", 1L) // Assuming
                                                                                   // userId = 1
                .then().statusCode(200) // Ensure successful response
                .log().all()
                .body("$", Matchers.notNullValue()); // Ensure response is not null
    }

}
