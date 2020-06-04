package com.qa.test.selenium.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import com.qa.test.selenium.pages.HomePage;
import com.qa.test.selenium.pages.MovieShowingPage;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class MovieTest {
	
	public static WebDriver driver;
	
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
	 public void ShowingBreadcrumbTest() throws InterruptedException{
		 driver.get("http://localhost:" + port +"/gallery.html");
		 MovieShowingPage movieShow = PageFactory.initElements(driver, MovieShowingPage.class);
		 //sleep(3000);
		 assertEquals("Home",movieShow.getBreadcrumbHome().getText());
		 movieShow.getBreadcrumbHome().click();
		 assertTrue(driver.getCurrentUrl().contains("index.html")); 
	 }
	 
	 @Test
	 public void showingPlayClick() {
		 driver.get("http://localhost:" + port +"/gallery.html");
		 MovieShowingPage movieShow = PageFactory.initElements(driver, MovieShowingPage.class);
		 movieShow.getShowingPlay().click();
		 assertTrue(driver.getCurrentUrl().contains("details2.html"));
	 }
	 
	 @Test
	 public void showingTitleClick() {
		 driver.get("http://localhost:" + port +"/gallery.html");
		 MovieShowingPage movieShow = PageFactory.initElements(driver, MovieShowingPage.class);
		 movieShow.getShowingTitle().click();
		 assertTrue(driver.getCurrentUrl().contains("details2.html"));
	 }
	 
	 @Test
	 public void showingCertififClick() {
		 driver.get("http://localhost:" + port +"/gallery.html");
		 MovieShowingPage movieShow = PageFactory.initElements(driver, MovieShowingPage.class);
		 movieShow.getShowingClassif().click();
		 assertTrue(driver.getCurrentUrl().contains("classifications.html"));
	 }
	 
	 @Test
	 public void expectedPlayClick() {
		 driver.get("http://localhost:" + port +"/gallery.html");
		 MovieShowingPage movieShow = PageFactory.initElements(driver, MovieShowingPage.class);
		 movieShow.getExpectedPlay().click();
		 assertTrue(driver.getCurrentUrl().contains("details2.html"));
	 }
	 
	 @Test
	 public void expectedTitleClick() {
		 driver.get("http://localhost:" + port +"/gallery.html");
		 MovieShowingPage movieShow = PageFactory.initElements(driver, MovieShowingPage.class);
		 movieShow.getExpectedTitle().click();
		 assertTrue(driver.getCurrentUrl().contains("details2.html"));
	 }
	 
	 @Test
	 public void expectedCertififClick() {
		 driver.get("http://localhost:" + port +"/gallery.html");
		 MovieShowingPage movieShow = PageFactory.initElements(driver, MovieShowingPage.class);
		 movieShow.getExpectedClassif().click();
		 assertTrue(driver.getCurrentUrl().contains("classifications.html"));
	 }
	 
	 @Test
	 public void showMoreClickTest() {
		 driver.get("http://localhost:" + port +"/gallery.html");
		 MovieShowingPage movieShow = PageFactory.initElements(driver, MovieShowingPage.class);
		 movieShow.getShowMore().click();
		 assertTrue(driver.getCurrentUrl().contains("comingSoon.html"));
	 }

}
