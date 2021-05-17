package com.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.domain.Chain;
import com.admin.repository.ChainRepository;
import com.admin.service.ChainService;

@Service
public class ChainServiceImpl implements ChainService {

	@Autowired
	private ChainRepository chainRepository;

	public Chain save(Chain chain) {

		return chainRepository.save(chain);
	}

	public Chain findOne(Long id) {

		return chainRepository.findOne(id);
	}

	public List<Chain> findAll() {

		return (List<Chain>) chainRepository.findAll();
	}

}
