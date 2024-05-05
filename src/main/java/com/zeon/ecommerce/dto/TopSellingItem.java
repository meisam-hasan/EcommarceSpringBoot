package com.zeon.ecommerce.dto;

import com.zeon.ecommerce.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TopSellingItem {
    private Product product;
    private Double totalSaleAmount;
}
