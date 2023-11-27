package com.example.toranj.Core.DomainService;

import com.example.toranj.Core.DomainObjects.Customer;
import com.example.toranj.Core.Events.CustomerCreatedEvent;
import com.example.toranj.DataAccess.Write.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerDomainService {
    private final CustomerRepository _customerRepository ;


    public CustomerCreatedEvent saveCustomer(Customer customer) {
        _customerRepository.save(customer) ;
        return new CustomerCreatedEvent(customer.getId() , customer.getPhoneNumber() , customer.getCreatedDate() );
    }
}
