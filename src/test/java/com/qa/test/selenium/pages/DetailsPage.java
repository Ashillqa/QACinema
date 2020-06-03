package com.qa.test.selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DetailsPage {

    @FindBy(xpath = "//*[@id=\"movieInfo\"]/div[1]/h1")
    private WebElement title;

    public WebElement getTitle() {
        return title;
    }
}