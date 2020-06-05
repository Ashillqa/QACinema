package com.qa.test.selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentPage {

    @FindBy(id = "cardHoldersName")
    private WebElement name;

	@FindBy(name = "cardnumber")
	private WebElement details;

	@FindBy(id = "email")
	private WebElement email;

	@FindBy(id = "submitButton")
	private WebElement pay;

	public WebElement getName() {
		return name;
	}

	public void setName(WebElement name) {
		this.name = name;
	}

	public WebElement getDetails() {
		return details;
	}

	public void setDetails(WebElement details) {
		this.details = details;
	}

	public WebElement getEmail() {
		return email;
	}

	public void setEmail(WebElement email) {
		this.email = email;
	}

	public WebElement getPay() {
		return pay;
	}

	public void setPay(WebElement pay) {
		this.pay = pay;
	}
}