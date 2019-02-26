package com.h.crawler.controller.product;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.h.crawler.model.Product;
import com.h.crawler.model.auth.UserAccount;
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
	@RequestMapping(value = "/addToCart", method = RequestMethod.GET)
	public @ResponseBody String addToCart( @RequestParam Long quantity, @RequestParam Long productId, Authentication authentication) {
	
		if(productService.isProductAvailable(productId, quantity)) {
			return "Product not available";
		}
		LocalDate localDate = LocalDate.now();
		Date now = Date.valueOf(localDate);
		
		UserAccount account = (UserAccount)authentication.getPrincipal();
		
		productService.insertCart(account.getId(), productId, quantity, now, now, 0L);
		return "product";
	}
}
