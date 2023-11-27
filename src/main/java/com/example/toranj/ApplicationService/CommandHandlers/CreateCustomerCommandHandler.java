package com.example.toranj.ApplicationService.CommandHandlers;

import com.example.toranj.Core.Commands.CreateCustomerCommand;
import com.example.toranj.Core.Commands.Handlers.ICommandHandler;
import com.example.toranj.Core.DomainObjects.Customer;
import com.example.toranj.Core.DomainService.CustomerDomainService;
import com.example.toranj.Core.DomainService.OutBoxDomainService;
import com.example.toranj.Core.Utils.ServiceResult;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateCustomerCommandHandler implements ICommandHandler<CreateCustomerCommand> {
    private final CustomerDomainService _customerDomainService ;
    private final OutBoxDomainService _outboxDomainService ;

    @Override
    public ServiceResult handle(CreateCustomerCommand command) {
        Customer customer = new Customer(command.getPhoneNumber());
        var event =  _customerDomainService.saveCustomer(customer) ;
        var outEvent = _outboxDomainService.createOutboxEvent(event.getCustomerId() , "CustomerCreated" ,
                event) ;
        _outboxDomainService.SaveEvent(outEvent) ;
        return ServiceResult.success(event);
    }
}
