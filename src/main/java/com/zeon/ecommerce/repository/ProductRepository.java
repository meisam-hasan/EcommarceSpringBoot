package com.zeon.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.zeon.ecommerce.dto.TopCountSellingItem;
import com.zeon.ecommerce.dto.TopSellingItem;
import com.zeon.ecommerce.entity.Product;
// import com.zeon.ecommerce.entity.ProductDTO;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
        // Query to get the top 5 selling items of all time based on total sale amount
        @Query("SELECT new com.zeon.ecommerce.dto.TopSellingItem(p, SUM(op.quantity * op.pricePerUnit) AS totalSaleAmount) "
                        + "FROM Product p JOIN p.orderProducts op " + "GROUP BY p "
                        + "ORDER BY totalSaleAmount DESC" + " LIMIT 5")
        List<TopSellingItem> findTop5SellingItems();

        @Query(value = "SELECT p AS product, COUNT(op.id) AS salesCount "
                        + "FROM products p " + "JOIN order_products op ON p.id = op.product_id "
                        + "JOIN orders o ON op.order_id = o.id "
                        + "WHERE (DATE_TRUNC('month', CURRENT_DATE) - interval '1 month') = DATE_TRUNC('month', o.order_date) "
                        + "GROUP BY p.id, p.name, p.price " + "ORDER BY salesCount DESC "
                        + "LIMIT 5", nativeQuery = true)
        List<TopCountSellingItem> findTop5SellingItemsLastMonth();



}
