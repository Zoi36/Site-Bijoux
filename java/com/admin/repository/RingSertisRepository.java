package com.admin.repository;

import org.springframework.data.repository.CrudRepository;

import com.admin.domain.RingSertis;


public interface RingSertisRepository extends CrudRepository<RingSertis, Long>{
 
	RingSertis findByTypeStones(String typeStones);
}
