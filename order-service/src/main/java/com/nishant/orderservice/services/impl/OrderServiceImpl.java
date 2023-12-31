package com.nishant.orderservice.services.impl;

import com.nishant.orderservice.domains.dto.OrderLineItemsDto;
import com.nishant.orderservice.domains.dto.OrderRequest;
import com.nishant.orderservice.domains.entites.OrderEntity;
import com.nishant.orderservice.domains.entites.OrderLineItemsEntity;
import com.nishant.orderservice.mappers.Mapper;
import com.nishant.orderservice.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderServiceImpl implements com.nishant.orderservice.services.OrderService {

    private final Mapper<OrderLineItemsEntity, OrderLineItemsDto> orderLineItemsMapper;
    private final OrderRepository orderRepository;

    @Override
    public void placeOrder(OrderRequest orderRequest) {

        OrderEntity order = new OrderEntity();
        order.setOrderNumber(UUID.randomUUID().toString());

        List<OrderLineItemsDto> orderRequestItemListDto = orderRequest.getOrderLineItemsDtoList();
        List<OrderLineItemsEntity> orderLineItemsEntityList = orderRequestItemListDto
                .stream()
                .map(orderLineItemsDto -> orderLineItemsMapper.mapFromDto(orderLineItemsDto))
                .toList();

        order.setOrderLineItemsEntityList(orderLineItemsEntityList);

        orderRepository.save(order);

    }
}
