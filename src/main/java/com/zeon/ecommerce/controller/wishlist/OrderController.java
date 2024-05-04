package com.zeon.ecommerce.controller.wishlist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import com.zeon.ecommerce.dto.MaxSaleDayDTO;
import com.zeon.ecommerce.repository.OrderRepository;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    // Endpoint to get the total sale amount for the current day
    @GetMapping("/todaySaleAmount")
    public Map<String, Double> getTotalSaleAmountForCurrentDay() {
        Map<String, Double> response = new HashMap<>();
        Double totalSaleAmount = orderRepository.getTotalSaleAmountForCurrentDay();
        response.put("totalSaleAmount", totalSaleAmount);
        return response;
    }

    // Endpoint to get the day with the maximum sales within a time range
    @GetMapping("/maxSaleDay")
    public MaxSaleDayDTO getMaxSaleDayWithinTimeRange(
            @RequestParam("startDate") @DateTimeFormat(
                    pattern = "yyyy-MM-dd HH:mm:ss") Date startDate,
            @RequestParam("endDate") @DateTimeFormat(
                    pattern = "yyyy-MM-dd HH:mm:ss") Date endDate) {
        return orderRepository.getMaxSaleDayWithinTimeRange(startDate, endDate);
    }
}

