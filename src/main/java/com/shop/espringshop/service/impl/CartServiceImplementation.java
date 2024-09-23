package com.shop.espringshop.service.impl;

import com.shop.espringshop.exception.ProductException;
import com.shop.espringshop.model.Cart;
import com.shop.espringshop.model.CartItem;
import com.shop.espringshop.model.Product;
import com.shop.espringshop.model.User;
import com.shop.espringshop.repository.CartRepository;
import com.shop.espringshop.request.AddItemRequest;
import com.shop.espringshop.service.CartItemService;
import com.shop.espringshop.service.CartService;
import com.shop.espringshop.service.ProductService;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImplementation implements CartService {

    private final CartRepository cartRepository;
    private final CartItemService cartItemService;
    private final ProductService productService;

    public CartServiceImplementation(final CartRepository cartRepository,
                                     final CartItemService cartItemService,
                                     final ProductService productService) {
        this.cartRepository = cartRepository;
        this.cartItemService =cartItemService;
        this.productService = productService;
    }
    @Override
    public Cart createCart(User user) {

        Cart cart = new Cart();
        cart.setUser(user);

        return cartRepository.save(cart);
    }

    @Override
    public String addCartItem(Long userId, AddItemRequest req) throws ProductException {

        Cart cart = cartRepository.findByUserId(userId);
        Product product = productService.findProductById(req.getProductId());

        CartItem isPresent= cartItemService.isCartItemExist(cart,product,req.getSize(),userId);

        if(isPresent == null){
            CartItem cartItem = new CartItem();
            cartItem.setProduct(product);
            cartItem.setCart(cart);
            cartItem.setUserId(userId);
            cartItem.setQuantity(req.getQuantity());

            int price = req.getQuantity()*product.getDiscountedPrice();
            cartItem.setPrice(price);
            cartItem.setSize(req.getSize());

            CartItem createdCartItem = cartItemService.createCartItem(cartItem);
            cart.getCartItems().add(createdCartItem);
        }

        return "Item add to Cart";
    }

    @Override
    public Cart findUserCart(Long userId) {

        Cart cart = cartRepository.findByUserId(userId);
        int totalPrice = 0;
        int totalDiscountedPrice = 0;
        int totalItem = 0;

        for(CartItem cartItem: cart.getCartItems()) {
            totalPrice = totalPrice + cartItem.getPrice();
            totalDiscountedPrice = totalDiscountedPrice + cartItem.getDiscountedPrice();
            totalItem = totalItem + cartItem.getQuantity();
        }

        cart.setTotalPrice(totalPrice);
        cart.setTotalDiscountedPrice(totalDiscountedPrice);
        cart.setTotalItem(totalItem);
        cart.setDiscount(totalPrice - totalDiscountedPrice);

        return cartRepository.save(cart);
    }
}
