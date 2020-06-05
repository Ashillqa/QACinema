package com.qa.test.selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage {

    @FindBy(id = "resetButton")
    private WebElement resetButton;

    @FindBy(id = "play124")
    private WebElement play1;

    @FindBy(id = "title124")
    private WebElement title1;

    @FindBy(xpath = "//*[@id=\"ageRating\"]")
    private WebElement rating;

    @FindBy(xpath = "//*[@id=\"primeDiv\"]/div[4]")
    private WebElement movieFeature;

    @FindBy(id = "play")
    private WebElement playFeature;

    @FindBy(xpath = "//*[@id=\"title125\"]")
    private WebElement titleFeature;

    @FindBy(id = "ageRating")
    private WebElement ratingFeature;

    @FindBy(xpath = "//*[@id=\"primeDiv\"]/div[8]/a")
    private WebElement showMoreButton;





    @FindBy(id = "selectGenre")
    private WebElement genre;

    @FindBy(id = "filter__imbd-start")
    private WebElement minRating;

    @FindBy(id = "filter__imbd-end")
    private WebElement maxRating;

    @FindBy(id = "filter__years-start")
    private WebElement minYear;

    @FindBy(id = "filter__years-end")
    private WebElement maxYear;

    @FindBy(id = "searchBox2")
    private WebElement term;

    public WebElement getTitle1() {
        return title1;
    }

    public WebElement getGenre() {
        return genre;
    }

    public WebElement getMinRating() {
        return minRating;
    }

    public WebElement getMaxRating() {
        return maxRating;
    }

    public WebElement getMinYear() {
        return minYear;
    }

    public WebElement getMaxYear() {
        return maxYear;
    }

    public WebElement getTerm() {
        return term;
    }

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

    public WebElement getShowingTitle() {
        return title1;
    }
}