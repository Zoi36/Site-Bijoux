package com.bijou.repository;

import org.springframework.data.repository.CrudRepository;

import com.bijou.domain.Chain;


public interface ChainRepository extends CrudRepository<Chain, Long>{
 
	Chain findByTypeChain(String typeChain);
}
