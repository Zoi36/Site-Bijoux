package com.bijou.service;

import com.bijou.domain.Cart;

public interface CartService {

	Cart updateCart(Cart cart);

	void clearCart(Cart cart);
}
