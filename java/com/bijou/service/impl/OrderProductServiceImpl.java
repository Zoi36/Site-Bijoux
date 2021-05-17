package com.bijou.service.impl;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bijou.domain.AddressOrder;
import com.bijou.domain.Cart;
import com.bijou.domain.LineProduct;
import com.bijou.domain.OrderProduct;
import com.bijou.domain.PaymentOrderMethod;
import com.bijou.domain.Product;
import com.bijou.domain.User;
import com.bijou.repository.OrderProductRepository;
import com.bijou.service.LineProductService;
import com.bijou.service.OrderProductService;

@Service
public class OrderProductServiceImpl implements OrderProductService {

	@Autowired
	private OrderProductRepository orderProductRepository;

	@Autowired
	private LineProductService lineProductService;

	public synchronized OrderProduct createOrderProduct(Cart cart, AddressOrder addressOrder,
			PaymentOrderMethod paymentOrderMethod, String shippingMethod, User user) {

		OrderProduct orderProduct = new OrderProduct();
		orderProduct.setOrderStatus("en cours");
		orderProduct.setPaymentOrderMethod(paymentOrderMethod);
		orderProduct.setAddressOrder(addressOrder);
		orderProduct.setShippingMethod(shippingMethod);

		List<LineProduct> lineProductList = lineProductService.findByCart(cart);

		for (LineProduct lineProduct : lineProductList) {
			Product product = lineProduct.getProduct();
			lineProduct.setOrderProduct(orderProduct);
			product.setStock(product.getStock() - lineProduct.getQty());

		}

		orderProduct.setLineProductList(lineProductList);
		orderProduct.setOrderDate(Calendar.getInstance().getTime());
		orderProduct.setOrderTotal(cart.getGrandTotal());
		orderProduct.setUser(user);
		orderProduct = orderProductRepository.save(orderProduct);

		return orderProduct;
	}

	public OrderProduct findById(Long Id) {
		return orderProductRepository.findOne(Id);
	}

	public OrderProduct findOne(Long Id) {
		return orderProductRepository.findOne(Id);
	}

	public OrderProduct setByUser(User user, OrderProduct orderProduct) {

		orderProduct.setUser(user);
		orderProduct.setAddressOrder(orderProduct.getAddressOrder());

		return orderProduct;
	}

}
