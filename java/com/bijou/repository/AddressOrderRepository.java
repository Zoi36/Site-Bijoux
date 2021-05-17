package com.bijou.repository;

import org.springframework.data.repository.CrudRepository;

import com.bijou.domain.AddressOrder;


public interface AddressOrderRepository extends CrudRepository<AddressOrder, Long> {
	
	AddressOrder findByAddressStreet(String addressStreet);

}
