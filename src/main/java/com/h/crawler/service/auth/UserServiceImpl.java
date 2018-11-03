package com.h.crawler.service.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.h.crawler.model.auth.Account;
import com.h.crawler.repository.auth.AuthRepository;

@Service
public class UserServiceImpl implements UserService {
	 @Autowired
	 private AuthRepository authRepository;

	 @Autowired
	 private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Override
	public void save(Account account) {
		account.setPassword(bCryptPasswordEncoder.encode(account.getPassword()));
		authRepository.save(account);
	}

	@Override
	public Account findByUsername(String username) {
		return authRepository.findByUsername(username);
	}

}
