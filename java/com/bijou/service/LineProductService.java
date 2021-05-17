package com.bijou.service;

import java.util.List;

import com.bijou.domain.Cart;
import com.bijou.domain.LineProduct;
import com.bijou.domain.OrderProduct;
import com.bijou.domain.Product;
import com.bijou.domain.User;

public interface LineProductService {

	List<LineProduct> findByCart(Cart cart);

	LineProduct updateLineProduct(LineProduct lineProduct);

	LineProduct addProduct(Product product, User user, int qty, int size);

	LineProduct findById(Long Id);

	void removeLineProduct(LineProduct lineProduct);

	LineProduct save(LineProduct lineProduct);

	List<LineProduct> findByOrderProduct(OrderProduct orderProduct);
}
