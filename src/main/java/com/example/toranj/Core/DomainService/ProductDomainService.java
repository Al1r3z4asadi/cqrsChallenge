package com.example.toranj.Core.DomainService;

import com.example.toranj.Core.DomainObjects.Product;
import com.example.toranj.Core.Events.IEvent;
import com.example.toranj.Core.Events.ProductCreatedEvent;
import com.example.toranj.Core.Exceptions.ErrorCodes.ErrorCodes;
import com.example.toranj.Core.Exceptions.ProductException;
import com.example.toranj.DataAccess.Write.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductDomainService {
    private final ProductRepository _productRepository ;

    public boolean validateProduct(Product product){
        if(product.getCount_available() < 1){
            throw new ProductException( ErrorCodes.INVALID_COUNT.getMessage() , ErrorCodes.INVALID_COUNT.getCode() ) ;
        }
        return true ;
    }

    public ProductCreatedEvent saveProduct(Product product) {
        _productRepository.save(product) ;
        return new ProductCreatedEvent(product.getId(), product.getName() ,
                            product.getPrice() , product.getCount_available() );
    }
}
