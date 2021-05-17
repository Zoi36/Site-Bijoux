package com.bijou.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.bijou.domain.Cart;
import com.bijou.domain.LineProduct;
import com.bijou.domain.OrderProduct;

@Transactional
public interface LineProductRepository extends CrudRepository<LineProduct, Long>{
	
	List<LineProduct> findByCart(Cart cart);
	
	List<LineProduct> findByOrderProduct(OrderProduct orderProduct);

}
