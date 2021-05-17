package com.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.domain.Gold;
import com.admin.repository.GoldRepository;
import com.admin.service.GoldService;

@Service
public class GoldServiceImpl implements GoldService {

	@Autowired
	private GoldRepository goldRepository;

	public Gold save(Gold gold) {

		return goldRepository.save(gold);
	}

	public Gold findOne(Long id) {

		return goldRepository.findOne(id);
	}

	public List<Gold> findAll() {

		return (List<Gold>) goldRepository.findAll();
	}
}
