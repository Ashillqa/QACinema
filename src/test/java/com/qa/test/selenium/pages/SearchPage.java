package com.qa.test.selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage {

    @FindBy(xpath = "//*[@id=\"resetButton\"]")
    private WebElement resetButton;

    public WebElement getResetButton() {
        return resetButton;
    }
}