package com.cmc.service;

import com.cmc.model.Product;

import java.util.List;

/**
 * @author hoaronal
 * Nov 10, 2021
 */
public interface ProductService {

	List<Product> getAllProducts();

	Product getProductById(Long productId) throws Exception;

	List<Product> getAllProductByProductCategory(String productCategory) throws Exception;

	List<Product> getAllProductsByProductName(String productName) throws Exception;

	Product addProduct(Product product);

	Product updateProduct(Long productId, Product product);

	void deleteAllProducts();

	void deleteProduct(Long productId) throws Exception;

}
