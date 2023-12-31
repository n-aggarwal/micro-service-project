package com.nishant.productservice.mappers.impl;

import com.nishant.productservice.domain.dto.ProductDto;
import com.nishant.productservice.domain.entity.ProductEntity;
import com.nishant.productservice.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper implements Mapper<ProductEntity, ProductDto> {

        private ModelMapper modelMapper;

        public ProductMapper(ModelMapper modelMapper) {
            this.modelMapper = modelMapper;
        }

        public ProductDto mapToDto(ProductEntity productEntity) {
            return modelMapper.map(productEntity, ProductDto.class);
        }

        public ProductEntity mapFromDto(ProductDto productDto) {
            return modelMapper.map(productDto, ProductEntity.class);
        }
}
