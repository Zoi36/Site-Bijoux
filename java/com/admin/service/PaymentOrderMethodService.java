package com.admin.service;

import java.util.List;

import com.admin.domain.PaymentOrderMethod;

public interface PaymentOrderMethodService {

	List<PaymentOrderMethod> findAll();

	PaymentOrderMethod findOne(Long id);

	PaymentOrderMethod save(PaymentOrderMethod paymentOrderMethod);

}
