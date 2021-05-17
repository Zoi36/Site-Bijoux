package com.bijou.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bijou.domain.Earrings;
import com.bijou.repository.EarringsRepository;
import com.bijou.service.EarringsService;

@Service
public class EarringsServiceImpl implements EarringsService {

	@Autowired
	private EarringsRepository earringsRepository;

	public List<Earrings> findAll() {
		List<Earrings> ringSimpleReadyList = (List<Earrings>) earringsRepository.findAll();

		return ringSimpleReadyList;
	}

	public Earrings findOne(Long id) {
		return earringsRepository.findOne(id);
	}

	public Earrings save(Earrings earrings) {
		return earringsRepository.save(earrings);
	}

}
