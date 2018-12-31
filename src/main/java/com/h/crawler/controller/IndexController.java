package com.h.crawler.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.h.crawler.model.Product;
import com.h.crawler.service.product.ProductService;

@Controller
public class IndexController {
	
	 @Autowired
	 private ProductService productService;
	
	@GetMapping("/")
	public String gretting(Model model) {
		Object principal = SecurityContextHolder.getContext().getAuthentication();
		if (principal != null) {
			model.addAttribute("isLogedin", true);
		}
		List<Product> featuredProductList = productService.getFeturedProductList();
		model.addAttribute("featureProductList", featuredProductList);
		return "index";
	}
}
