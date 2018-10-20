package com.h.crawler.util;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.h.crawler.Const;
import com.h.crawler.model.Post;

/**
 * @author HoanNK
 *
 */
public class WebCrawlerUtil {
	
	
	/**
	 * Parse Web-site content and get list of post without java word
	 * @param driver 
	 * @return list of post without java word
	 */
	public static List<Post> getPostFeedItemContentList(WebDriver driver) {
		
		driver.get(Const.VIBLO_URL);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		List<WebElement> postFeedItemElementList = driver.findElements(By.className(Const.POST_FEED_ITEM_INFO_CLASS_NAME));
		if (postFeedItemElementList.isEmpty()) {
			return new ArrayList<Post>();
		}
		
		List<Post> postFeedItemList = new ArrayList<Post>();
		
		for (WebElement webElement : postFeedItemElementList) {
			
			String userName 		= webElement.findElement(By.className(Const.POST_META_INLINE_CLASS_NAME))
												.findElement(By.className(Const.USER_INLINE_CLASS_NAME))
												.getText();
			WebElement postTitle	= webElement.findElement(By.className(Const.POST_TITLE_INLINE_CLASS_NAME));
			
			String postFeedContent	= postTitle.findElement(By.tagName(Const.H3_TAG_NAME)).getText();
			
			List<WebElement> tagElementList	= postTitle.findElement(By.className(Const.TAG_CLASS_NAME)).findElements(By.tagName(Const.A_TAG_NAME));
			
			if (!hasFobbidenWord(Const.FOBBIDEN_WORD, StringUtils.trim(postFeedContent).toLowerCase()) && ! hasFobbidenTagWord(Const.FOBBIDEN_WORD, tagElementList)) {
				postFeedItemList.add(new Post(userName, postFeedContent));				
			}
		}
		
		return postFeedItemList;
	}
	
	/**
	 * Check if a string contains specified forbidden word
	 * @param fobbiden string that content must not contain
	 * @param source target string to be validated
	 * @return True if contain forbidden word, false other wise
	 */
	private static boolean hasFobbidenWord(String fobbiden, String source) {
		if (source.startsWith(fobbiden + Const.SIMPLE_WHITE_SPACE)) {
			return true;
		}
		if (source.endsWith(Const.SIMPLE_WHITE_SPACE + fobbiden)) {
			return true;
		}
		if (source.contains(Const.SIMPLE_WHITE_SPACE + fobbiden + Const.SIMPLE_WHITE_SPACE)) {
			return true;
		}
		return false;
	}
	
	/**
	 * Check if tag list contain forbidden word
	 * @param fobbiden string that tag list must not contain
	 * @param tagElementList tag list
	 * @return True if contain forbidden word, false other wise
	 */
	private static boolean hasFobbidenTagWord(String fobbiden, List<WebElement> tagElementList) {
		
		if (tagElementList.isEmpty()) {
			return false;
		}

		for (WebElement webElement : tagElementList) {
			String tagName = StringUtils.trim(webElement.getText()).toLowerCase();
			if (tagName.startsWith(fobbiden + Const.SIMPLE_WHITE_SPACE) ) {
				return true;
			}
			if (tagName.endsWith(Const.SIMPLE_WHITE_SPACE + fobbiden)) {
				return true;
			}
			if (tagName.contains(Const.SIMPLE_WHITE_SPACE + fobbiden + Const.SIMPLE_WHITE_SPACE)) {
				return true;
			}
		}
		return false;
	}
}
