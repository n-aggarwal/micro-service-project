package com.nishant.orderservice.mappers.impl;

import com.nishant.orderservice.domains.dto.OrderLineItemsDto;
import com.nishant.orderservice.domains.dto.OrderRequest;
import com.nishant.orderservice.domains.entites.OrderLineItemsEntity;
import com.nishant.orderservice.mappers.Mapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderLineItemsMapper implements Mapper<OrderLineItemsEntity, OrderLineItemsDto> {

    private final ModelMapper modelMapper;
    @Override
    public OrderLineItemsDto mapToDto(OrderLineItemsEntity orderLineItemsEntity) {
        return modelMapper.map(orderLineItemsEntity, OrderLineItemsDto.class);
    }

    @Override
    public OrderLineItemsEntity mapFromDto(OrderLineItemsDto orderLineItemsDto) {
        return modelMapper.map(orderLineItemsDto, OrderLineItemsEntity.class);
    }

}
