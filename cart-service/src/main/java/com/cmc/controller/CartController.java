package com.cmc.controller;

import com.cmc.model.Cart;
import com.cmc.service.CartService;
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
//http://localhost:8484/cart/cart-service/cart
@RestController
@RequestMapping("/cart-service")
public class CartController {

    private static final Logger log = LoggerFactory.getLogger(CartController.class);

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping(value = "/cart", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Cart>> getAllCartList() {
        log.info("Fetching All Cart list {}");
        List<Cart> resultcartList = cartService.getAllCart();
        if (resultcartList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(resultcartList, HttpStatus.OK);

    }

    @GetMapping(value = "/cart/{cartId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cart> getCartById(@PathVariable("cartId") Long cartId) throws Exception {
        log.info("Fetching Cart by cartId {}", cartId);
        Cart resultcart = cartService.getCartById(cartId);
        if (resultcart == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(resultcart, HttpStatus.OK);
    }

    @PostMapping(value = "/cart", params = {"productId", "quantity"},
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<Cart> addItemToCart(@RequestParam("productId") Long productId,
                                               @RequestParam("quantity") Integer quantity) throws Exception {
        log.info("add item into cart : {}");
        Cart resultCart = cartService.addItemToCart(productId, quantity);
        return new ResponseEntity<>(resultCart, HttpStatus.CREATED);
    }

}
