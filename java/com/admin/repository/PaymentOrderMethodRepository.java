package com.admin.repository;


import org.springframework.data.repository.CrudRepository;

import com.admin.domain.PaymentOrderMethod;

public interface PaymentOrderMethodRepository extends CrudRepository<PaymentOrderMethod, Long>{
	
	
}
