package com.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.domain.RingSertis;
import com.admin.repository.RingSertisRepository;
import com.admin.service.RingSertisService;

@Service
public class RingSertisServiceImpl implements RingSertisService {

	@Autowired
	private RingSertisRepository ringSertisRepository;

	public RingSertis save(RingSertis gold) {

		return ringSertisRepository.save(gold);
	}

	public RingSertis findOne(Long id) {

		return ringSertisRepository.findOne(id);
	}

	public List<RingSertis> findAll() {

		return (List<RingSertis>) ringSertisRepository.findAll();
	}
}
