package com.h.crawler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class WebCrawlerApplication extends SpringBootServletInitializer{

   @Override
   protected SpringApplicationBuilder configure (SpringApplicationBuilder builder) {
       return builder.sources(WebCrawlerApplication.class);
   }
	public static void main(String[] args) {
		SpringApplication.run(WebCrawlerApplication.class, args);
	}
	@Bean
	WebMvcConfigurer webMvcConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addResourceHandlers(ResourceHandlerRegistry registry) {
				registry.addResourceHandler("/product/detail/**").addResourceLocations("classpath:/static/");
			}
		};
	}
}
