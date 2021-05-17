package com.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.domain.Product;
import com.admin.repository.ProductRepository;
import com.admin.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	public List<Product> findAll() {
		List<Product> productList = (List<Product>) productRepository.findAll();

		return productList;
	}

	public Product findOne(Long id) {
		return productRepository.findOne(id);
	}

}
