package com.qa.test.selenium.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.qa.App;
import com.qa.test.selenium.pages.*;
import org.junit.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class NavBarPageTest {

	  public static WebDriver driver;
	  private final WebDriverWait wait = new WebDriverWait(driver, 10);

	    @LocalServerPort
	    private int port;

	    @BeforeClass
	    public static void init() {
	        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	        ChromeOptions opts = new ChromeOptions();
	        opts.setHeadless(true);
	        driver = new ChromeDriver(opts);
			driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
	        driver.manage().window().maximize();
	    }

	    @AfterClass
	    public static void teardown() {
	        driver.quit();
	    }



	    @Test
	    public void testMoviesShowingNav() {
	        driver.get("http://localhost:" + port +"/index.html");
	        NavBarPage navigation = PageFactory.initElements(driver, NavBarPage.class);
	        navigation.getMovieNav().click();
	        navigation.getShowing().click();
	        wait.until(ExpectedConditions.urlContains("gallery.html"));
	        assertEquals("http://localhost:" + port +"/gallery.html", driver.getCurrentUrl());

	    }

	    @Test
	    public void testSearchNav() throws InterruptedException {
	    	driver.get("http://localhost:" + port +"/index.html");
	    	NavBarPage navigation = PageFactory.initElements(driver, NavBarPage.class);
	    	navigation.getSearch().click();
	    	wait.until(ExpectedConditions.elementToBeClickable(By.id("searchButton")));
	    	navigation.getSearchMain().click();
	    	assertEquals("http://localhost:" + port +"/search.html?term=", driver.getCurrentUrl());
	    }


	    @Test
	    public void testMoviesComingNav() {
	        driver.get("http://localhost:" + port +"/index.html");
	        NavBarPage navigation = PageFactory.initElements(driver, NavBarPage.class);
	        assertEquals("MOVIES",navigation.getMovieNav().getText());
	        navigation.getMovieNav().click();
	        wait.until(ExpectedConditions.textToBePresentInElement(navigation.getComing(),"Coming Soon"));
	        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("coming")));
	        navigation.getComing().click();
	        assertEquals("http://localhost:" + port +"/comingSoon.html", driver.getCurrentUrl());
	    }



	    @Test
	    public void testScreensNav() {
	        driver.get("http://localhost:" + port +"/index.html");
	        NavBarPage navigation = PageFactory.initElements(driver, NavBarPage.class);
	        assertEquals("SCREENS", navigation.getScreens().getText());
	        navigation.getScreens().click();
	        assertEquals("http://localhost:" + port +"/screens.html", driver.getCurrentUrl());
	    }



	    @Test
	    public void testPlanningTripNav() {
	    	driver.get("http://localhost:" + port +"/index.html");
	        NavBarPage navigation = PageFactory.initElements(driver, NavBarPage.class);
	        assertEquals("PLANNING YOUR TRIP", navigation.getPlanningNav().getText());
	        navigation.getPlanningNav().click();
	        wait.until(ExpectedConditions.textToBePresentInElement(navigation.getGettingHere(),"Getting Here"));
	        navigation.getGettingHere().click();
	        assertEquals("http://localhost:" + port +"/gettingHere.html", driver.getCurrentUrl());
	    }


	    @Test
	    public void testPlanningToDoNav() {
	    	driver.get("http://localhost:" + port +"/index.html");
	        NavBarPage navigation = PageFactory.initElements(driver, NavBarPage.class);
	        assertEquals("PLANNING YOUR TRIP", navigation.getPlanningNav().getText());
	        navigation.getPlanningNav().click();
	        wait.until(ExpectedConditions.textToBePresentInElement(navigation.getWhatToDo(),"What To Do"));
	        navigation.getWhatToDo().click();
	        assertEquals("http://localhost:" + port +"/placesToGo.html", driver.getCurrentUrl());
	    }


	    @Test
	    public void testAboutNav() {
	    	driver.manage().window().maximize();
	    	driver.get("http://localhost:" + port +"/index.html");
	        NavBarPage navigation = PageFactory.initElements(driver, NavBarPage.class);
	        assertEquals("ABOUT", navigation.getAbout().getText());
	        navigation.getAbout().click();
	        assertEquals("http://localhost:" + port +"/about.html", driver.getCurrentUrl());
	    }


	    @Test
	    public void testExtendedContact() {
	    	driver.get("http://localhost:" + port +"/index.html");
	        NavBarPage navigation = PageFactory.initElements(driver, NavBarPage.class);
	        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"dropdownMenuMore\"]/i")));
	        navigation.getMore().click();
	        wait.until(ExpectedConditions.textToBePresentInElement(navigation.getContact(),"Contact Us"));
	        assertEquals("Contact Us", navigation.getContact().getText());
	        navigation.getContact().click();
	        assertEquals("http://localhost:" + port +"/contactUs.html", driver.getCurrentUrl());
	    }

}
