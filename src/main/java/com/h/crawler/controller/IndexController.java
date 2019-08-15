package com.h.crawler.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.h.crawler.repository.outdoor.IndoorRepository;
import com.h.crawler.service.product.ProductService;

@Controller
public class IndexController {
	
	 @Autowired
	 private ProductService productService;
	 
	 @Autowired
	 private IndoorRepository indoorRepository;
	
//	@GetMapping("/")
//	public String gretting(Model model) {
//		UserUtil.setLogin(model, SecurityContextHolder.getContext());
//		
//		List<Product> featuredProductList = productService.getFeturedProductList();
//		model.addAttribute("featureProductList", featuredProductList);
//		return "index";
//	}
	
	@GetMapping("/")
	public String gretting(Model model) {
		indoorRepository.getOutDoorList();
		return "adminIndex";
	}
}
