package com.cmc.client;

import com.cmc.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author hoaronal
 * Nov 10, 2021
 */
//http://localhost:8181/product-service/products
@FeignClient(name = "product-service", url = "http://localhost:8181/")
public interface ProductClient {

	@GetMapping(value = "product-service/products/{productId}")
	Product getProductById(@PathVariable(value = "productId") Long productId);

}