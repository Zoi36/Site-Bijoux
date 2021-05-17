package com.bijou.repository;


import org.springframework.data.repository.CrudRepository;

import com.bijou.domain.Gold;

public interface GoldRepository extends CrudRepository<Gold, Long>{
	
       Gold findByQualityGold(int qualityGold);
}
