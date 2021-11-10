package com.cmc.dao;

import com.cmc.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author hoaronal
 * Nov 10, 2021
 */
@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

		Cart findByCartId(Long cartId);
}
