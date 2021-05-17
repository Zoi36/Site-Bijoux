package com.bijou.service;

import com.bijou.domain.Stone;

public interface StoneService {

	Stone findByTypeStoneAndHaloStoneAndWeightStoneAndNextStones(String typeStone, String haloStone, double weightStone,
			String nextStones);

}
