package com.bijou.service;

import java.util.List;

import com.bijou.domain.Product;

public interface ProductService {

	List<Product> findAll();

	Product findOne(Long id);

}
