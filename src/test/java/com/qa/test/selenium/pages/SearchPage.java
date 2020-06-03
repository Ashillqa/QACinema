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

    @FindBy(xpath = "//*[@id=\"ageRating\"]")
    private WebElement rating;

    @FindBy(xpath = "//*[@id=\"primeDiv\"]/div[4]")
    private WebElement movieFeature;

    @FindBy(id = "play")
    private WebElement playFeature;

    @FindBy(className = "featuredMovieTitle")
    private WebElement titleFeature;

    @FindBy(id = "ageRating")
    private WebElement ratingFeature;

    @FindBy(className = "section__btn")
    private WebElement showMoreButton;

    public WebElement getShowMoreButton() {
        return showMoreButton;
    }

    public WebElement getMovieFeature() {
        return movieFeature;
    }

    public WebElement getPlayFeature() {
        return playFeature;
    }

    public WebElement getTitleFeature() {
        return titleFeature;
    }

    public WebElement getRatingFeature() {
        return ratingFeature;
    }

    public WebElement getRating() {
        return rating;
    }

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