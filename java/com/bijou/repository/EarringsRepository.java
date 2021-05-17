package com.bijou.repository;


import org.springframework.data.repository.CrudRepository;

import com.bijou.domain.Earrings;



public interface EarringsRepository extends CrudRepository<Earrings, Long>{
	
	Earrings findByGoldIdAndStoneId(Long goldId,Long stoneId);
	

	
}
