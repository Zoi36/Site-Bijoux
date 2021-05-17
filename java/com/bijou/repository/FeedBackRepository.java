package com.bijou.repository;


import org.springframework.data.repository.CrudRepository;

import com.bijou.domain.FeedBack;
import com.bijou.domain.Product;


public interface FeedBackRepository extends CrudRepository<FeedBack, Long>{
	
	FeedBack findByProduct(Product product);
}

