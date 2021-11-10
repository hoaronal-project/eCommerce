package com.cmc.service;

import com.cmc.model.Order;

import java.util.List;

/**
 * @author hoaronal
 * Nov 10, 2021
 */
public interface OrderService {

	List<Order> getAllOrder();

	Order getOrderById(Long orderId) throws Exception;

	Order saveOrder(Long cartId);

}
