package com.h.crawler.service;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import com.h.crawler.model.Post;

public abstract class WebCrawlerAbstractService {
	@Autowired
	protected CrudRepository<Post, Long> postFeedItem;
	
	public abstract void savePostFeedItem(WebDriver driver);
}
