package com.qa.test.selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FooterPage {
	
	@FindBy(xpath = "/html/body/footer/div/div/div[2]/ul/li[1]/a")
	private WebElement aboutPage;
	
	@FindBy(xpath = "/html/body/footer/div/div/div[2]/ul/li[2]/a")
	private WebElement contactPage;
	
	@FindBy(xpath = "/html/body/footer/div/div/div[2]/ul/li[3]/a")
	private WebElement home;
	
	@FindBy(xpath = "/html/body/footer/div/div/div[3]/ul/li[1]/a")
	private WebElement terms404;
	
	@FindBy(xpath = "/html/body/footer/div/div/div[3]/ul/li[2]/a")
	private WebElement privacy404;
	
	@FindBy(xpath = "/html/body/footer/div/div/div[3]/ul/li[3]/a")
	private WebElement security404;
	
	@FindBy(xpath = "/html/body/footer/div/div/div[4]/ul[1]/li[1]/a")
	private WebElement numberLink;
	
	@FindBy(xpath = "/html/body/footer/div/div/div[4]/ul[1]/li[2]/a")
	private WebElement emailLink;
	
	@FindBy(xpath = "/html/body/footer/div/div/div[4]/ul[2]/li[3]/a")
	private WebElement twitterLink;

	public WebElement getAboutPage() {
		return aboutPage;
	}

	public WebElement getContactPage() {
		return contactPage;
	}

	public WebElement getHome() {
		return home;
	}

	public WebElement getTerms404() {
		return terms404;
	}

	public WebElement getPrivacy404() {
		return privacy404;
	}

	public WebElement getSecurity404() {
		return security404;
	}

	public WebElement getNumberLink() {
		return numberLink;
	}

	public WebElement getEmailLink() {
		return emailLink;
	}
	
	
	public WebElement getTwitterLink() {
		return twitterLink;
	}
	
}
