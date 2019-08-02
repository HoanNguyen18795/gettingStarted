package com.h.crawler.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.h.crawler.service.auth.SecurityService;
import com.h.crawler.service.auth.UserService;

@Controller
public class Index {
	 @Autowired
	 private UserService userService;

	 @Autowired
	 private SecurityService securityService;

	 
}
