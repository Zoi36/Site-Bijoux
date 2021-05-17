package com.bijou.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bijou.domain.RingSertis;
import com.bijou.repository.RingSertisRepository;
import com.bijou.service.RingSertisService;

@Service
public class RingSertisServiceImpl implements RingSertisService {

	@Autowired
	private RingSertisRepository ringSertisRepository;

	public RingSertis findByTypeStones(String typeStones) {

		return ringSertisRepository.findByTypeStones(typeStones);

	}
}
