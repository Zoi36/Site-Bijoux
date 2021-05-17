package com.bijou.service;

import java.util.List;

import com.bijou.domain.Necklace;

public interface NecklaceService {

	List<Necklace> findAll();

	Necklace findOne(Long id);

	Necklace save(Necklace necklace);

}
