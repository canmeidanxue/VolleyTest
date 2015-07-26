package com.example.volleytest.bean;

public class WebPage {

	private String webPageTitle;								//���ӵ�title
	private String webUrl;								//���ӵ�url	
	private String  webPageDescription;					//��������
	
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
