package com.example.toranj.Core.DomainObjects;


import com.example.toranj.Core.Events.IEvent;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Data
@Entity
@Table(name = "outbox_event")
public class OutboxEvent extends IEvent {
    @Id
    @SequenceGenerator(
            name = "outbox_event_sequence",
            sequenceName = "outbox_event_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "outbox_event_sequence"
    )
    @Column(
            name = "id"
    )
    private Long id;

    @Column(name = "aggregate_id", nullable = false)
    private Long aggregateId;

    @Column(name = "event_type", nullable = false)
    private String eventType;

    @Column(name = "payload", columnDefinition = "jsonb", nullable = false)
    private String payload;

    @Column(name = "status", nullable = false, columnDefinition = "VARCHAR(50) DEFAULT 'PENDING'")
    private String status;

    @Column(name = "created_at", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;

    @Column(name = "processed_at")
    private LocalDateTime processedAt;

    @Column(name = "retry_count", nullable = false, columnDefinition = "INT DEFAULT 0")
    private int retryCount;
}
