package com.example.toranj.Core.DomainService;

import com.example.toranj.Core.Events.IEvent;
import com.example.toranj.Core.DomainObjects.OutboxEvent;
import com.example.toranj.DataAccess.Write.OutboxEventRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class OutBoxDomainService {
    private final OutboxEventRepository _outboxEventRepository;
    public OutboxEvent createOutboxEvent(Long aggregateId, String eventType, IEvent event) {
        OutboxEvent outboxEvent = new OutboxEvent();
        outboxEvent.setAggregateId(aggregateId);
        outboxEvent.setEventType(eventType);
        outboxEvent.setPayload(event.toString());
        outboxEvent.setStatus("PENDING");
        outboxEvent.setCreatedAt(LocalDateTime.now());
        return outboxEvent ;
    }

    public OutboxEvent markEventAsProcessed(Long eventId) {
        OutboxEvent outboxEvent = _outboxEventRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Outbox event not found: " + eventId));
        outboxEvent.setStatus("PROCESSED");
        outboxEvent.setProcessedAt(LocalDateTime.now());
        return outboxEvent ;
    }

    public void SaveEvent(OutboxEvent event){
        _outboxEventRepository.save(event) ;
    }

}
