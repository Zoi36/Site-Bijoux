package com.bijou.repository;


import org.springframework.data.repository.CrudRepository;

import com.bijou.domain.Necklace;



public interface NecklaceRepository extends CrudRepository<Necklace, Long>{
	
	Necklace findByGoldIdAndStoneIdAndChainId(Long goldId,Long stoneId,Long chainId);
	

	
}
