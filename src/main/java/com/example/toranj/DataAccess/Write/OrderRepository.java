package com.example.toranj.DataAccess.Write;

import com.example.toranj.Core.DomainObjects.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository  extends CrudRepository<Order, Long> {
}
