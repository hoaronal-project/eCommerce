package com.cmc.service;

import com.cmc.client.CartClient;
import com.cmc.dao.OrderRepository;
import com.cmc.model.Cart;
import com.cmc.model.Order;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author hoaronal
 * Nov 10, 2021
 */
@Service
public class OrderServiceImpl implements OrderService {

	private final CartClient cartClient;

	private final OrderRepository orderRepository;

	public OrderServiceImpl(CartClient cartClient, OrderRepository orderRepository) {
		this.cartClient = cartClient;
		this.orderRepository = orderRepository;
	}

	@Override
	public List<Order> getAllOrder() {
		List<Order> resultAllOrderList = orderRepository.findAll();
		if (resultAllOrderList.size() > 0) {
			return resultAllOrderList;
		} else {
			return new ArrayList<>();
		}
	}


	@Override
	public Order getOrderById(Long orderId) throws Exception {
		Optional<Order> resultOrder = orderRepository.findById(orderId);
		System.out.println("resultOrder:::::::::" + resultOrder);
		if (resultOrder.isPresent()) {
			return resultOrder.get();
		} else {
			throw new Exception("No Cart record exist for given id" + orderId);
		}
	}


	@Override
	public Order saveOrder(Long cartId) {
		Cart allItemsFromCart = cartClient.getAllItemsFromCart(cartId);
		System.out.println("allItemsFromCart:::" + allItemsFromCart);

		Order order = new Order();
		order.setOrderedDate(LocalDate.now());
		order.setStatus("PAYMENT_EXPECTED");
		order.setTotal(allItemsFromCart.getCartTotal());

		System.out.println("order::::" + order);

		return orderRepository.save(order);

	}


}
