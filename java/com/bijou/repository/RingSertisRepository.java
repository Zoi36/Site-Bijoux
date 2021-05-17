package com.bijou.repository;


import org.springframework.data.repository.CrudRepository;

import com.bijou.domain.RingSertis;


public interface RingSertisRepository extends CrudRepository<RingSertis, Long>{
 
	RingSertis findByTypeStones(String typeStones);
}
