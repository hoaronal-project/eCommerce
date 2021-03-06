package com.cmc.model;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author hoaronal
 * Nov 10, 2021
 */
@Entity
@Table(name = "CART")
@DynamicUpdate
public class Cart implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column(name = "CART_ID")
	private Long cartId;

	@Column(name = "QUANTITY")
	private int quantity;

	@OneToMany(targetEntity = CartItem.class,cascade = CascadeType.ALL)
	@JoinColumn(name = "cart_Id",referencedColumnName ="cartId" )
	private List<CartItem> cartItems;

	@Column(name = "CART_TOTAL")
	private float cartTotal;

	public Cart() {

	}

	/**
	 * @return the cartId
	 */
	public Long getCartId() {
		return cartId;
	}

	/**
	 * @param cartId the cartId to set
	 */
	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the cartItems
	 */
	public List<CartItem> getCartItems() {
		return cartItems;
	}

	/**
	 * @param cartItems the cartItems to set
	 */
	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	/**
	 * @return the cartTotal
	 */
	public float getCartTotal() {
		return cartTotal;
	}

	/**
	 * @param cartTotal the cartTotal to set
	 */
	public void setCartTotal(float cartTotal) {
		this.cartTotal = cartTotal;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", quantity=" + quantity + ", cartItems=" + cartItems + ", cartTotal="
				+ cartTotal + "]";
	}

}