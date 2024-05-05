package com.zeon.ecommerce.controller.wishlist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.zeon.ecommerce.dto.TopCountSellingItem;
import com.zeon.ecommerce.dto.TopSellingItem;
import com.zeon.ecommerce.repository.ProductRepository;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // Endpoint to get the top 5 selling items of all time
    @GetMapping("/top5SellingItems")
    public List<TopSellingItem> getTop5SellingItems() {
        return productRepository.findTop5SellingItems();
    }

    // Endpoint to get the top 5 selling items of the last month
    @GetMapping("/top5SellingItemsLastMonth")
    public List<TopCountSellingItem> getTop5SellingItemsLastMonth() {
        return productRepository.findTop5SellingItemsLastMonth();
    }
}
