package com.example.toranj.ApplicationService;

import com.example.toranj.Core.Commands.CreateProductCommand;
import com.example.toranj.Core.Commands.Handlers.ICommandHandler;
import com.example.toranj.Core.DomainObjects.Product;
import com.example.toranj.Core.DomainService.OutBoxDomainService;
import com.example.toranj.Core.DomainService.ProductDomainService;
import com.example.toranj.Core.Utils.ServiceResult;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateProductCommandHandler implements ICommandHandler<CreateProductCommand> {

    private final ProductDomainService _productDomainService ;
    private final OutBoxDomainService _outboxDomainService ;
    @Override
    @Transactional
    public ServiceResult handle(CreateProductCommand command) {

        Product product = new Product(command.getName() , command.getPrice() , command.getCount_available());
        _productDomainService.validateProduct(product) ;
        var event = _productDomainService.saveProduct(product);
        var outEvent = _outboxDomainService.createOutboxEvent(event.getProductId() , "ProductCreated" ,
                    event) ;
        _outboxDomainService.SaveEvent(outEvent) ;
        return ServiceResult.success(event);
    }
}
