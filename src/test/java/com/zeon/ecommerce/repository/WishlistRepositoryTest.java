package com.zeon.ecommerce.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import com.zeon.ecommerce.TestContainerExtension;
import com.zeon.ecommerce.entity.Wishlist;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ExtendWith(TestContainerExtension.class)
public class WishlistRepositoryTest {

    @Autowired
    private WishlistRepository wishlistRepository;

    @Test
    public void testFindByUserId() {
        // Given
        // Assuming there are some wishlist items in the database for a specific user

        // When
        Long userId = 1L; // Set the user ID for whom you want to retrieve wishlist items
        Optional<List<Wishlist>> wishlistItems = wishlistRepository.findByUserId(userId);

        // Then
        assertThat(wishlistItems.isPresent()).isTrue();
        assertThat(wishlistItems.get().size()).isGreaterThan(0); // Ensure at least one wishlist item is
    }
}

