package com.cmc.dao;

import com.cmc.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author hoaronal
 * Nov 10, 2021
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
