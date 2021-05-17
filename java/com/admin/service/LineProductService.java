package com.admin.service;

import java.util.List;

import com.admin.domain.Cart;
import com.admin.domain.LineProduct;
import com.admin.domain.OrderProduct;

public interface LineProductService {

	List<LineProduct> findByCart(Cart cart);

	LineProduct findById(Long Id);

	LineProduct save(LineProduct lineProduct);

	List<LineProduct> findByOrderProduct(OrderProduct orderProduct);
}
