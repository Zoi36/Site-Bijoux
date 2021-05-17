package com.admin.repository;


import org.springframework.data.repository.CrudRepository;

import com.admin.domain.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
	
}
