package com.bijou;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bijou.domain.User;
import com.bijou.domain.security.Role;
import com.bijou.domain.security.UserRole;
import com.bijou.service.UserService;
import com.bijou.utility.SecurityUtility;

@SpringBootApplication
public class BijouApp implements CommandLineRunner {

	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(BijouApp.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user1 = new User();
		user1.setFirstName("Zoi");
		user1.setLastName("Sot");
		user1.setUsername("zoisot");
		user1.setPassword(SecurityUtility.passwordEncoder().encode("Sozo0911"));
		user1.setEmail("sotiriadou.zoi@hotmail.gr");
		Set<UserRole> userRoles = new HashSet<>();
		Role role1 = new Role();
		role1.setRoleId(1);
		role1.setName("ROLE_USER");
		userRoles.add(new UserRole(user1, role1));

		userService.createUser(user1, userRoles);
	}
}
