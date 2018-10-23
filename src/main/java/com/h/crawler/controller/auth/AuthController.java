package com.h.crawler.controller.auth;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {
	@GetMapping("/auth")
	public String showAuth(Model model) {
		return "auth/register";
	}
}
