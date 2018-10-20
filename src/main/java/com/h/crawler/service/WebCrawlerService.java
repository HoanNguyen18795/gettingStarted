package com.h.crawler.service;

import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Service;

import com.h.crawler.util.WebCrawlerUtil;

@Service
public class WebCrawlerService extends WebCrawlerAbstractService{
	
	@Override
	public void savePostFeedItem(WebDriver driver) {
		postFeedItem.saveAll(WebCrawlerUtil.getPostFeedItemContentList(driver));
	}
}
