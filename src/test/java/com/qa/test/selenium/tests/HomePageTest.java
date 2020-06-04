package com.qa.test.selenium.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static java.lang.Thread.sleep;

import com.qa.test.selenium.pages.HomePage;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HomePageTest {
	
	public static WebDriver driver;
	HomePage home = PageFactory.initElements(driver, HomePage.class);
	WebDriverWait wait = new WebDriverWait(driver, 5);
	
	 @LocalServerPort
	 private int port;
	 
	 @BeforeClass
	    public static void init() {
	        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	        ChromeOptions opts = new ChromeOptions();
	        opts.setHeadless(true);
	        driver = new ChromeDriver(opts);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	        driver.manage().window().maximize();
	       
	    }
	 
	 @AfterClass
	 public static void teardown() {
		 driver.quit();
	 }
	 
	 @Test
	 public void FeaturedMovieAppearsTest() {
		 driver.get("http://localhost:" + port +"/index.html");
		 assertEquals("featured movies".toUpperCase(),home.getFeatureFilm().getText());
		 
	 }
	 
	 @Test
	 public void ComingSoonAppearsTest() {
		 driver.get("http://localhost:" + port +"/index.html");
		 assertEquals("coming soon".toUpperCase(),home.getComingSoon().getText());
	 }
	 
	 @Test 
	 public void FeaturedPlayClick() throws InterruptedException{
		 driver.get("http://localhost:" + port +"/index.html");
		 wait.until(ExpectedConditions.presenceOfElementLocated(By.id("play124"))).click();
		 assertTrue(driver.getCurrentUrl().contains("details2.html")); 
	 }
	 
	 @Test
	 public void ComingSoonClickTest() throws InterruptedException {
		 driver.get("http://localhost:" + port +"/index.html");
		 wait.until(ExpectedConditions.presenceOfElementLocated(By.id("play130"))).click();
		 assertTrue(driver.getCurrentUrl().contains("details2.html"));
	 }
	 
	 @Test
	 public void featuredTitleClick() throws InterruptedException {
		 driver.get("http://localhost:" + port +"/index.html");
		 home.getFeatureTitle().click();
		 assertTrue(driver.getCurrentUrl().contains("details2.html"));
	 }
	 
	 @Test
	 public void ComingTitleClick() {
		 driver.get("http://localhost:" + port +"/index.html");
		 home.getSoonTitle().click();
		 assertTrue(driver.getCurrentUrl().contains("details2.html"));
	 }
	    
	 @Test
	 public void featuredClassificationClick() throws InterruptedException {
		 driver.get("http://localhost:" + port +"/index.html");
		 wait.until(ExpectedConditions.elementToBeClickable(home.getFeatureClassif())).click();
		 assertEquals("http://localhost:" + port +"/classifications.html", driver.getCurrentUrl());
	 }
	 
	 @Test
	 public void SoonClassificationClick() throws InterruptedException {
		 driver.get("http://localhost:" + port +"/index.html");
		 wait.until(ExpectedConditions.elementToBeClickable(home.getSoonClassif())).click();
		 assertEquals("http://localhost:" + port +"/classifications.html", driver.getCurrentUrl());
	 }
	 

}
