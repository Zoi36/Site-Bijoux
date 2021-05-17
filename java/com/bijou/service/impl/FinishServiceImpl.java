package com.bijou.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bijou.domain.Finish;
import com.bijou.repository.FinishRepository;
import com.bijou.service.FinishService;

@Service
public class FinishServiceImpl implements FinishService {

	@Autowired
	private FinishRepository finishRepository;

	public Finish findByTypeFinish(String typeFinish) {

		return finishRepository.findByTypeFinish(typeFinish);

	}
}
