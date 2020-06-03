package com.qa.test.selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage {

    @FindBy(id = "resetButton")
    private WebElement resetButton;

    @FindBy(id = "play1")
    private WebElement play1;

    @FindBy(id = "title1")
    private WebElement title1;

    public WebElement getResetButton() {
        return resetButton;
    }

    public WebElement getPlay1() {
        return play1;
    }

    public WebElement getTitle1() {
        return title1;
    }
}