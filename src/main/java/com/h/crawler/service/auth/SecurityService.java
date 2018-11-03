package com.h.crawler.service.auth;

public interface SecurityService {

	public String findLoggedInUsername();
	
	public void autologin(String username, String password);
	
}
