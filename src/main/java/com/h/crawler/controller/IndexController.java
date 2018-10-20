package com.h.crawler.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	@GetMapping("/greeting")
	public String gretting(Model model) {
		return "index";
	}
}
