package com.zeon.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.zeon.ecommerce.dto.TopCountSellingItem;
import com.zeon.ecommerce.dto.TopSellingItem;
import com.zeon.ecommerce.entity.Product;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
        // Query to get the top 5 selling items of all time based on total sale amount
        @Query("SELECT new com.zeon.ecommerce.dto.TopSellingItem(p, SUM(op.quantity * op.pricePerUnit) AS totalSaleAmount) "
                        + "FROM Product p JOIN p.orderProducts op " + "GROUP BY p "
                        + "ORDER BY totalSaleAmount DESC" + " LIMIT 5")
        List<TopSellingItem> findTop5SellingItems();

        
        // Query to get the top 5 selling items of last month based on total sale amount
        @Query(name = "get_top5_selling_items_last_month", nativeQuery = true)
        List<TopCountSellingItem> findTop5SellingItemsLastMonth();



}
