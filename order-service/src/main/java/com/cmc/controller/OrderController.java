package com.cmc.controller;

import com.cmc.model.Order;
import com.cmc.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author hoaronal
 * Nov 10, 2021
 */
//http://localhost:8484/order/order-service/order
@RestController
@RequestMapping("/order-service")
public class OrderController {

	private static final Logger log = LoggerFactory.getLogger(OrderController.class);

	private final OrderService orderService;

	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}

	@GetMapping(value = "/order", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Order>> getAllOrderList() {
		log.info("Fetching All Oder list {}");
		List<Order> resultOrderList = orderService.getAllOrder();
		if (resultOrderList.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(resultOrderList, HttpStatus.OK);

	}

	@GetMapping(value = "/order/{orderId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Order> getCartById(@PathVariable("orderId") Long orderId) throws Exception {
		log.info("Fetching Order by orderId {}", orderId);
		Order resultorder = orderService.getOrderById(orderId);
		if (resultorder == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(resultorder, HttpStatus.OK);
	}

	@PostMapping(value = "/order", params = "cartId", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity<Order> saveOrder(@RequestParam("cartId") Long cartId) {
		log.info("save the order : {}");
		Order saveOrder = orderService.saveOrder(cartId);
		return new ResponseEntity<>(saveOrder, HttpStatus.CREATED);
	}
}
