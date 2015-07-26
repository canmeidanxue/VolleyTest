package com.example.volleytest.bean;

public class WebPage {

	private String webPageTitle;								//链接的title
	private String webUrl;								//链接的url	
	private String  webPageDescription;					//链接描述
	
	public WebPage(String webPageTitle, String webPageDescription, String webUrl) {
		super();
		this.webPageTitle = webPageTitle;
		this.webUrl = webUrl;
		this.webPageDescription = webPageDescription;
	}
	
	public String getWebPageTitle() {
		return webPageTitle;
	}
	public void setWebPageTitle(String webPageTitle) {
		this.webPageTitle = webPageTitle;
	}
	public String getWebUrl() {
		return webUrl;
	}
	public void setWebUrl(String webUrl) {
		this.webUrl = webUrl;
	}
	public String getWebPageDescription() {
		return webPageDescription;
	}
	public void setWebPageDescription(String webPageDescription) {
		this.webPageDescription = webPageDescription;
	}
	
}
