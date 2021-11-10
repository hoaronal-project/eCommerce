package com.cmc.service;

import com.cmc.model.Cart;

import java.util.List;

/**
 * @author hoaronal
 * Nov 10, 2021
 */
public interface CartService {

    List<Cart> getAllCart();

    Cart getCartById(Long cartId) throws Exception;

    Cart addItemToCart(Long productId, int quantity) throws Exception;

}
