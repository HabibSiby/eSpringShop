package com.shop.espringshop.service;

import com.shop.espringshop.exception.ProductException;
import com.shop.espringshop.model.Cart;
import com.shop.espringshop.model.User;
import com.shop.espringshop.request.AddItemRequest;

public interface CartService {

    public Cart createCart(User user);
    public String addCartItem(Long userId, AddItemRequest req) throws ProductException;

    public Cart findUserCart(Long userId);

}
