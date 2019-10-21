package com.h.crawler.repository.auth;

public interface AuthDAOCustom {
	
	public void changePassword(String newPassword, Long userId);
}
