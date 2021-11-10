package com.cmc.service;

import com.cmc.client.ProductClient;
import com.cmc.dao.CartRepository;
import com.cmc.model.Cart;
import com.cmc.model.CartItem;
import com.cmc.model.Product;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author hoaronal
 * Nov 10, 2021
 */
@Service
@Transactional
public class CartServiceImpl implements CartService {

	private final ProductClient productClient;

	private final CartRepository cartRepository;

	public CartServiceImpl(ProductClient productClient, CartRepository cartRepository) {
		this.productClient = productClient;
		this.cartRepository = cartRepository;
	}

	@Override
	public List<Cart> getAllCart() {
		List<Cart> resultAllCartList = cartRepository.findAll();
		if (resultAllCartList.size() > 0) {
			return resultAllCartList;
		} else {
			return new ArrayList<>();
		}
	}

	@Override
	public Cart getCartById(Long cartId) throws Exception {
		Optional<Cart> resultCart = cartRepository.findById(cartId);
		System.out.println("resultCart:::::::::" + resultCart);
		if (resultCart.isPresent()) {
			return resultCart.get();
		} else {
			throw new Exception("No Cart record exist for given id" + cartId);
		}
	}

	@Override
	public Cart addItemToCart(Long productId, int quantity) throws Exception {
		Product product = productClient.getProductById(productId);
		System.out.println("product:...." + product);

		float total = 0f;

		List<CartItem> cartItems = new ArrayList<CartItem>();
		CartItem cartItem = new CartItem();
		cartItem.setCartItemName(product.getProductName());
		cartItem.setCartItemPrice(product.getProductPrice());
		cartItems.add(cartItem);

		System.out.println("cartItems::" + cartItems);

		for (CartItem item : cartItems) {
			total += item.getCartItemPrice();
			System.out.println("total::" + total);
		}

		Cart cart = new Cart();
		cart.setCartItems(cartItems);
		cart.setCartTotal(total);
		cart.setQuantity(quantity);
		
		Cart saveCart = cartRepository.save(cart);
		return saveCart;
	}

}
