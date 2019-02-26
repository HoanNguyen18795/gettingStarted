package com.h.crawler.service.product;

import java.sql.Date;
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
	 
	 public boolean isProductAvailable( Long productId, Long quantity) {
		 return productRepository.isAvalable(productId, quantity);
	 }
	 
	 public void insertCart(Long cartId, Long productId, Long quantity, Date insDate, Date updDate, Long delFlg) {
		 productRepository.insertProductCart(cartId, productId, quantity, insDate, updDate, delFlg);
	 }
	 
	 public void updateProductTotal(Long quantity, Long productId) {
		 productRepository.updateProductTotal(quantity, productId);
	 }
}
