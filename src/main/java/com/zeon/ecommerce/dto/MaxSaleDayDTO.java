package com.zeon.ecommerce.dto;

import java.util.Date;

public class MaxSaleDayDTO {
    private Date date;
    private Double totalSaleAmount;

    public MaxSaleDayDTO(Date date, Double totalSaleAmount) {
        this.date = date;
        this.totalSaleAmount = totalSaleAmount;
    }

    // Getters and setters
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getTotalSaleAmount() {
        return totalSaleAmount;
    }

    public void setTotalSaleAmount(Double totalSaleAmount) {
        this.totalSaleAmount = totalSaleAmount;
    }
}

