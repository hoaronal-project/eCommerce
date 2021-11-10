package com.cmc.dao;

import com.cmc.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author hoaronal
 * Nov 10, 2021
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	Product findByProductId(Long productId);

	List<Product> findAllByProductCategory(String productCategory);

	List<Product> findAllByProductName(String productName);
}
