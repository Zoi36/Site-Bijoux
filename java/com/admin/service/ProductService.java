package com.admin.service;

import java.util.List;

import com.admin.domain.Product;

public interface ProductService {

	List<Product> findAll();

	Product findOne(Long id);

}
