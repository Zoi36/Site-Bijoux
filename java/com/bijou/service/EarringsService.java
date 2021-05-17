package com.bijou.service;

import java.util.List;

import com.bijou.domain.Earrings;

public interface EarringsService {

	List<Earrings> findAll();

	Earrings findOne(Long id);

	Earrings save(Earrings earrings);

}
