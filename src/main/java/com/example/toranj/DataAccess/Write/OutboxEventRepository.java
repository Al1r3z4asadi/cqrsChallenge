package com.example.toranj.DataAccess.Write;

import com.example.toranj.Core.DomainObjects.OutboxEvent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OutboxEventRepository extends CrudRepository<OutboxEvent, Long> {
}
