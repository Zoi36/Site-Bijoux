package com.bijou.repository;


import org.springframework.data.repository.CrudRepository;

import com.bijou.domain.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
	
}
