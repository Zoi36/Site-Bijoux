package com.bijou.repository;



import org.springframework.data.repository.CrudRepository;

import com.bijou.domain.Stone;

public interface StoneRepository extends CrudRepository<Stone, Long> {

	Stone findByTypeStoneAndHaloStoneAndWeightStoneAndNextStones(String typeStone,String haloStone,double weightStone,String nextStones);
	
	


}
