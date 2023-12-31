package com.nishant.productservice.data;

import com.nishant.productservice.domain.dto.ProductDto;

import java.math.BigDecimal;

public class ProductData {

    private static ProductDto product (String name, String description, double price) {
        return ProductDto.builder()
                .name(name)
                .description(description)
                .price(BigDecimal.valueOf(price))
                .build();
    }

    public static ProductDto product1() {
        return product("Iphone 13", "IOS", 1200);
    }
}
