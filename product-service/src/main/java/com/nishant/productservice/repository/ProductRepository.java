package com.nishant.productservice.repository;

import com.nishant.productservice.domain.entity.ProductEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductRepository extends MongoRepository<ProductEntity, String> {
}
