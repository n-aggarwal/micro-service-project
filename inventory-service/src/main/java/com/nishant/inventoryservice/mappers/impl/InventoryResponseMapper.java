package com.nishant.inventoryservice.mappers.impl;

import com.nishant.inventoryservice.domains.dto.InventoryResponse;
import com.nishant.inventoryservice.domains.entites.InventoryEntity;
import com.nishant.inventoryservice.mappers.Mapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InventoryResponseMapper implements Mapper<InventoryEntity, InventoryResponse> {

    private final ModelMapper modelMapper;

    @Override
    public InventoryResponse mapToDto(InventoryEntity inventoryEntity) {
        return InventoryResponse.builder()
                .skuCode(inventoryEntity.getSkuCode())
                .isInStock(inventoryEntity.getQuantity() > 0)
                .build();
    }

    @Override
    public InventoryEntity mapFromDto(InventoryResponse inventoryResponse) {
        return modelMapper.map(inventoryResponse, InventoryEntity.class);
    }
}
