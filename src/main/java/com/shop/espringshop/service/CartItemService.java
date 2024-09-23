package com.shop.espringshop.service;

import com.shop.espringshop.exception.CartItemException;
import com.shop.espringshop.exception.UserException;
import com.shop.espringshop.model.Cart;
import com.shop.espringshop.model.CartItem;
import com.shop.espringshop.model.Product;

public interface CartItemService {
    public CartItem createCartItem(CartItem cartItem);
    public CartItem updateCartItem(Long userId, Long id, CartItem cartItem) throws CartItemException, UserException;
    public CartItem isCartItemExist(Cart cart, Product product, String size, Long userId);

    public void  removeCartItem(Long userId, Long cartItemId) throws CartItemException, UserException;

    public CartItem findCartItemById(Long cartItemId) throws CartItemException;

}
