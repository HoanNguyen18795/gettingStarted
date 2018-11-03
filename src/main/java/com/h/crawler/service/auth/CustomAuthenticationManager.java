package com.h.crawler.service.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.h.crawler.model.auth.Account;
import com.h.crawler.repository.auth.AuthRepository;

public class CustomAuthenticationManager implements AuthenticationManager {

	@Autowired
	private AuthRepository authRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getPrincipal() + "";
		String password = authentication.getCredentials() + "";

		Account user = authRepository.findByUsername(username);
		if (user == null) {
			throw new BadCredentialsException("1000");
		}
		if (!bCryptPasswordEncoder.matches(password, user.getPassword())) {
			throw new BadCredentialsException("1000");
		}
		return new UsernamePasswordAuthenticationToken(username, password);
	}
}
