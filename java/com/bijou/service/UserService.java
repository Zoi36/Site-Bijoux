package com.bijou.service;

import java.util.Set;

import com.bijou.domain.User;
import com.bijou.domain.security.PasswordResetToken;
import com.bijou.domain.security.UserRole;

public interface UserService {
	PasswordResetToken getPasswordResetToken(final String token);

	void createPasswordResetTokenForUser(final User user, final String token);

	User findByUsername(String username);

	User findById(Long id);
	
	User findByEmail(String email);

	User createUser(User user, Set<UserRole> userRoles) throws Exception;

	User save(User user);

}
