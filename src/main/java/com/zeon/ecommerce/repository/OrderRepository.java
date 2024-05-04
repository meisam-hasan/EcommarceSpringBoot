package com.zeon.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.zeon.ecommerce.dto.MaxSaleDayDTO;
import com.zeon.ecommerce.entity.Order;
import java.util.Date;

public interface OrderRepository extends JpaRepository<Order, Long> {

    // Query to get the total sale amount for the current day
    @Query("SELECT SUM(op.quantity * p.price) FROM Order o JOIN o.orderProducts op JOIN op.product p WHERE FUNCTION('DATE', o.orderDate) = CURRENT_DATE")
    Double getTotalSaleAmountForCurrentDay();


    @Query("SELECT NEW com.zeon.ecommerce.dto.MaxSaleDayDTO(DATE_TRUNC('day', o.orderDate), SUM(op.quantity * p.price)) " +
           "FROM Order o JOIN o.orderProducts op JOIN op.product p " +
           "WHERE o.orderDate BETWEEN :startDate AND :endDate " +
           "GROUP BY DATE_TRUNC('day', o.orderDate) " +
           "ORDER BY SUM(op.quantity * p.price) DESC " +
           "LIMIT 1")
    MaxSaleDayDTO getMaxSaleDayWithinTimeRange(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
}
