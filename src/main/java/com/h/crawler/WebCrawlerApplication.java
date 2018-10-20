package com.h.crawler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class WebCrawlerApplication extends SpringBootServletInitializer{

	/*@Autowired
	WebCrawlerAbstractService webCrawlerService;

	@Autowired
	WebDriver customHtmlUnitDriver;

	public static void main(String[] args) {
		SpringApplication.run(WebCrawlerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		webCrawlerService.savePostFeedItem(customHtmlUnitDriver);
	}*/
   @Override
   protected SpringApplicationBuilder configure (SpringApplicationBuilder builder) {
       return builder.sources(WebCrawlerApplication.class);
   }
	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(WebCrawlerApplication.class, args);

		for (String name : applicationContext.getBeanDefinitionNames()) {
			System.out.println("----------------------");
			System.out.println(name);
		}
	}
}
