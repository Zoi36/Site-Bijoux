package com.bijou.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bijou.domain.AddressOrder;
import com.bijou.domain.Alliance;
import com.bijou.domain.Earrings;
import com.bijou.domain.LineProduct;
import com.bijou.domain.Necklace;
import com.bijou.domain.OrderProduct;
import com.bijou.domain.Product;
import com.bijou.domain.RingSimple;
import com.bijou.domain.User;
import com.bijou.service.AllianceService;
import com.bijou.service.EarringsService;
import com.bijou.service.LineProductService;
import com.bijou.service.NecklaceService;
import com.bijou.service.OrderProductService;
import com.bijou.service.ProductService;
import com.bijou.service.RingSimpleService;
import com.bijou.service.UserService;

@Controller
public class ReadyController {

	@Autowired
	private RingSimpleService ringSimpleService;

	@Autowired
	private AllianceService allianceService;

	@Autowired
	private EarringsService earringsService;

	@Autowired
	private NecklaceService necklaceService;

	@Autowired
	private OrderProductService orderProductService;

	@Autowired
	private ProductService productService;

	@Autowired
	private LineProductService lineProductService;

	@Autowired
	private UserService userService;

	@RequestMapping("/ringSimpleReadyPresentation")
	public String ringSimpleReadyPresentation(Model model, Principal principal) {
		if (principal != null) {
			String username = principal.getName();
			User user = userService.findByUsername(username);
			model.addAttribute("user", user);
		}

		List<RingSimple> ringSimpleReadyList = ringSimpleService.findAll();

		model.addAttribute("ringSimpleReadyList", ringSimpleReadyList);

		return "/productReady/ringSimpleReadyPresentation";
	}

	@RequestMapping("/allianceReadyPresentation")
	public String allianceReadyPresentation(Model model, Principal principal) {
		if (principal != null) {
			String username = principal.getName();
			User user = userService.findByUsername(username);
			model.addAttribute("user", user);
		}
		List<Alliance> allianceReadyList = allianceService.findAll();

		model.addAttribute("allianceReadyList", allianceReadyList);

		return "/productReady/allianceReadyPresentation";
	}

	@RequestMapping("/earringsReadyPresentation")
	public String earringsReadyPresentation(Model model, Principal principal) {
		if (principal != null) {
			String username = principal.getName();
			User user = userService.findByUsername(username);
			model.addAttribute("user", user);
		}
		List<Earrings> earringsReadyList = earringsService.findAll();

		model.addAttribute("earringsReadyList", earringsReadyList);

		return "/productReady/earringsReadyPresentation";
	}

	@RequestMapping("/necklaceReadyPresentation")
	public String necklaceReadyPresentation(Model model, Principal principal) {
		if (principal != null) {
			String username = principal.getName();
			User user = userService.findByUsername(username);
			model.addAttribute("user", user);
		}
		List<Necklace> necklaceReadyList = necklaceService.findAll();

		model.addAttribute("necklaceReadyList", necklaceReadyList);

		return "/productReady/necklaceReadyPresentation";
	}

	@RequestMapping("/productSelect")
	public String ProductSelect(@PathParam("id") Long id, Model model, Principal principal) {
		if (principal != null) {
			String username = principal.getName();
			User user = userService.findByUsername(username);
			model.addAttribute("user", user);
		}

		Product product = productService.findOne(id);
		if (product.getTitle() != null) {
			ArrayList<Integer> qtyList = new ArrayList<Integer>();
			for (int i = 0; i <= product.getStock(); i++) {
				qtyList.add(i);
				model.addAttribute("qtyList", qtyList);
			}
		}
		if (product.getTitle() == null) {
			List<Integer> qtyList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
			model.addAttribute("qtyList", qtyList);

		}
		List<Integer> sizeList = Arrays.asList(46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63,
				64, 65, 66, 67, 68, 69);

		model.addAttribute("product", product);
		
		model.addAttribute("sizeList", sizeList);

		return "productSelect";
	}

	@RequestMapping("/orderProductDetail")
	public String orderProductDetail(@RequestParam("id") Long orderProductId, Principal principal, Model model) {
		User user = userService.findByUsername(principal.getName());
		OrderProduct orderProduct = orderProductService.findOne(orderProductId);

		if (orderProduct.getUser().getId() != user.getId()) {
			return "badRequestPage";
		} else {
			List<LineProduct> lineProductList = lineProductService.findByOrderProduct(orderProduct);
			model.addAttribute("lineProductList", lineProductList);
			model.addAttribute("user", user);
			model.addAttribute("orderProduct", orderProduct);
			model.addAttribute("orderProductList", user.getOrderProductList());

			AddressOrder addressOrder = new AddressOrder();
			model.addAttribute("addressOrder", addressOrder);

			model.addAttribute("classActiveOrderProduct", true);

			model.addAttribute("displayOrderProductDetail", true);

			return "myProfile";
		}
	}

}
