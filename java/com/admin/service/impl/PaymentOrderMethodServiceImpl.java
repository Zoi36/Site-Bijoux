package com.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.admin.domain.PaymentOrderMethod;
import com.admin.repository.PaymentOrderMethodRepository;
import com.admin.service.PaymentOrderMethodService;

@Service
public class PaymentOrderMethodServiceImpl implements PaymentOrderMethodService {

	@Autowired
	private PaymentOrderMethodRepository paymentOrderMethodRepository;

	public List<PaymentOrderMethod> findAll() {
		return (List<PaymentOrderMethod>) paymentOrderMethodRepository.findAll();
	}

	public PaymentOrderMethod findOne(Long id) {
		return paymentOrderMethodRepository.findOne(id);
	}

	public PaymentOrderMethod save(PaymentOrderMethod paymentOrderMethod) {
		return paymentOrderMethodRepository.save(paymentOrderMethod);
	}

}
