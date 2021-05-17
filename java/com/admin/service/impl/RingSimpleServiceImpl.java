package com.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.domain.RingSimple;
import com.admin.repository.RingSimpleRepository;
import com.admin.service.RingSimpleService;

@Service
public class RingSimpleServiceImpl implements RingSimpleService {

	@Autowired
	private RingSimpleRepository ringSimpleRepository;

	public RingSimple save(RingSimple ringSimpleReady) {
		return ringSimpleRepository.save(ringSimpleReady);
	}

	public List<RingSimple> findAll() {
		return (List<RingSimple>) ringSimpleRepository.findAll();
	}

	public RingSimple findOne(Long id) {
		return ringSimpleRepository.findOne(id);
	}

	public void removeOne(Long id) {
		ringSimpleRepository.delete(id);
	}

}
