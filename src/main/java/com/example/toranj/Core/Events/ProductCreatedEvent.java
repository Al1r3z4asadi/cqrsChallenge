package com.example.toranj.Core.Events;

import lombok.Data;

import java.math.BigDecimal;

@Data

public class ProductCreatedEvent extends IEvent {
    private Long productId ;
    private String name ;
    private BigDecimal price ;
    private int count_available ;

    public ProductCreatedEvent(Long id, String name, BigDecimal price, int countAvailable) {
        this.count_available = countAvailable ;
        this.name = name ;
        this.productId = id ;
        this.price = price ;
    }
}
