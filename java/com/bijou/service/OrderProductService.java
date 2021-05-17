package com.bijou.service;

import com.bijou.domain.AddressOrder;
import com.bijou.domain.Cart;
import com.bijou.domain.OrderProduct;
import com.bijou.domain.PaymentOrderMethod;
import com.bijou.domain.User;

public interface OrderProductService {
	OrderProduct createOrderProduct(Cart cart, AddressOrder addressOrder, PaymentOrderMethod paymentOrderMethod,
			String shippingMethod, User user);

	OrderProduct findOne(Long Id);

	OrderProduct findById(Long Id);

	OrderProduct setByUser(User user, OrderProduct orderProduct);

}
