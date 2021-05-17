package com.bijou.controller;

import java.security.Principal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bijou.domain.AddressOrder;
import com.bijou.domain.FeedBack;
import com.bijou.domain.Product;
import com.bijou.domain.User;
import com.bijou.domain.security.PasswordResetToken;
import com.bijou.domain.security.Role;
import com.bijou.domain.security.UserRole;
import com.bijou.service.FeedBackService;
import com.bijou.service.ProductService;
import com.bijou.service.UserService;
import com.bijou.service.impl.UserSecurityService;
import com.bijou.utility.MailOrderConstructor;
import com.bijou.utility.SecurityUtility;

@Controller
public class HomeController {

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private MailOrderConstructor mailOrderConstructor;

	@Autowired
	private UserService userService;

	@Autowired
	private UserSecurityService userSecurityService;

	@Autowired
	private ProductService productService;

	@Autowired
	private FeedBackService feedBackService;

	@RequestMapping("/")
	public String productPresentation(Model model, Principal principal) {
		if (principal != null) {
			String username = principal.getName();
			User user = userService.findByUsername(username);
			model.addAttribute("user", user);
		}

		List<Product> productList = productService.findAll();
		List<FeedBack> feedBackList = feedBackService.findAll();

		model.addAttribute("feedBackList", feedBackList);
		model.addAttribute("productList", productList);
		model.addAttribute("activeAll", true);

		return "index";
	}

	@RequestMapping("/login")
	public String login(Model model) {
		model.addAttribute("classActiveLogin", true);
		return "myAccount";
	}

	@RequestMapping("/creations")
	public String creations(Model model) {
		model.addAttribute("classActiveCreations", true);
		return "creations";
	}

	@RequestMapping("/forgetPassword")
	public String forgetPassword(HttpServletRequest request, @ModelAttribute("email") String email, Model model) {

		model.addAttribute("classActiveForgetPassword", true);

		User user = userService.findByEmail(email);

		if (user == null) {
			model.addAttribute("emailNotExist", true);
			return "myAccount";
		}

		String password = SecurityUtility.randomPassword();

		String encryptedPassword = SecurityUtility.passwordEncoder().encode(password);
		user.setPassword(encryptedPassword);

		userService.save(user);

		String token = UUID.randomUUID().toString();
		userService.createPasswordResetTokenForUser(user, token);

		String appUrl = "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();

		SimpleMailMessage newEmail = mailOrderConstructor.constructForgetPasswordEmail(appUrl, request.getLocale(),
				token, user, password);

		mailSender.send(newEmail);

		model.addAttribute("forgetPasswordEmailSent", "true");

		return "myAccount";
	}

	@RequestMapping("/myProfile")
	public String myProfile(Model model, Principal principal) {

		User user = userService.findByUsername(principal.getName());
		model.addAttribute("user", user);
		model.addAttribute("orderProductList", user.getOrderProductList());

		AddressOrder addressOrder = new AddressOrder();

		model.addAttribute("addressOrder", addressOrder);
		model.addAttribute("classActiveEdit", true);

		return "myProfile";
	}

	@RequestMapping("/addFeedBack")
	public String addFeedBack(Model model, Principal principal) {

		User user = userService.findByUsername(principal.getName());
		List<Integer> ratingList = Arrays.asList(1, 2, 3, 4, 5);

		model.addAttribute("user", user);
		model.addAttribute("ratingList", ratingList);

		return "addFeedBack";

	}

	@RequestMapping(value = "/addFeedBack", method = RequestMethod.POST)
	public String feedBackPost(@ModelAttribute("textFeedBack") String textFeedBack,
			@ModelAttribute("rating") int rating, Principal principal, Model model) {

		User user = userService.findByUsername(principal.getName());

		FeedBack feedBack = feedBackService.createFeedBack(user, textFeedBack, rating);

		model.addAttribute("feedBack", feedBack);

		return "feedBackSubmitted";
	}

	@RequestMapping("/feedBackList")
	public String ringSimpleReadyList(Model model) {
		List<FeedBack> feedBackList = feedBackService.findAll();
		model.addAttribute("feedBackList", feedBackList);

		return "/index";

	}

