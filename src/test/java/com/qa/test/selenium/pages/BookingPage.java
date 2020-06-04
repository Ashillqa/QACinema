package com.qa.test.selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BookingPage {

    @FindBy(id = "customerName")
    private WebElement name;

	@FindBy(id = "customerEmail")
	private WebElement email;

	@FindBy(id = "customerPhone")
	private WebElement number;

	@FindBy(id = "adult")
	private WebElement adult;

	@FindBy(id = "child")
	private WebElement child;

	@FindBy(id = "student")
	private WebElement student;

	@FindBy(id = "extra2Pounds")
	private WebElement upgrade;

	@FindBy(id = "paymentButton")
	private WebElement payButton;

	public WebElement getTotalPrice() {
		return totalPrice;
	}

	@FindBy(id = "totalPrice")
	private WebElement totalPrice;

	public WebElement getChild() {
		return child;
	}

	public WebElement getName() {
		return name;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getNumber() {
		return number;
	}

	public WebElement getAdult() {
		return adult;
	}

	public WebElement getStudent() {
		return student;
	}

	public WebElement getUpgrade() {
		return upgrade;
	}

	public WebElement getPayButton() {
		return payButton;
	}




}