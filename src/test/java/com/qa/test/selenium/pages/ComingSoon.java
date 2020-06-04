package com.qa.test.selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ComingSoon {
	
	@FindBy(id = "homeBread")
	private WebElement breadcrumbHome;
	
	@FindBy(id = "play130")
	private WebElement comingPlay;
	
	@FindBy(id = "title130")
	private WebElement comingTitle;

	public WebElement getResetButton() {
		return resetButton;
	}

	@FindBy(id = "resetButton")
	private WebElement resetButton;
	
	@FindBy(id = "ageRating130")
	private WebElement comingClassif;

	public WebElement getBreadcrumbHome() {
		return breadcrumbHome;
	}

	public WebElement getComingPlay() {
		return comingPlay;
	}

	public WebElement getComingTitle() {
		return comingTitle;
	}

	public WebElement getComingClassif() {
		return comingClassif;
	}
	
	

}
