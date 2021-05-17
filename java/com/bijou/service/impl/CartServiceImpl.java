package com.bijou.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bijou.domain.Cart;
import com.bijou.domain.LineProduct;
import com.bijou.repository.CartRepository;
import com.bijou.service.CartService;
import com.bijou.service.LineProductService;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private LineProductService lineProductService;

	@Autowired
	private CartRepository cartRepository;

	public Cart updateCart(Cart cart) {
		BigDecimal cartTotal = new BigDecimal(0);

		List<LineProduct> lineProductList = lineProductService.findByCart(cart);

		for (LineProduct lineProduct : lineProductList) {
			if (lineProduct.getProduct().getStock() > 0)

				lineProductService.updateLineProduct(lineProduct);
			cartTotal = cartTotal.add(lineProduct.getSubtotal());

		}

		cart.setGrandTotal(cartTotal);

		cartRepository.save(cart);

		return cart;
	}

	public void clearCart(Cart cart) {
		List<LineProduct> lineProductList = lineProductService.findByCart(cart);

		for (LineProduct lineProduct : lineProductList) {
			lineProduct.setCart(null);
			lineProductService.save(lineProduct);
		}

		cart.setGrandTotal(new BigDecimal(0));

		cartRepository.save(cart);
	}

}
