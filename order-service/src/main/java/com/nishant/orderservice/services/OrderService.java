package com.nishant.orderservice.services;

import com.nishant.orderservice.domains.dto.OrderRequest;

public interface OrderService {

    void placeOrder (OrderRequest orderRequest);
}
