package com.qa.test.selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GalleryPage {

    @FindBy(xpath = "//*[@id=\"resetButton\"]")
    private WebElement resetButton;

    @FindBy(id = "homeBread")
    private WebElement breadcrumbHome;

    @FindBy(id = "playbutton124")
    private WebElement showingPlay;

    @FindBy(id = "title130")
    private WebElement comingTitle;

    @FindBy(xpath = "//*[@id=\"ageRating\"]")
    private WebElement showingClassif;

    @FindBy(id = "comingButton")
    private WebElement showMore;


    @FindBy(xpath = "//*[@id=\"primeDiv\"]/div[2]/div/div[2]/h3/a")
    private WebElement ExpectedTitle;

    @FindBy(xpath = "/html/body/section[2]/div/div/div[2]/div/div[2]/ul/li[2]/a")
    private WebElement ExpectedClassif;

    @FindBy(id = "searchBox2")
    private WebElement term;

    public WebElement getTerm() {
        return term;
    }

    public WebElement getGenre() {
        return genre;
    }

    @FindBy(id = "selectGenre")
    private WebElement genre;


    public WebElement getBreadcrumbHome() {
        return breadcrumbHome;
    }

    public WebElement getShowingPlay() {
        return showingPlay;
    }

    public WebElement getComingTitle() {
        return comingTitle;
    }

    public WebElement getShowingClassif() {
        return showingClassif;
    }

    public WebElement getShowMore() {
        return showMore;
    }

    public WebElement getExpectedTitle() {
        return ExpectedTitle;
    }

    public WebElement getExpectedClassif() {
        return ExpectedClassif;
    }

    public WebElement getResetButton() {
        return resetButton;
    }
}