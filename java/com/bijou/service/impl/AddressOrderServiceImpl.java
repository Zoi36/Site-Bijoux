package com.bijou.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bijou.domain.AddressOrder;
import com.bijou.domain.User;
import com.bijou.repository.AddressOrderRepository;
import com.bijou.service.AddressOrderService;

@Service
public class AddressOrderServiceImpl implements AddressOrderService {

	@Autowired
	private AddressOrderRepository addressOrderRepository;

	public AddressOrder setByUser(User user, AddressOrder addressOrder) {

		addressOrder.setAddressStreet(addressOrder.getAddressStreet());
		addressOrder.setAddressName(addressOrder.getAddressName());
		addressOrder.setAddressCity(addressOrder.getAddressCity());
		addressOrder.setAddressZipcode(addressOrder.getAddressZipcode());
		return addressOrder;

	}

	public AddressOrder findById(Long id) {

		return addressOrderRepository.findOne(id);

	}
	public AddressOrder findByAddressStreet(String addressStreet) {

		return addressOrderRepository.findByAddressStreet(addressStreet);

	}
}
