package com.h.crawler.util;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.ui.Model;

import com.h.crawler.model.auth.UserAccount;

public class UserUtil {
	
	public static final String ADMIN = "AD";
	
	public static final String USER = "US";
	
	public static final String FIXED_EMAIL = "testEmail@abc.com";
	
	public static Long getUserId(SecurityContext securityContext) {
		Object userPrincipal = securityContext.getAuthentication().getPrincipal();
		return ((UserAccount) userPrincipal).getId();
	}
	public static Model setLogin(Model model, SecurityContext securityContext) {
		Object principal = securityContext.getAuthentication();
		if (principal != null) {
			model.addAttribute("isLogedin", true);
		}
		return model;
	}
}
