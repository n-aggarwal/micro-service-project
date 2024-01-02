package com.nishant.orderservice.services.impl;

import com.nishant.orderservice.domains.dto.InventoryResponse;
import com.nishant.orderservice.domains.dto.OrderLineItemsDto;
import com.nishant.orderservice.domains.dto.OrderRequest;
import com.nishant.orderservice.domains.entites.OrderEntity;
import com.nishant.orderservice.domains.entites.OrderLineItemsEntity;
import com.nishant.orderservice.mappers.Mapper;
import com.nishant.orderservice.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static java.util.Arrays.stream;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderServiceImpl implements com.nishant.orderservice.services.OrderService {

    private final Mapper<OrderLineItemsEntity, OrderLineItemsDto> orderLineItemsMapper;
    private final OrderRepository orderRepository;
    private final WebClient webClient;

    @Override
    public void placeOrder(OrderRequest orderRequest) {

        OrderEntity order = new OrderEntity();
        order.setOrderNumber(UUID.randomUUID().toString());

        List<OrderLineItemsDto> orderRequestItemListDto = orderRequest.getOrderLineItemsDtoList();
        List<OrderLineItemsEntity> orderLineItemsEntityList = orderRequestItemListDto
                .stream()
                .map(orderLineItemsMapper::mapFromDto)
                .toList();

        order.setOrderLineItemsEntityList(orderLineItemsEntityList);

        List<String> skuCodesList = orderLineItemsEntityList
                .stream()
                .map(OrderLineItemsEntity::getSkuCode)
                .toList();

        /*
         * Call Inventory Service, and place order if product is in stock
         */
        InventoryResponse[] inventoryResponseArray;
        inventoryResponseArray = webClient.get()
                .uri("http://localhost:8083/api/inventory",
                        uriBuilder -> uriBuilder.queryParam(
                                "skuCode", skuCodesList).build()
                )
                .retrieve()
                .bodyToMono(InventoryResponse[].class)
                .block();

        if (inventoryResponseArray == null) {
            throw new IllegalArgumentException("The Entered Sku-codes are not valid.");
        }

        boolean allProductsInStock = Arrays
                                        .stream(inventoryResponseArray)
                                        .allMatch(InventoryResponse::isInStock);

        if (allProductsInStock) {
            orderRepository.save(order);
        }
        else {
            throw new IllegalArgumentException("Product is not in stock, " +
                    "please try again later");
        }



    }
}
