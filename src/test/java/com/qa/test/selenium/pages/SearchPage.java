package com.qa.test.selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage {

    @FindBy(id = "resetButton")
    private WebElement resetButton;

    @FindBy(xpath = "//*[@id=\"movieDisplay\"]/div[2]/div/div")
    private WebElement movie;

    public WebElement getMovie() {
        return movie;
    }

    public WebElement getResetButton() {
        return resetButton;
    }

}