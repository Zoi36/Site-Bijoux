package com.bijou.repository;

import org.springframework.data.repository.CrudRepository;

import com.bijou.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {
	User findByUsername(String username);
	
	User findByEmail(String email);
}
