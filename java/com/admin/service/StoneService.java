package com.admin.service;

import java.util.List;

import com.admin.domain.Stone;

public interface StoneService {

	Stone save(Stone stone);

	Stone findOne(Long id);

	List<Stone> findAll();

}
