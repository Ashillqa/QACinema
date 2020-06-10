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
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class NavBarPageTest {

	  public static WebDriver driver;
	  private final WebDriverWait wait = new WebDriverWait(driver, 4);
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  public static ExtentHtmlReporter reporter = new ExtentHtmlReporter("Reports/NavBar.html");
	  public static ExtentReports extent = new ExtentReports();
	  ExtentTest logger;

	    @LocalServerPort
	    private int port;

	    @BeforeClass
	    public static void init() throws InterruptedException {
	        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	        ChromeOptions opts = new ChromeOptions();
	        opts.setHeadless(true);
	        driver = new ChromeDriver(opts);
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	        driver.manage().window().maximize();
			extent.attachReporter(reporter);

	    }

		@Before
		public void apiBreaker() throws InterruptedException {
			sleep(1000);
		}

	    @AfterClass
	    public static void teardown() {
	        driver.quit();
	        extent.flush();
	    }


	    @Test
	    public void testMoviesShowingNav() throws InterruptedException {
			logger=extent.createTest("Showing Movies Link");
	        driver.get("http://localhost:" + port +"/index.html");
	        NavBarPage navigation = PageFactory.initElements(driver, NavBarPage.class);
			navigation.getMenu().click();
			wait.until(ExpectedConditions.elementToBeClickable(By.id("dropdownMenuCatalog")));
	        navigation.getMovieNav().click();
			wait.until(ExpectedConditions.elementToBeClickable(By.id("showing")));
	        navigation.getShowing().click();
	        wait.until(ExpectedConditions.urlContains("gallery.html"));
	        assertEquals("http://localhost:" + port +"/gallery.html", driver.getCurrentUrl());

	    }

	    @Test
	    public void testSearchNav() throws InterruptedException {
			logger=extent.createTest("Search Bar Link");
	    	driver.get("http://localhost:" + port +"/index.html");
	    	NavBarPage navigation = PageFactory.initElements(driver, NavBarPage.class);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("search")));
			js.executeScript("document.getElementById(`search`).click();");
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("searchButton")));
			js.executeScript("document.getElementById(`searchButton`).click();");
	    	assertEquals("http://localhost:" + port +"/search.html?term=", driver.getCurrentUrl());
	    }


	    @Test
	    public void testMoviesComingNav() {
			logger=extent.createTest("Coming Movies Link");
	        driver.get("http://localhost:" + port +"/index.html");
	        NavBarPage navigation = PageFactory.initElements(driver, NavBarPage.class);
			navigation.getMenu().click();
			wait.until(ExpectedConditions.elementToBeClickable(By.id("dropdownMenuCatalog")));
	        navigation.getMovieNav().click();
			wait.until(ExpectedConditions.elementToBeClickable(By.id("coming")));
	        navigation.getComing().click();
	        assertEquals("http://localhost:" + port +"/comingSoon.html", driver.getCurrentUrl());
	    }



	    @Test
	    public void testScreensNav() {
			logger=extent.createTest("Screens Link");
	        driver.get("http://localhost:" + port +"/index.html");
	        NavBarPage navigation = PageFactory.initElements(driver, NavBarPage.class);
			navigation.getMenu().click();
			wait.until(ExpectedConditions.elementToBeClickable(By.id("screens")));
	        navigation.getScreens().click();
	        assertEquals("http://localhost:" + port +"/screens.html", driver.getCurrentUrl());
	    }



	    @Test
	    public void testPlanningTripNav() {
			logger=extent.createTest("Planning Trip Link");
	    	driver.get("http://localhost:" + port +"/index.html");
	        NavBarPage navigation = PageFactory.initElements(driver, NavBarPage.class);
			navigation.getMenu().click();
			wait.until(ExpectedConditions.elementToBeClickable(By.id("dropdownMenuCatalog1")));
			navigation.getPlanningNav().click();
			wait.until(ExpectedConditions.elementToBeClickable(By.id("gettingHere")));
	        navigation.getGettingHere().click();
	        assertEquals("http://localhost:" + port +"/gettingHere.html", driver.getCurrentUrl());
	    }


	    @Test
	    public void testPlanningToDoNav() {
			logger=extent.createTest("Things to do Link");
	    	driver.get("http://localhost:" + port +"/index.html");
	        NavBarPage navigation = PageFactory.initElements(driver, NavBarPage.class);
			navigation.getMenu().click();
			wait.until(ExpectedConditions.elementToBeClickable(By.id("dropdownMenuCatalog1")));
	        navigation.getPlanningNav().click();
			wait.until(ExpectedConditions.elementToBeClickable(By.id("whatToDo")));
	        navigation.getWhatToDo().click();
	        assertEquals("http://localhost:" + port +"/placesToGo.html", driver.getCurrentUrl());
	    }


	    @Test
	    public void testAboutNav() {
			logger=extent.createTest("About Page Link");
	    	driver.manage().window().maximize();
	    	driver.get("http://localhost:" + port +"/index.html");
	        NavBarPage navigation = PageFactory.initElements(driver, NavBarPage.class);
			navigation.getMenu().click();
			wait.until(ExpectedConditions.elementToBeClickable(By.id("about")));
	        navigation.getAbout().click();
	        assertEquals("http://localhost:" + port +"/about.html", driver.getCurrentUrl());
	    }


	    @Test
	    public void testExtendedContact() {
			logger=extent.createTest("Contact Link");
	    	driver.get("http://localhost:" + port +"/index.html");
	        NavBarPage navigation = PageFactory.initElements(driver, NavBarPage.class);
			navigation.getMenu().click();
			wait.until(ExpectedConditions.elementToBeClickable(By.id("dropdownMenuMore")));
	        navigation.getSeeMore().click();
			wait.until(ExpectedConditions.elementToBeClickable(By.id("contact")));
	        navigation.getContact().click();
	        assertEquals("http://localhost:" + port +"/contactUs.html", driver.getCurrentUrl());
	    }

}
