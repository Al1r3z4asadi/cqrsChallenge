package com.example.toranj.DataAccess.Write;

import com.example.toranj.Core.DomainObjects.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
}
