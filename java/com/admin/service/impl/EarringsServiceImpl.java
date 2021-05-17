package com.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.repository.EarringsRepository;
import com.admin.service.EarringsService;
import com.admin.domain.Earrings;

@Service
public class EarringsServiceImpl implements EarringsService {

	@Autowired
	private EarringsRepository earringsRepository;

	public Earrings save(Earrings earringsReady) {
		return earringsRepository.save(earringsReady);
	}

	public List<Earrings> findAll() {
		return (List<Earrings>) earringsRepository.findAll();
	}

	public Earrings findOne(Long id) {
		return earringsRepository.findOne(id);
	}

	public void removeOne(Long id) {
		earringsRepository.delete(id);
	}
}
