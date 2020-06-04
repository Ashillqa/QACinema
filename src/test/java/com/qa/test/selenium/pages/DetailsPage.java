package com.qa.test.selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DetailsPage {

    @FindBy(xpath = "//*[@id=\"movieInfo\"]/div[1]/h1")
    private WebElement title;
    
    @FindBy(xpath = "/html/body/section/div[2]/div/div[2]/div/div/div[2]/div/div[1]/ul/li[1]/a")
    private WebElement hdButton;
    
    @FindBy(id = "ageRating")
    private WebElement age;
    
    @FindBy(xpath = "//*[@id=\"collapse0\"]/div/table/tbody/tr/th/a")
    private WebElement bookButton;
  
    

    public WebElement getTitle() {
        return title;
    }
    
    public WebElement getBookButton() {
    	return bookButton;
    }
    
    public WebElement getHdButton() {
    	return hdButton;
    }
    
    public WebElement getAge() {
    	return age;
    }
    
    
}

