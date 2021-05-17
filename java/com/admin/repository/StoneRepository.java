package com.admin.repository;

import org.springframework.data.repository.CrudRepository;

import com.admin.domain.Stone;

public interface StoneRepository extends CrudRepository<Stone, Long> {

	Stone findByFormStoneAndHaloStoneAndTypeStoneAndWeightStoneAndNextStones(String formStone,String typeStone, String haloStone,
			 double weightStone,String nextStones);

	Stone findByFormStoneAndHaloStoneAndTypeStone(String formStone,String typeStone, String haloStone);
}
