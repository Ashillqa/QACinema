package com.qa.test.selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForumPage {
	
	@FindBy(id = "movieTitle")
	private WebElement titleOption;
	
	@FindBy(id = "username")
	private WebElement username;
	
	@FindBy(xpath = "//*[@id=\"comForm\"]/div[2]/div/label[2]")
	private WebElement stars;
	
	@FindBy(id = "text")
	private WebElement postComment;
	
	@FindBy(xpath = "//*[@id=\"comForm\"]/button")
	private WebElement comButton;
	
	@FindBy(xpath = "//*[@id=\"movieTitle\"]/option[5]")
	private WebElement movieOption5;
	
	@FindBy(xpath = "//*[@id=\"enterPointCom\"]/li/div/span[1]")
	private WebElement resultComment;
	
	public WebElement getResultComment() {
		return resultComment;
	}

	
	
	
	
	
	
	
	
	
	
	public WebElement getTitleOption() {
		return titleOption;
	}
	
	public WebElement getMovieOption5() {
		return movieOption5;
	}

	public WebElement getUsername() {
		return username;
	}

	public WebElement getStars() {
		return stars;
	}

	public WebElement getPostComment() {
		return postComment;
	}

	public WebElement getComButton() {
		return comButton;
	}
	
	

}
