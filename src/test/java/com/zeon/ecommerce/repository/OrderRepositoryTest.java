package com.zeon.ecommerce.repository;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import com.zeon.ecommerce.TestContainerExtension;
import com.zeon.ecommerce.dto.MaxSaleDayDTO;
import com.zeon.ecommerce.util.DateUtil;
import java.text.ParseException;
import java.util.Date;
import java.sql.Timestamp;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ExtendWith(TestContainerExtension.class)
public class OrderRepositoryTest {

    @Autowired
    private OrderRepository orderRepository;

    @Test
    public void testGetTotalSaleAmountForCurrentDay() {
        Double todaySaleAmount = orderRepository.getTotalSaleAmountForCurrentDay();

        // assertThat(todaySaleAmount).isGreaterThan(0);
        assertThat(todaySaleAmount).isGreaterThan(0.0);
    }


    @Test
    public void testGetMaxSaleDayWithinTimeRange() throws ParseException {
        // Given
        Date startDate = DateUtil.covertDate("2024-04-15 00:00:00"); // Set your start date
        Date endDate = DateUtil.covertDate("2024-04-15 23:59:59"); // Set your end date
        Timestamp expectedStartDate = new Timestamp(startDate.getTime());
        Timestamp expectedEndDate = new Timestamp(endDate.getTime());

        // When
        MaxSaleDayDTO maxSaleDayDTO =
                orderRepository.getMaxSaleDayWithinTimeRange(expectedStartDate, expectedEndDate);
        Timestamp actualDate = new Timestamp(maxSaleDayDTO.getDate().getTime());

        // Then
        assertThat(actualDate).isBetween(expectedStartDate, expectedEndDate); // Replace expectedDate
                                                                           // with your expected
                                                                           // value
        assertThat(maxSaleDayDTO.getTotalSaleAmount()).isGreaterThan(0.0); // Replace
                                                                           // expectedTotalSaleAmount
                                                                           // with your expected
                                                                           // value
    }
}
