package com.zeon.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.zeon.ecommerce.entity.Order;

public interface OrderRepository extends JpaRepository<Order,Long>{

}
