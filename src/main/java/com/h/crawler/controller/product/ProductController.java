package com.h.crawler.controller.product;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {
	@GetMapping("/createProduct")
	public String createProduct() {
		return "/product/addProduct";
	}

}
