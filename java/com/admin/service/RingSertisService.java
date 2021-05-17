package com.admin.service;

import java.util.List;

import com.admin.domain.RingSertis;

public interface RingSertisService {

	RingSertis save(RingSertis ringSertis);

	RingSertis findOne(Long id);

	List<RingSertis> findAll();

}
