package com.bijou.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bijou.domain.Gold;
import com.bijou.domain.RingSertis;
import com.bijou.domain.RingSimple;
import com.bijou.domain.Stone;
import com.bijou.repository.RingSimpleRepository;
import com.bijou.service.RingSimpleService;

@Service
public class RingSimpleServiceImpl implements RingSimpleService {

	@Autowired
	private RingSimpleRepository ringSimpleRepository;

	public List<RingSimple> findAll() {
		List<RingSimple> ringSimpleReadyList = (List<RingSimple>) ringSimpleRepository.findAll();

		return ringSimpleReadyList;
	}

	public RingSimple findOne(Long id) {
		return ringSimpleRepository.findOne(id);
	}

	public RingSimple save(RingSimple ringSimple) {
		return ringSimpleRepository.save(ringSimple);
	}

	public synchronized RingSimple createRingSimple(String typeStone, String formStone, String haloStone,
			double weightStone, String nextStones, String colorGold, int qualityGold, String typeStones,
			double ringSimplePrice) {

		Stone stone = new Stone();
		RingSimple ringSimple = new RingSimple();
		RingSertis ringSertis = new RingSertis();
		Gold gold = new Gold();

		gold.setColorGold(colorGold);
		gold.setQualityGold(qualityGold);
		ringSimple.setGold(gold);
		stone.setTypeStone(typeStone);
		stone.setFormStone(formStone);
		stone.setHaloStone(haloStone);
		stone.setWeightStone(weightStone);
		stone.setNextStones(nextStones);
		ringSimple.setStone(stone);
		ringSertis.setTypeStones(typeStones);
		ringSimple.setRingSertis(ringSertis);
		ringSimple.setPrice(ringSimplePrice);

		ringSimple = ringSimpleRepository.save(ringSimple);

		return ringSimple;
	}

}
