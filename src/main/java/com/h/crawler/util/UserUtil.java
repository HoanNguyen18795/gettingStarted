package com.h.crawler.util;

import org.springframework.security.core.context.SecurityContextHolder;

import com.h.crawler.model.auth.UserAccount;

public class UserUtil {
	
	public static Long getUserId() {
		Object userPrincipal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return ((UserAccount) userPrincipal).getId();
	}
}
