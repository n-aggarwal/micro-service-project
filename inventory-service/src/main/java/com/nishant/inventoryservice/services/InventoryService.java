package com.nishant.inventoryservice.services;

import com.nishant.inventoryservice.domains.dto.InventoryResponse;

import java.util.List;

public interface InventoryService {

    List<InventoryResponse> isInStock(List<String> skuCode);
}
