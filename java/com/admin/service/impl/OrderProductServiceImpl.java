package com.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.domain.OrderProduct;
import com.admin.repository.OrderProductRepository;
import com.admin.service.OrderProductService;

@Service
public class OrderProductServiceImpl implements OrderProductService {

	@Autowired
	private OrderProductRepository orderProductRepository;

	public List<OrderProduct> findAll() {
		return (List<OrderProduct>) orderProductRepository.findAll();
	}

	public OrderProduct findOne(Long Id) {
		return orderProductRepository.findOne(Id);
	}

	public OrderProduct save(OrderProduct orderProduct) {
		return orderProductRepository.save(orderProduct);
	}

}
