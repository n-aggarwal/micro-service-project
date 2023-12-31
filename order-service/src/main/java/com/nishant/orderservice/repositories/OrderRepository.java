package com.nishant.orderservice.repositories;

import com.nishant.orderservice.domains.entites.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, Long>,
        PagingAndSortingRepository<OrderEntity, Long> {
}
