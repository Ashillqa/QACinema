package com.qa.test.selenium.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import com.qa.test.selenium.pages.DetailsPage;
import com.qa.test.selenium.pages.GalleryPage;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class DetailsPageTest {
	
	public static WebDriver driver;
	private final WebDriverWait wait = new WebDriverWait(driver, 2);
	GalleryPage gallery = PageFactory.initElements(driver, GalleryPage.class);
	DetailsPage details = PageFactory.initElements(driver, DetailsPage.class);
	public static ExtentHtmlReporter reporter = new ExtentHtmlReporter("Reports/Details.html");
	public static ExtentReports extent = new ExtentReports();
	ExtentTest logger;
	  
	 @LocalServerPort
	 private int port;

	    @BeforeClass
	    public static void init() {
	        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	        ChromeOptions opts = new ChromeOptions();
	        opts.setHeadless(true);
	        driver = new ChromeDriver(opts);
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	        driver.manage().window().maximize();
			extent.attachReporter(reporter);
	    }
	    
	    @AfterClass
		public static void teardown() {
			 driver.quit();
			 extent.flush();
		 }
	    
	    @Test
	    public void detailsHDClick() {
			logger=extent.createTest("Screen Link");
	    	driver.get("http://localhost:" + port +"/gallery.html");
	    	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("title130")));
	    	String title = gallery.getComingTitle().getText();
	    	gallery.getComingTitle().click();
	    	assertTrue(driver.getCurrentUrl().contains("details2.html"));
	    	wait.until(ExpectedConditions.textToBePresentInElement(details.getTitle(), title));
	    	assertEquals(details.getTitle().getText(),title);
	    	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("screens")));
	    	details.getHdButton().click();
	    	assertTrue(driver.getCurrentUrl().contains("screens.html"));
	    }
		 
	    @Test
	    public void detailsAgeRateClick() {
			logger=extent.createTest("Classif Link");
	    	driver.get("http://localhost:" + port +"/gallery.html");
	    	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("title130")));
	    	String title = gallery.getComingTitle().getText();
	    	gallery.getComingTitle().click();
	    	assertTrue(driver.getCurrentUrl().contains("details2.html"));
	    	wait.until(ExpectedConditions.textToBePresentInElement(details.getTitle(), title));
	    	assertEquals(details.getTitle().getText(),title);
	    	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("ageRating")));
	    	details.getAge().click();
	    	assertTrue(driver.getCurrentUrl().contains("classifications.html"));
	    }
	    
	    @Test
	    public void detailsBookingClick() {
			logger=extent.createTest("Booking Link");
	    	driver.get("http://localhost:" + port +"/gallery.html");
	    	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("title130")));
	    	String title = gallery.getComingTitle().getText();
	    	gallery.getComingTitle().click();
	    	assertTrue(driver.getCurrentUrl().contains("details2.html"));
	    	wait.until(ExpectedConditions.textToBePresentInElement(details.getTitle(), title));
	    	assertEquals(details.getTitle().getText(),title);
	    	details.getBookButton().click();
	    	assertTrue(driver.getCurrentUrl().contains("bookings2.html"));

	    }

}
