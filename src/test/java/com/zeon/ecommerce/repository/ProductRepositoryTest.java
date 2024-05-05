package com.zeon.ecommerce.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import com.zeon.ecommerce.TestContainerExtension;
import com.zeon.ecommerce.dto.TopCountSellingItem;
import com.zeon.ecommerce.dto.TopSellingItem;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ExtendWith(TestContainerExtension.class)
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository repository;

    @Test
    public void testFindTop5SellingItems() {
        List<TopSellingItem> topSellingItems = repository.findTop5SellingItems();

        assertThat(topSellingItems.size()).isGreaterThan(0);
    }
    
    @Test
    public void testTop5SellingItemsLastMonth() {
        List<TopCountSellingItem> topCountSellingItems = repository.findTop5SellingItemsLastMonth();
        topCountSellingItems.forEach(top->{
            System.out.println(top.getName()+ " "+top.getSalesCount());
        });
        assertThat(topCountSellingItems.size()).isGreaterThan(0);
    }

}
