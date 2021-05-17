package com.admin.service;

import java.util.List;

import com.admin.domain.Earrings;

public interface EarringsService {

	Earrings save(Earrings earringsReady);

	List<Earrings> findAll();

	Earrings findOne(Long id);

	void removeOne(Long id);
}
