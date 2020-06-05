package com.qa.test.selenium.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
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

import static java.lang.Thread.sleep;

import com.qa.test.selenium.pages.ClassificationsPage;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ClassificationPageTest {
	
	public static WebDriver driver;
	private final WebDriverWait wait = new WebDriverWait(driver, 2);
	ClassificationsPage ageRate = PageFactory.initElements(driver, ClassificationsPage.class);
	public static ExtentHtmlReporter reporter = new ExtentHtmlReporter("Reports/Classifications.html");
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
	    public void testClassificationTitle() {
			logger=extent.createTest("Title Correct");
	    	driver.get("http://localhost:" + port +"/classifications.html");
	    	wait.until(ExpectedConditions.presenceOfElementLocated(By.className("section__title")));
	    	assertEquals("Classifications",ageRate.getTitle().getText());
	    }
	    
	    @Test
	    public void testTBCRedirect() throws InterruptedException {
			logger=extent.createTest("TBC Link");
	    	driver.get("http://localhost:" + port +"/classifications.html");
	    	sleep(1000);
	    	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("tbcLink")));
	    	assertEquals("To Be Confirmed",ageRate.getTbc().getText());
	    	ageRate.getTbc().click();
	    	sleep(1000);
	    	ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	    	int place=tabs2.size();
	    	driver.switchTo().window(tabs2.get(place-1));
	    	assertTrue(driver.getCurrentUrl().contains("additional-information"));
	    	//driver.close();
	    //	driver.switchTo().window(tabs2.get(0));
	    //	sleep(1000);
	    }
	    
	   
	    
	    @Test
	    public void testParentalRedirect() throws InterruptedException {
			logger=extent.createTest("PG Link");
	    	driver.get("http://localhost:" + port +"/classifications.html");
	    	sleep(1000);
	    	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("pgLink")));
	    	assertEquals("Parental Guidance",ageRate.getParental().getText());
	    	ageRate.getParental().click();
	    	sleep(1000);
	    	ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	    	int place = tabs2.size();
	    	driver.switchTo().window(tabs2.get(place-1));
	    	assertTrue(driver.getCurrentUrl().contains("about-classification/pg"));
	    	//driver.close();
	    	//driver.switchTo().window(tabs2.get(0));
	    //	sleep(1000);
	    }
	    
	    @Test
	    public void testTwelveRedirect() throws InterruptedException {
			logger=extent.createTest("12 Link");
	    	driver.get("http://localhost:" + port +"/classifications.html");
	    	sleep(1000);
	    	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("TwelveLink")));
	    	assertEquals("Rated 12A",ageRate.getTwelve().getText());
	    	ageRate.getTwelve().click();
	    	sleep(1000);
	    	ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	    	int place = tabs2.size();
	    	driver.switchTo().window(tabs2.get(place-1));
	    	assertTrue(driver.getCurrentUrl().contains("about-classification/12a"));
	   // 	driver.close();
	    //	driver.switchTo().window(tabs2.get(0));
	    //	sleep(1000);
	    }
	    
	    @Test
	    public void testFifteenRedirect() throws InterruptedException {
			logger=extent.createTest("15 Link");
	    	driver.get("http://localhost:" + port +"/classifications.html");
	    	sleep(1000);
	    	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("fifteenLink")));
	    	assertEquals("Rated 15",ageRate.getFifteen().getText());
	    	ageRate.getFifteen().click();
	    	sleep(1000);
	    	ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	    	int place = tabs2.size();
	    	driver.switchTo().window(tabs2.get(place-1));
	    	assertTrue(driver.getCurrentUrl().contains("about-classification/15"));
	    	//driver.close();
	    //	driver.switchTo().window(tabs2.get(0));
	    //	sleep(1000);
	    }
	    
	    @Test
	    public void testEighteenRedirect() throws InterruptedException {
			logger=extent.createTest("18 Link");
	    	driver.get("http://localhost:" + port +"/classifications.html");
	    	sleep(1000);
	    	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("eighteenLink")));
	    	assertEquals("Rated 18",ageRate.getEighteen().getText());
	    	ageRate.getEighteen().click();
	    	sleep(1000);
	    	ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	    	int place = tabs2.size();
	    	driver.switchTo().window(tabs2.get(place-1));
	    	assertEquals("https://www.bbfc.co.uk/about-classification/18",driver.getCurrentUrl());
	   // 	driver.close();
	   // 	driver.switchTo().window(tabs2.get(0));
	    //	sleep(1000);
	        }
	    @Test
	    public void testUniversalRedirect() throws InterruptedException {
			logger=extent.createTest("Universal Link");
	    	driver.get("http://localhost:" + port +"/classifications.html");
	    	sleep(1000);
	    	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"ULink\"]")));
	    	assertEquals("Universal",ageRate.getUniversal().getText());
	    	ageRate.getUniversal().click();
	    	sleep(1000);
	    	ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	    	int place = tabs2.size();
	    	driver.switchTo().window(tabs2.get(place-1));
	    	assertTrue(driver.getCurrentUrl().contains("about-classification/u"));
	    //	driver.close();
	    //	driver.switchTo().window(tabs2.get(0));
	   // 	sleep(1000);
	    }
	        
	    	//wait.until(ExpectedConditions.urlMatches("https://www.bbfc.co.uk/about-classification/18"));
	    	//assertEquals("https://www.bbfc.co.uk/about-classification/18",driver.getCurrentUrl());
	    
}

