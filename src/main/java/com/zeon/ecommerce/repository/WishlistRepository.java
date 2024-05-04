package com.zeon.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.zeon.ecommerce.entity.Wishlist;

public interface WishlistRepository extends JpaRepository<Wishlist,Long>{

}
