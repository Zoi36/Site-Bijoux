package com.admin.service;

import java.util.List;

import com.admin.domain.RingSimple;

public interface RingSimpleService {

	RingSimple save(RingSimple ringSimpleReady);

	List<RingSimple> findAll();

	RingSimple findOne(Long id);

	void removeOne(Long id);
}
