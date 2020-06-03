package com.qa.test.selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MovieShowingPage {
	
	@FindBy(id = "homeBread")
	private WebElement breadcrumbHome;
	
	@FindBy(xpath = "//*[@id=\"playbutton120\"]")
	private WebElement showingPlay;
	
	@FindBy(xpath = "//*[@id=\"title\"]")
	private WebElement showingTitle;
	
	
	@FindBy(xpath = "//*[@id=\"ageRating\"]")
	private WebElement showingClassif;
	
	@FindBy(xpath = "//*[@id=\"primeDiv\"]/div[8]/a")
	private WebElement showMore;
	
	@FindBy(xpath = "//*[@id=\"play\"]/i")
	private WebElement ExpectedPlay;
	
	@FindBy(xpath = "//*[@id=\"primeDiv\"]/div[2]/div/div[2]/h3/a")
	private WebElement ExpectedTitle;
	
	@FindBy(xpath = "/html/body/section[2]/div/div/div[2]/div/div[2]/ul/li[2]/a")
	private WebElement ExpectedClassif;

	public WebElement getBreadcrumbHome() {
		return breadcrumbHome;
	}

	public WebElement getShowingPlay() {
		return showingPlay;
	}

	public WebElement getShowingTitle() {
		return showingTitle;
	}

	public WebElement getShowingClassif() {
		return showingClassif;
	}

	public WebElement getShowMore() {
		return showMore;
	}

	public WebElement getExpectedPlay() {
		return ExpectedPlay;
	}

	public WebElement getExpectedTitle() {
		return ExpectedTitle;
	}

	public WebElement getExpectedClassif() {
		return ExpectedClassif;
	}
	
	

}
