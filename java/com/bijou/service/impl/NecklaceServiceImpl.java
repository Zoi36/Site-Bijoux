package com.bijou.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bijou.domain.Necklace;
import com.bijou.repository.NecklaceRepository;
import com.bijou.service.NecklaceService;

@Service
public class NecklaceServiceImpl implements NecklaceService {

	@Autowired
	private NecklaceRepository necklaceRepository;

	public List<Necklace> findAll() {
		List<Necklace> necklaceReadyList = (List<Necklace>) necklaceRepository.findAll();

		return necklaceReadyList;
	}

	public Necklace findOne(Long id) {
		return necklaceRepository.findOne(id);
	}

	public Necklace save(Necklace necklace) {
		return necklaceRepository.save(necklace);
	}

}