	@RequestMapping(value = "/newUser", method = RequestMethod.POST)
	public String newUserPost(HttpServletRequest request, @ModelAttribute("email") String userEmail,
			@ModelAttribute("username") String username, Model model) throws Exception {
		
		model.addAttribute("classActiveNewAccount", true);
		model.addAttribute("email", userEmail);
		model.addAttribute("username", username);

		String regex = "^(.+)@(.+)$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(userEmail);

		if (!matcher.matches()) {

			String error = "Veuillez donner un email correct! ";
			model.addAttribute("error", error);
			model.addAttribute("classActiveNewAccount", true);

			return "myAccount";
		}
		String regex1 = "^[a-zA-Z0-9]([._-](?![._-])|[a-zA-Z0-9]){3,18}[a-zA-Z0-9]$";
		Pattern pattern1 = Pattern.compile(regex1);
		Matcher matcher1 = pattern1.matcher(username);

		if (!matcher1.matches()) {

			String error1 = "Veuillez donner un nom d'utilisateur correct! "
					+ "Le nom d'utilisateur est composé de caractères alphanumériques (a-zA-Z0-9), minuscules ou majuscules.";
			model.addAttribute("error1", error1);
			model.addAttribute("classActiveNewAccount", true);

			return "myAccount";
		}

		if (userService.findByUsername(username) != null) {
			
			model.addAttribute("classActiveNewAccount", true);
			model.addAttribute("usernameExists", true);
			return "myAccount";
		}

		if (userService.findByEmail(userEmail) != null) {
			model.addAttribute("emailExists", true);

			return "myAccount";
		}

		User user = new User();
		user.setUsername(username);
		user.setEmail(userEmail);

		String password = SecurityUtility.randomPassword();

		String encryptedPassword = SecurityUtility.passwordEncoder().encode(password);
		user.setPassword(encryptedPassword);

		Role role = new Role();
		role.setRoleId(1);
		role.setName("ROLE_USER");
		Set<UserRole> userRoles = new HashSet<>();
		userRoles.add(new UserRole(user, role));
		userService.createUser(user, userRoles);

		String token = UUID.randomUUID().toString();
		userService.createPasswordResetTokenForUser(user, token);

		String appUrl = "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();

		SimpleMailMessage email = mailOrderConstructor.constructResetTokenEmail(appUrl, request.getLocale(), token,
				user, password);

		mailSender.send(email);

		model.addAttribute("emailSent", "true");
		model.addAttribute("orderProductList", user.getOrderProductList());

		return "myAccount";
	}

	@RequestMapping("/newUser")
	public String newUser(Locale locale, @RequestParam("token") String token, Model model) {
		PasswordResetToken passToken = userService.getPasswordResetToken(token);

		if (passToken == null) {
			String message = "Invalid Token.";
			model.addAttribute("message", message);
			return "redirect:/badRequest";
		}

		User user = passToken.getUser();
		String username = user.getUsername();

		UserDetails userDetails = userSecurityService.loadUserByUsername(username);

		Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, userDetails.getPassword(),
				userDetails.getAuthorities());

		SecurityContextHolder.getContext().setAuthentication(authentication);

		model.addAttribute("user", user);

		model.addAttribute("classActiveEdit", true);

		return "myProfile";
	}

	@RequestMapping(value = "/updateUserInfo", method = RequestMethod.POST)
	public String updateUserInfo(@ModelAttribute("user") User user, @ModelAttribute("newPassword") String newPassword,
			Model model) throws Exception {
		User currentUser = userService.findById(user.getId());

		if (currentUser == null) {
			throw new Exception("Utilisateur n'existe pas");
		}

		if (userService.findByEmail(user.getEmail()) != null) {
			if (userService.findByEmail(user.getEmail()).getId() != currentUser.getId()) {
				model.addAttribute("emailExists", true);
				return "myProfile";
			}
		}

		if (userService.findByUsername(user.getUsername()) != null) {
			if (userService.findByUsername(user.getUsername()).getId() != currentUser.getId()) {
				model.addAttribute("usernameExists", true);
				return "myProfile";
			}
		}

		String regex2 = "^[a-zA-Z0-9]([._-](?![._-])|[a-zA-Z0-9]){3,18}[a-zA-Z0-9]$";
		Pattern pattern2 = Pattern.compile(regex2);
		Matcher matcher2 = pattern2.matcher(user.getUsername());

		if (!matcher2.matches()) {

			String error2 = "Veuillez donner un nom d'utilisateur correct! "
					+ "Le nom d'utilisateur est composé de caractères alphanumériques (a-zA-Z0-9), minuscules ou majuscules.";
			model.addAttribute("error2", error2);
			model.addAttribute("classActiveEdit", true);

			return "myProfile";
		}

		String regex = "^[a-zA-Z0-9]{8}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(newPassword);

		if (!matcher.matches()) {

			String error = "Veuillez donner un mot de passe correct!" + " 8 caractères minimum (10 à 12 c’est mieux),"
					+ " des chiffres," + " des lettres minuscules," + " des lettres majuscules  .";
			model.addAttribute("error", error);
			model.addAttribute("classActiveEdit", true);

			return "myProfile";
		}

		if (newPassword != null && !newPassword.isEmpty() && !newPassword.equals("")) {
			BCryptPasswordEncoder passwordEncoder = SecurityUtility.passwordEncoder();
			String dbPassword = currentUser.getPassword();
			if (passwordEncoder.matches(user.getPassword(), dbPassword)) {
				currentUser.setPassword(passwordEncoder.encode(newPassword));
			} else {
				model.addAttribute("incorrectPassword", true);
				model.addAttribute("classActiveEdit", true);
				return "myProfile";
			}
		}

		currentUser.setFirstName(user.getFirstName());
		currentUser.setLastName(user.getLastName());
		currentUser.setUsername(user.getUsername());
		currentUser.setEmail(user.getEmail());

		userService.save(currentUser);

		model.addAttribute("updateSuccess", true);
		model.addAttribute("user", currentUser);
		model.addAttribute("classActiveEdit", true);

		UserDetails userDetails = userSecurityService.loadUserByUsername(currentUser.getUsername());

		Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, userDetails.getPassword(),
				userDetails.getAuthorities());

		SecurityContextHolder.getContext().setAuthentication(authentication);
		model.addAttribute("orderProductList", user.getOrderProductList());

		return "myProfile";
	}

}
