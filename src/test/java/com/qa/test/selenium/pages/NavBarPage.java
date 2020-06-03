package com.qa.test.selenium.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavBarPage {
	
	@FindBy(id = "dropdownMenuCatalog")
	private WebElement movieNav;
	
	@FindBy(id = "showing")
	private WebElement showing;
	
	@FindBy(id = "coming")
	private WebElement coming;
	
	@FindBy(id = "screens")
	private WebElement screens;
	
	@FindBy(id = "dropdownMenuCatalog1")
	private WebElement PlanningNav;
	
	@FindBy(id = "gettingHere")
	private WebElement gettingHere;
	
	@FindBy(id = "whatToDo")
	private WebElement whatToDo;
	
	@FindBy(id = "about")
	private WebElement about;
	
	@FindBy(xpath = "//*[@id=\"dropdownMenuMore\"]/i")
	private WebElement seeMore;
	
	@FindBy(id = "contact")
	private WebElement contact;
	
	@FindBy(id = "forum")
	private WebElement forum;
	
	@FindBy(id = "search")
	private WebElement search1;
	
	@FindBy(xpath = "//*[@id=\"searchButton\"]")
	private WebElement searchMain;
	
	public WebElement getSearchMain() {
		return searchMain;
	}
	
	public WebElement getSearch() {
		return search1;
	}
	
	public WebElement getMore() {
		return seeMore;
	}
	
	public WebElement getContact() {
		return contact;
	}
	
	public WebElement getForum() {
		return forum;
	}

	public WebElement getMovieNav() {
		return movieNav;
	}

	public WebElement getShowing() {
		return showing;
	}

	public WebElement getComing() {
		return coming;
	}
	
	public WebElement getScreens() {
		return screens;
	}
	
	public WebElement getPlanningNav() {
		return PlanningNav;
	}
	
	public WebElement getGettingHere() {
		return gettingHere;
	}
	
	public WebElement getWhatToDo() {
		return whatToDo;
	}
	
	public WebElement getAbout() {
		return about;
	}
	

}
