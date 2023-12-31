package com.nishant.productservice.service;

import com.nishant.productservice.domain.dto.ProductDto;
import com.nishant.productservice.domain.entity.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ProductService {

    void createProduct(ProductDto productDto);

    Page<ProductDto> getProductsList(Pageable pageable);

}
