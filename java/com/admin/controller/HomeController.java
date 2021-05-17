package com.admin.controller;

import java.security.Principal;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.admin.domain.OrderProduct;
import com.admin.domain.PaymentOrderMethod;
import com.admin.domain.Product;
import com.admin.service.LineProductService;
import com.admin.service.OrderProductService;
import com.admin.service.PaymentOrderMethodService;
import com.admin.service.ProductService;
import com.admin.domain.LineProduct;

@Controller
public class HomeController {

	@Autowired
	private OrderProductService orderProductService;

	@Autowired
	private ProductService productService;

	@Autowired
	private PaymentOrderMethodService paymentOrderMethodService;

	@Autowired
	private LineProductService lineProductService;

	@RequestMapping("/")
	public String index() {
		return "redirect:/home";
	}

	@RequestMapping("/home")
	public String home() {
		return "home";
	}

	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	@RequestMapping("/orders")
	public String orders(Model model) {

		List<PaymentOrderMethod> paymentOrderMethodList = paymentOrderMethodService.findAll();
		List<OrderProduct> orderProductList = orderProductService.findAll();

		model.addAttribute("paymentOrderMethodList", paymentOrderMethodList);
		model.addAttribute("orderProductList", orderProductList);

		return "orders";
	}

	@RequestMapping("/orderProductDetail")
	public String orderProductDetail(@RequestParam("id") Long orderProductId, Principal principal, Model model) {

		OrderProduct orderProduct = orderProductService.findOne(orderProductId);

		List<LineProduct> lineProductList = lineProductService.findByOrderProduct(orderProduct);
		model.addAttribute("lineProductList", lineProductList);
		model.addAttribute("orderProduct", orderProduct);
		model.addAttribute("displayOrderProductDetail", true);

		return "orders";
	}

	@RequestMapping("/updateOrderStatus{id}")
	public String updateOrderStatus(@RequestParam("id") Long id, Model model) {

		OrderProduct orderProduct = orderProductService.findOne(id);
		orderProduct.setOrderStatus("Expédiée");
		orderProductService.save(orderProduct);
		model.addAttribute("orderProduct", orderProduct);
		return "redirect:/orders";
	}

	@RequestMapping("/personnaliseInfo")
	public String personnaliseInfo(@RequestParam("id") Long id, Model model) {
		Product product = productService.findOne(id);
		model.addAttribute("product", product);

		return "personnaliseInfo";
	}

}
