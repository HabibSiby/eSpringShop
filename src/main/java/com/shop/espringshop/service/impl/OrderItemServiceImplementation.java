package com.shop.espringshop.service.impl;

import com.shop.espringshop.model.OrderItem;
import com.shop.espringshop.repository.OrderItemRepository;
import com.shop.espringshop.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderItemServiceImplementation implements OrderItemService {

    @Autowired
    private final OrderItemRepository orderItemRepository;

    public OrderItemServiceImplementation(final OrderItemRepository orderItemRepository){
        this.orderItemRepository = orderItemRepository;
    }
    @Override
    public OrderItem createOrderItem(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }
}
