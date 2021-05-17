package com.admin.service;

import java.util.List;

import com.admin.domain.Gold;

public interface GoldService {

	Gold save(Gold gold);

	Gold findOne(Long id);

	List<Gold> findAll();

}
