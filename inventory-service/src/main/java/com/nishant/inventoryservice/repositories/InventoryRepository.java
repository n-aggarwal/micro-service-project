package com.nishant.inventoryservice.repositories;

import com.nishant.inventoryservice.domains.entites.InventoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface InventoryRepository extends JpaRepository<InventoryEntity, Long> {
    Optional<InventoryEntity> findBySkuCode(String skuCode);

    List<InventoryEntity> findBySkuCodeIn(List<String> skuCode);
}
