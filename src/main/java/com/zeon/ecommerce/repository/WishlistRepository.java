package com.zeon.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.zeon.ecommerce.entity.Wishlist;
import java.util.List;
import java.util.Optional;


public interface WishlistRepository extends JpaRepository<Wishlist, Long> {
    // Query to get wishlist items for a specific user
    @Query("SELECT w FROM Wishlist w WHERE w.user.id = :userId")
    Optional<List<Wishlist>> findByUserId(@Param("userId") Long userId);
}
