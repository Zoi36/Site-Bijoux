package com.admin.repository;

import org.springframework.data.repository.CrudRepository;

import com.admin.domain.OrderProduct;

public interface OrderProductRepository extends CrudRepository<OrderProduct, Long>{
	
	
}
