package com.nishant.inventoryservice;

import com.nishant.inventoryservice.domains.entites.InventoryEntity;
import com.nishant.inventoryservice.repositories.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner loadData(InventoryRepository inventoryRepository) {
//		return args -> {
//			InventoryEntity inventoryEntity = new InventoryEntity();
//			inventoryEntity.setSkuCode("iphone_13");
//			inventoryEntity.setQuantity(100);
//
//			InventoryEntity inventoryEntity2 = new InventoryEntity();
//			inventoryEntity.setSkuCode("iphone_15");
//			inventoryEntity.setQuantity(1);
//
//			inventoryRepository.save(inventoryEntity);
//			inventoryRepository.save(inventoryEntity2);
//		};
//	}

}
