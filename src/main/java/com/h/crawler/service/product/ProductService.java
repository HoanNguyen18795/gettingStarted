package com.h.crawler.service.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.h.crawler.model.Product;
import com.h.crawler.repository.product.ProductRepository;

@Service
public class ProductService {
	 @Autowired
	 private ProductRepository productRepository;
	 
	 public List<Product> getFeturedProductList() {
		 return productRepository.getFeatureProduct();
	 }
	 
	 public Product getProduct(long id) {
		 return productRepository.findById(id);
	 }
}
