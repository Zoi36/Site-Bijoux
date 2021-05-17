package com.bijou.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bijou.domain.Stone;
import com.bijou.repository.StoneRepository;
import com.bijou.service.StoneService;

@Service
public class StoneServiceImpl implements StoneService {

	@Autowired
	private StoneRepository stoneRepository;

	public Stone findByTypeStoneAndHaloStoneAndWeightStoneAndNextStones(String typeStone, String haloStone,
			double weightStone, String nextStones) {

		return stoneRepository.findByTypeStoneAndHaloStoneAndWeightStoneAndNextStones(typeStone, haloStone, weightStone,
				nextStones);
	}

}
