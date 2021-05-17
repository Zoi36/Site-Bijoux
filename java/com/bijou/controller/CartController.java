package com.bijou.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bijou.domain.Cart;
import com.bijou.domain.LineProduct;
import com.bijou.domain.Product;
import com.bijou.domain.User;
import com.bijou.service.CartService;
import com.bijou.service.LineProductService;
import com.bijou.service.ProductService;
import com.bijou.service.UserService;

@Controller
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private UserService userService;

	@Autowired
	private LineProductService lineProductService;

	@Autowired
	private ProductService productService;

	@Autowired
	private CartService cartService;

	@RequestMapping("/cartProduct")
	public String cart(Model model, Principal principal) {
		User user = userService.findByUsername(principal.getName());
		Cart cart = user.getCart();

		List<LineProduct> lineProductList = lineProductService.findByCart(cart);

		cartService.updateCart(cart);

		model.addAttribute("lineProductList", lineProductList);
		model.addAttribute("cart", cart);

		return "cart";
	}

	@RequestMapping("/addProduct")
	public String addProduct(@ModelAttribute("product") Product product, @ModelAttribute("qty") String qty,
			@ModelAttribute("size") String size, Model model, Principal principal) {

		User user = userService.findByUsername(principal.getName());

		product = productService.findOne(product.getId());
		if (product.getTitle() != null) {
			if (product.getStock() == 0) {
				model.addAttribute("notEnoughStock", true);

				return "forward:/productSelect?id=" + product.getId();
			}
			if (Integer.parseInt(qty) == 0) {
				model.addAttribute("notQuantity", true);

				return "forward:/productSelect?id=" + product.getId();
			}
		}

		LineProduct lineProduct = lineProductService.addProduct(product, user, Integer.parseInt(qty),
				Integer.parseInt(size));

		model.addAttribute("addProductSuccess", true);

		return "forward:/productSelect?id=" + product.getId();
	}

	@RequestMapping("/updateLineProduct")
	public String updateCart(@ModelAttribute("id") Long lineProductId, @ModelAttribute("qty") int qty,
			@ModelAttribute("size") int size) {
		LineProduct lineProduct = lineProductService.findById(lineProductId);
		lineProduct.setQty(qty);
		lineProduct.setQty(size);
		lineProductService.updateLineProduct(lineProduct);

		return "forward:/cart/cartProduct";
	}

	@RequestMapping("/removeProduct")
	public String removeProduct(@RequestParam("id") Long id) {
		lineProductService.removeLineProduct(lineProductService.findById(id));

		return "forward:/cart/cartProduct";
	}
}
