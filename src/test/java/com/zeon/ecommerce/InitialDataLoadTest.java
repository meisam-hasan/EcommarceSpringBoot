package com.zeon.ecommerce;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ExtendWith(TestContainerExtension.class)
public class InitialDataLoadTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testDataLoading() {
        // Query the database to check if data is loaded
        int userCount = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM users", Integer.class);
        int productCount =
                jdbcTemplate.queryForObject("SELECT COUNT(*) FROM products", Integer.class);
        int orderCount = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM orders", Integer.class);
        int orderProductCount =
                jdbcTemplate.queryForObject("SELECT COUNT(*) FROM order_products", Integer.class);
        int wishlistCount =
                jdbcTemplate.queryForObject("SELECT COUNT(*) FROM wishlists", Integer.class);

        // Assert that data counts are as expected
        assertEquals(10, userCount); // Assuming initial 4 users + 10 more added
        assertEquals(10, productCount); // Assuming initial 10 products + 10 more added
        assertEquals(15500, orderCount); // Number of orders generated
        assertEquals(15500, orderProductCount); // Number of order products generated
        assertEquals(100, wishlistCount); // Assuming 100 wishlist items inserted
    }
}
