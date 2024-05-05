package com.zeon.ecommerce.dto;

import com.zeon.ecommerce.entity.Product;


public interface TopCountSellingItem {
    Product getProduct();
    Long getSalesCount();
} 
