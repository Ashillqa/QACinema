package com.qa.test.selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	
	@FindBy(xpath = "//*[@id=\"primeDiv\"]/div[1]/h1/b")
	private WebElement featureFilm;
	
	@FindBy(id = "play124")
	private WebElement featurePlay;
	
	@FindBy(xpath = "//*[@id=\"primeDiv\"]/div[2]/div/div[2]/h3/a")
	private WebElement featureTitle;
	
	@FindBy(id="ageRating124")
	private WebElement featureClassif;
	
	@FindBy(xpath = "//*[@id=\"soonComeDiv\"]/div[1]/h2/b")
	private WebElement comingSoon;
	
	@FindBy(id = "play130")
	private WebElement soonPlay;
	
	@FindBy(xpath = "//*[@id=\"soonComeDiv\"]/div[2]/div/div[2]/h3/a")
	private WebElement soonTitle;
	
	@FindBy(id = "ageRating130")
	private WebElement soonClassif;

	public WebElement getFeatureFilm() {
		return featureFilm;
	}

	public WebElement getFeaturePlay() {
		return featurePlay;
	}

	public WebElement getFeatureTitle() {
		return featureTitle;
	}

	public WebElement getFeatureClassif() {
		return featureClassif;
	}

	public WebElement getComingSoon() {
		return comingSoon;
	}

	public WebElement getSoonPlay() {
		return soonPlay;
	}

	public WebElement getSoonTitle() {
		return soonTitle;
	}

	public WebElement getSoonClassif() {
		return soonClassif;
	}
	
	
	

}
