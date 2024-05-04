package com.zeon.ecommerce.controller.wishlist;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.zeon.ecommerce.entity.Wishlist;
import com.zeon.ecommerce.repository.WishlistRepository;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

@RestController
@RequestMapping("/wishlist")
public class WishlistController {

    final WishlistRepository wishlistRepository;

    @Autowired
    public WishlistController(WishlistRepository wishlistRepository) {
        this.wishlistRepository = wishlistRepository;
    }

    // Endpoint to get wishlist items for a specific user
    @GetMapping("/user/{userId}")
    public Optional<List<Wishlist>> getWishlistForUser(@PathVariable Long userId) {
        return wishlistRepository.findByUserId(userId);
    }
}
