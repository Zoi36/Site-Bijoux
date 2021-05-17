package com.bijou.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bijou.domain.Cart;
import com.bijou.domain.LineProduct;
import com.bijou.domain.OrderProduct;
import com.bijou.domain.Product;
import com.bijou.domain.User;
import com.bijou.repository.LineProductRepository;
import com.bijou.service.LineProductService;

@Service
public class LineProductServiceImpl implements LineProductService {

	@Autowired
	private LineProductRepository lineProductRepository;

	public List<LineProduct> findByCart(Cart cart) {
		return lineProductRepository.findByCart(cart);
	}

	public LineProduct updateLineProduct(LineProduct lineProduct) {

		BigDecimal bigDecimal = new BigDecimal(lineProduct.getProduct().getPrice())
				.multiply(new BigDecimal(lineProduct.getQty()));

		bigDecimal = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
		lineProduct.setSubtotal(bigDecimal);

		lineProductRepository.save(lineProduct);

		return lineProduct;
	}

	public LineProduct findById(Long id) {
		return lineProductRepository.findOne(id);
	}

	public LineProduct addProduct(Product product, User user, int qty, int size) {

		List<LineProduct> lineProductList = findByCart(user.getCart());

		for (LineProduct lineProduct : lineProductList) {

			if (product.getId() == lineProduct.getProduct().getId() && (lineProduct.getSize() == size)) {

				lineProduct.setQty(lineProduct.getQty() + qty);
				lineProduct.setSize(size);
				lineProduct.setSubtotal(new BigDecimal(product.getPrice()).multiply(new BigDecimal(qty)));
				lineProductRepository.save(lineProduct);

				return lineProduct;
			}
		}

		LineProduct lineProduct = new LineProduct();
		lineProduct.setCart(user.getCart());
		lineProduct.setProduct(product);
		lineProduct.setQty(qty);
		lineProduct.setSize(size);
		lineProduct.setSubtotal(new BigDecimal(product.getPrice()).multiply(new BigDecimal(qty)));
		lineProduct = lineProductRepository.save(lineProduct);

		return lineProduct;
	}

	public LineProduct save(LineProduct lineProduct) {
		return lineProductRepository.save(lineProduct);
	}

	public void removeLineProduct(LineProduct lineProduct) {

		lineProductRepository.delete(lineProduct);
	}

	public List<LineProduct> findByOrderProduct(OrderProduct orderProduct) {
		return lineProductRepository.findByOrderProduct(orderProduct);
	}

}
