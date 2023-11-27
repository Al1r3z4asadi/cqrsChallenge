package com.example.toranj.DataAccess.Write;

import com.example.toranj.Core.DomainObjects.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository  extends CrudRepository<Customer, Long> {
}
