package com.bijou.controller;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.bijou.domain.AddressOrder;
import com.bijou.domain.Cart;
import com.bijou.domain.LineProduct;
import com.bijou.domain.OrderProduct;
import com.bijou.domain.PaymentOrderMethod;
import com.bijou.domain.User;
import com.bijou.service.AddressOrderService;
import com.bijou.service.CartService;
import com.bijou.service.LineProductService;
import com.bijou.service.OrderProductService;
import com.bijou.service.UserService;
import com.bijou.utility.MailOrderConstructor;

@Controller
public class PaymentController {

	private AddressOrder addressOrder = new AddressOrder();
	private PaymentOrderMethod paymentOrderMethod = new PaymentOrderMethod();

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private MailOrderConstructor mailOrderConstructor;

	@Autowired
	private UserService userService;

	@Autowired
	private LineProductService lineProductService;

	@Autowired
	private CartService cartService;

	@Autowired
	private AddressOrderService addressOrderService;

	@Autowired
	private OrderProductService orderProductService;

	@RequestMapping("/payment")
	public String payment(@RequestParam("id") Long cartProductId, Model model, Principal principal) {
		User user = userService.findByUsername(principal.getName());

		model.addAttribute("user", user);
		model.addAttribute("orderProductList", user.getOrderProductList());

		List<LineProduct> lineProductList = lineProductService.findByCart(user.getCart());

		if (lineProductList.size() == 0) {
			model.addAttribute("emptyCartProduct", true);

			return "forward:/cart/cartProduct";
		}

		model.addAttribute("addressOrder", addressOrder);
		model.addAttribute("paymentOrderMethod", paymentOrderMethod);
		model.addAttribute("lineProductList", lineProductList);
		model.addAttribute("cart", user.getCart());

		model.addAttribute("classActiveShipping", true);

		return "payment";

	}

	@RequestMapping(value = "/payment", method = RequestMethod.POST)
	public String paymentPost(@ModelAttribute("addressOrder") AddressOrder addressOrder,
			@ModelAttribute("paymentOrderMethod") PaymentOrderMethod paymentOrderMethod,
			@ModelAttribute("shippingMethod") String shippingMethod, Principal principal, Model model) {
		
		Cart cart = userService.findByUsername(principal.getName()).getCart();

		List<LineProduct> lineProductList = lineProductService.findByCart(cart);
		model.addAttribute("lineProductList", lineProductList);
		
		User user = userService.findByUsername(principal.getName());
		
		OrderProduct orderProduct = orderProductService.createOrderProduct(cart, addressOrder, paymentOrderMethod,
				shippingMethod, user);
		
		if(shippingMethod.equals("livraison rapide")) {
			
			BigDecimal shippingPrice = new BigDecimal(15);
			orderProduct.setOrderTotal(orderProduct.getOrderTotal().add(shippingPrice));
		}
		
		mailSender.send(mailOrderConstructor.constructOrderConfirmationMail(user, orderProduct, Locale.ENGLISH));

		cartService.clearCart(cart);
		
		return "orderProductSubmitted";
	}

	@RequestMapping("/setAddressOrder")
	public String setAddressOrder(@RequestParam("addressOrderId") Long addressOrderId, Principal principal,
			Model model) {
		User user = userService.findByUsername(principal.getName());
		AddressOrder addressOrder = addressOrderService.findById(addressOrderId);

		addressOrderService.setByUser(user, addressOrder);

		List<LineProduct> lineProductList = lineProductService.findByCart(user.getCart());

		model.addAttribute("addressOrder", addressOrder);
		model.addAttribute("paymentOrderMethod", paymentOrderMethod);
		model.addAttribute("lineProductList", lineProductList);
		model.addAttribute("cart", user.getCart());

		List<OrderProduct> orderProductList = user.getOrderProductList();

		model.addAttribute("orderProductList ", orderProductList);

		model.addAttribute("addressOrder", addressOrder);

		model.addAttribute("classActiveShipping", true);
		

		return "payment";
	}

}
