package com.qa.test.selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ClassificationsPage {

    @FindBy(className = "section__title")
    private WebElement title;

    public WebElement getTitle() {
        return title;
    }
}