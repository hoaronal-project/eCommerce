package com.cmc.client;

import com.cmc.model.Cart;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author hoaronal
 * Nov 10, 2021
 */
@FeignClient(name = "cart-service", url = "http://localhost:8282/")
public interface CartClient {

	@GetMapping(value = "cart-service/cart/{cartId}")
	Cart getAllItemsFromCart(@PathVariable(value = "cartId") Long cartId);
}
