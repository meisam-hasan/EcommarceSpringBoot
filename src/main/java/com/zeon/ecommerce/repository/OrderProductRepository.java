package com.zeon.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.zeon.ecommerce.entity.OrderProduct;

public interface OrderProductRepository extends JpaRepository<OrderProduct,Long>{

}
