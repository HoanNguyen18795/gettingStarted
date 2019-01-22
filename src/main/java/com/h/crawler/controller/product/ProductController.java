package com.h.crawler.controller.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.h.crawler.model.Product;
import com.h.crawler.service.product.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
	public String showProduct(@PathVariable(value = "id") String id, Model model) {
		Product product = productService.getProduct(Long.valueOf(id));
		boolean isAvailable = product.getTotal() >0;
		if(isAvailable) {
			model.addAttribute("total", product.getTotal());
		}
		model.addAttribute("isAvailable", product.getTotal() >0?true:false);
		model.addAttribute("product", product);
		return "product/detail";
	}
}
