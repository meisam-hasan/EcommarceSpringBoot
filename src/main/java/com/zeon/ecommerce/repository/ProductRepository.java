package com.zeon.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.zeon.ecommerce.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
