package com.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.repository.NecklaceRepository;
import com.admin.service.NecklaceService;
import com.admin.domain.Necklace;

@Service
public class NecklaceServiceImpl implements NecklaceService {

	@Autowired
	private NecklaceRepository necklaceRepository;

	public Necklace save(Necklace necklaceReady) {
		return necklaceRepository.save(necklaceReady);
	}

	public List<Necklace> findAll() {
		return (List<Necklace>) necklaceRepository.findAll();
	}

	public Necklace findOne(Long id) {
		return necklaceRepository.findOne(id);
	}

	public void removeOne(Long id) {
		necklaceRepository.delete(id);
	}
}
