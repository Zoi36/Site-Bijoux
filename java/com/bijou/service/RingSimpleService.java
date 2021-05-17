package com.bijou.service;

import java.util.List;

import com.bijou.domain.RingSimple;

public interface RingSimpleService {

	List<RingSimple> findAll();

	RingSimple findOne(Long id);

	RingSimple save(RingSimple ringSimple);

	RingSimple createRingSimple(String typeStone, String formStone, String haloStone, double weightStone,
			String nextStones, String colorGold, int qualityGold, String typeStones, double ringSimplePrice);

}
