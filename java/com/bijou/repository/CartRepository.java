package com.bijou.repository;

import org.springframework.data.repository.CrudRepository;

import com.bijou.domain.Cart;

public interface CartRepository extends CrudRepository<Cart, Long> {

}
