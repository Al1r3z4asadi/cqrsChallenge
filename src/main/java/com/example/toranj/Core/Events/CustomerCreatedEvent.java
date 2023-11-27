package com.example.toranj.Core.Events;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CustomerCreatedEvent extends IEvent {
    private Long customerId ;
    private String phoneNumber ;
    private LocalDateTime createdAt;

    public CustomerCreatedEvent(Long id, String phoneNumber , LocalDateTime createdAt) {
        this.phoneNumber = phoneNumber ;
        this.customerId = id ;
        this.createdAt = createdAt ;
    }
}
