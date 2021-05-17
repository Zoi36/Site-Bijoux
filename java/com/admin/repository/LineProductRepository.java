package com.admin.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.admin.domain.Cart;
import com.admin.domain.LineProduct;
import com.admin.domain.OrderProduct;

@Transactional
public interface LineProductRepository extends CrudRepository<LineProduct, Long>{
	
	List<LineProduct> findByCart(Cart cart);
	
	List<LineProduct> findByOrderProduct(OrderProduct orderProduct);

}
