package com.admin.service;

import java.util.List;

import com.admin.domain.Chain;

public interface ChainService {

	Chain save(Chain chain);

	Chain findOne(Long id);

	List<Chain> findAll();

}
