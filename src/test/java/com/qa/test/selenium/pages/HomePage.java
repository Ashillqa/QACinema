package com.qa.test.selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	
	@FindBy(xpath = "//*[@id=\"primeDiv\"]/div[1]/h1/b")
	private WebElement featureFilm;
	
	@FindBy(xpath = "/html/body/section[1]/div/div/div[2]/div/div[1]/a/i")
	private WebElement featurePlay;
	
	@FindBy(xpath = "//*[@id=\"primeDiv\"]/div[2]/div/div[2]/h3/a")
	private WebElement featureTitle;
	
	@FindBy(xpath="//*[@id=\"ageRating\"]")
	private WebElement featureClassif;
	
	@FindBy(xpath = "//*[@id=\"soonComeDiv\"]/div[1]/h2/b")
	private WebElement comingSoon;
	
	@FindBy(xpath = "/html/body/section[4]/div/div/div[2]/div/div[1]/a/i")
	private WebElement soonPlay;
	
	@FindBy(xpath = "//*[@id=\"soonComeDiv\"]/div[2]/div/div[2]/h3/a")
	private WebElement soonTitle;
	
	@FindBy(xpath = "/html/body/section[4]/div/div/div[2]/div/div[2]/div/ul/li[2]/a")
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
