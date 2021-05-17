package com.bijou.repository;

import org.springframework.data.repository.CrudRepository;

import com.bijou.domain.security.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {
	
	Role findByname(String name);
}
