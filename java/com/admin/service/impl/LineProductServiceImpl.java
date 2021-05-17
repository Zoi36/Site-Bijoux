package com.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.domain.Cart;
import com.admin.domain.LineProduct;
import com.admin.domain.OrderProduct;
import com.admin.repository.LineProductRepository;
import com.admin.service.LineProductService;

@Service
public class LineProductServiceImpl implements LineProductService {

	@Autowired
	private LineProductRepository lineProductRepository;

	public List<LineProduct> findByCart(Cart cart) {
		return lineProductRepository.findByCart(cart);
	}

	public LineProduct findById(Long id) {
		return lineProductRepository.findOne(id);
	}

	public LineProduct save(LineProduct lineProduct) {
		return lineProductRepository.save(lineProduct);
	}

	public List<LineProduct> findByOrderProduct(OrderProduct orderProduct) {
		return lineProductRepository.findByOrderProduct(orderProduct);
	}

}
