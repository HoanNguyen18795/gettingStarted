package com.h.crawler.service.auth;

import com.h.crawler.model.auth.Account;

public interface UserService {
	public void save(Account account);
	
	public Account findByUsername(String username);
	
	boolean existByEmail(String email);
	
	long changePassword(String newPassword, Long userId);
}
