package com.zeon.ecommerce.controller;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import com.zeon.ecommerce.dto.MaxSaleDayDTO;
import com.zeon.ecommerce.util.DateUtil;
import io.restassured.http.ContentType;
import java.text.ParseException;
import java.util.Date;
import static org.hamcrest.Matchers.greaterThan;

public class OrderControllerTest extends BaseCotrollerTest {

    @Test
    public void testGetTotalSaleAmountForCurrentDay() {

        // Test endpoint
        getRequestSpec().when().get("/orders/todaySaleAmount")
                .then().statusCode(200) // Ensure successful response
                .log().all()
                .body("$", Matchers.notNullValue()); // Ensure response is not null
    }

    @Test
    public void testGetMaxSaleDayWithinTimeRange() throws ParseException {
        getRequestSpec().contentType(ContentType.JSON)
                        .queryParam("startDate", 
                        "2024-04-15 00:00:00")
                        .queryParam("endDate", 
                        "2024-04-15 23:59:59")
                        .when().log().all()
                .get("/orders/maxSaleDay")
                .then()
                        .log().all()
                        .statusCode(200)
                        .contentType(ContentType.JSON)
                        .body("date", Matchers.notNullValue())
                        .body("totalSaleAmount", greaterThan(0.0f))
                        .extract()
                        .as(MaxSaleDayDTO.class);

        // Add assertions for the response content here
    }
}
