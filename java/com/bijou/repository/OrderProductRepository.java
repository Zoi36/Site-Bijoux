package com.bijou.repository;

import org.springframework.data.repository.CrudRepository;

import com.bijou.domain.OrderProduct;



public interface OrderProductRepository extends CrudRepository<OrderProduct, Long>{

	
}
