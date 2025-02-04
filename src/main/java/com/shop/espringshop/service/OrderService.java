package com.shop.espringshop.service;

import com.shop.espringshop.exception.OrderException;
import com.shop.espringshop.model.Address;
import com.shop.espringshop.model.Order;
import com.shop.espringshop.model.User;

import java.util.List;

public interface OrderService {
    public Order createOrder(User user, Address shippingAddress);
    public Order findOrderById(Long orderId) throws OrderException;
    public List<Order> usersOrderHistory(Long userId) throws OrderException;
    public Order placeOrder(Long orderId) throws OrderException;
    public Order confirmedOrder(Long orderId) throws OrderException;
    public Order shippedOrder(Long orderId) throws OrderException;
    public Order deliveredOrder(Long orderId) throws OrderException;
    public Order canceledOrder(Long orderId) throws OrderException;
    public List<Order>getAllOrders();
    public void deleteOrder(Long orderId) throws OrderException;
}
