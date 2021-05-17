package com.admin.service;

import java.util.List;

import com.admin.domain.OrderProduct;

public interface OrderProductService {

	List<OrderProduct> findAll();

	OrderProduct findOne(Long Id);

	OrderProduct save(OrderProduct orderProduct);

}
