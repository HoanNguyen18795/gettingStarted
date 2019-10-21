package com.h.crawler;

import java.security.Principal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@Controller
public class WebCrawlerApplication extends SpringBootServletInitializer{

	@GetMapping("/user")
	@ResponseBody
	public Principal user(Principal user) {
		return user;
	}
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
