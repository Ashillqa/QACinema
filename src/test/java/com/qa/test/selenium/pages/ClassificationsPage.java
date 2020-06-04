package com.qa.test.selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ClassificationsPage {

    @FindBy(className = "section__title")
    private WebElement title;
    
    @FindBy(id = "tbcLink")
    private WebElement tbc;
    
    @FindBy(id = "ULink")
    private WebElement universal;
    
    @FindBy(id = "pgLink")
    private WebElement parental;
    
    @FindBy(id = "TwelveLink")
    private WebElement twelve;
    
    @FindBy(id = "fifteenLink")
    private WebElement fifteen;
    
    @FindBy(id = "eighteenLink")
    private WebElement eighteen;
    
    
    public WebElement getTitle() {
        return title;
    }


	public WebElement getTbc() {
		return tbc;
	}


	public WebElement getUniversal() {
		return universal;
	}


	public WebElement getParental() {
		return parental;
	}


	public WebElement getTwelve() {
		return twelve;
	}


	public WebElement getFifteen() {
		return fifteen;
	}


	public WebElement getEighteen() {
		return eighteen;
	}
    
    
}