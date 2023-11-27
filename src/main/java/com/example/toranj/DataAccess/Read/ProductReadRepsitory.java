package com.example.toranj.DataAccess.Read;

import com.example.toranj.ReadDomain.ViewModels.Product.ProductView;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductReadRepsitory extends MongoRepository<ProductView , String> {
}
