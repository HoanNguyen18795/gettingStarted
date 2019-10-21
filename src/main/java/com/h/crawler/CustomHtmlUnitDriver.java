package com.h.crawler;

import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import com.gargoylesoftware.htmlunit.SilentCssErrorHandler;

public class CustomHtmlUnitDriver extends HtmlUnitDriver {

	public CustomHtmlUnitDriver() {
		super();
		this.getWebClient().setCssErrorHandler(new SilentCssErrorHandler());
	}
}
