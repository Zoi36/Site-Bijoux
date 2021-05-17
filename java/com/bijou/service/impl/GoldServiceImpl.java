package com.bijou.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bijou.domain.Gold;
import com.bijou.repository.GoldRepository;
import com.bijou.service.GoldService;

@Service
public class GoldServiceImpl implements GoldService {

	@Autowired
	private GoldRepository goldRepository;

	public Gold findByQualityGold(int qualityGold) {

		return goldRepository.findByQualityGold(qualityGold);

	}
}
