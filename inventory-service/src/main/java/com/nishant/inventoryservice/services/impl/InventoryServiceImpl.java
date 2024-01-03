package com.nishant.inventoryservice.services.impl;

import com.nishant.inventoryservice.domains.dto.InventoryResponse;
import com.nishant.inventoryservice.domains.entites.InventoryEntity;
import com.nishant.inventoryservice.mappers.Mapper;
import com.nishant.inventoryservice.repositories.InventoryRepository;
import com.nishant.inventoryservice.services.InventoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepository inventoryRepository;
    private final Mapper<InventoryEntity, InventoryResponse> inventoryResponseMapper;

    @Override
    @Transactional(readOnly = true)
    public List<InventoryResponse> isInStock(List<String> skuCode) {

        return inventoryRepository.findBySkuCodeIn(skuCode)
                .stream()
                .map(inventoryResponseMapper::mapToDto)
                .toList();
    }
}
