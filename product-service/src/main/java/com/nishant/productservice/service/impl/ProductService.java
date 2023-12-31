package com.nishant.productservice.service.impl;

import com.nishant.productservice.domain.dto.ProductDto;
import com.nishant.productservice.domain.entity.ProductEntity;
import com.nishant.productservice.mappers.Mapper;
import com.nishant.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;


@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService implements com.nishant.productservice.service.ProductService {

    private final Mapper<ProductEntity, ProductDto> productMapper;
    private final ProductRepository productRepository;

     public void createProduct(ProductDto productDto) {

         ProductEntity productEntity = productMapper.mapFromDto(productDto);
         productRepository.save(productEntity);

         log.info("Product {} created successfully", productEntity.getId());
         return;
     }

     public Page<ProductDto> getProductsList(Pageable pageable) {
         Page<ProductEntity> productEntityPage =  productRepository.findAll(pageable);
         Page<ProductDto> productDtoPage = productEntityPage.map(productMapper::mapToDto);
         return productDtoPage;
     }
}
