package com.zeon.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.zeon.ecommerce.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
}
