package com.cmc.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author hoaronal
 * Nov 10, 2021
 */
@Entity
@Table(name = "CART_ITEM")
public class CartItem implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CARTITEM_ID"/* , unique = true */)
	private Long cartItemId;

	private String cartItemName;

	private float cartItemPrice;

	@ManyToOne

	@JoinColumn(name = "cart_Id")
	private Cart cart;

	public CartItem() {
	}

	/**
	 * @return the cartItemId
	 */
	public Long getCartItemId() {
		return cartItemId;
	}

	/**
	 * @param cartItemId the cartItemId to set
	 */
	public void setCartItemId(Long cartItemId) {
		this.cartItemId = cartItemId;
	}

	/**
	 * @return the cartItemName
	 */
	public String getCartItemName() {
		return cartItemName;
	}

	/**
	 * @param cartItemName the cartItemName to set
	 */
	public void setCartItemName(String cartItemName) {
		this.cartItemName = cartItemName;
	}

	/**
	 * @return the cartItemPrice
	 */
	public float getCartItemPrice() {
		return cartItemPrice;
	}

	/**
	 * @param cartItemPrice the cartItemPrice to set
	 */
	public void setCartItemPrice(float cartItemPrice) {
		this.cartItemPrice = cartItemPrice;
	}

	@Override
	public String toString() {
		return "CartItem [cartItemId=" + cartItemId + ", cartItemName=" + cartItemName + ", cartItemPrice="
				+ cartItemPrice + "]";
	}

}
