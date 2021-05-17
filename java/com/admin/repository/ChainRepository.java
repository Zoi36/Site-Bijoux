package com.admin.repository;

import org.springframework.data.repository.CrudRepository;

import com.admin.domain.Chain;



public interface ChainRepository extends CrudRepository<Chain, Long>{
	
	Chain findByTypeChain(String typeChain);
}
