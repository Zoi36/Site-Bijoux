package com.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.domain.Stone;
import com.admin.repository.StoneRepository;
import com.admin.service.StoneService;

@Service
public class StoneServiceImpl implements StoneService {

	@Autowired
	private StoneRepository stoneRepository;

	public Stone save(Stone stone) {

		return stoneRepository.save(stone);
	}

	public Stone findOne(Long id) {

		return stoneRepository.findOne(id);
	}

	public List<Stone> findAll() {

		return (List<Stone>) stoneRepository.findAll();
	}

}
