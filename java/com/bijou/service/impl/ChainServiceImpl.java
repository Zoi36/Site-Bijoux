package com.bijou.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bijou.domain.Chain;
import com.bijou.repository.ChainRepository;
import com.bijou.service.ChainService;

@Service
public class ChainServiceImpl implements ChainService {

	@Autowired
	private ChainRepository chainRepository;

	public Chain findByTypeChain(String typeChain) {

		return chainRepository.findByTypeChain(typeChain);

	}
}
