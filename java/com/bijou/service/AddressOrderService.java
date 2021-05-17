package com.bijou.service;

import com.bijou.domain.AddressOrder;
import com.bijou.domain.User;

public interface AddressOrderService {

	AddressOrder findById(Long id);
	
	AddressOrder findByAddressStreet(String addressStreet);


	AddressOrder setByUser(User user, AddressOrder addressOrder);
}
