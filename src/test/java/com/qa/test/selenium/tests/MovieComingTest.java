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

import com.qa.test.selenium.pages.MovieShowingPage;
import com.qa.test.selenium.pages.SearchPage;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class MovieComingTest {
	
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
	public void ComingSoonBreadcrumbTest() {
		
			 driver.get("http://localhost:" + port +"/comingSoon.html");
			 MovieShowingPage movieComing = PageFactory.initElements(driver, MovieShowingPage.class);
			 //sleep(3000);
			 assertEquals("Home",movieComing.getBreadcrumbHome().getText());
			 movieComing.getBreadcrumbHome().click();
			 assertTrue(driver.getCurrentUrl().contains("index.html")); 
		 
	}
	
	@Test
	public void comingSoonClickTitleTest() {
		driver.get("http://localhost:" + port +"/comingSoon.html");
		MovieShowingPage movieComing = PageFactory.initElements(driver, MovieShowingPage.class);
		assertTrue(movieComing.getShowingTitle().getText().contains("The SpongeBob"));
		movieComing.getShowingTitle().click();
		assertTrue(driver.getCurrentUrl().contains("details2.html"));
	}
	
	@Test
	public void comingSoonClickPlay() {
		driver.get("http://localhost:" + port +"/comingSoon.html");
		MovieShowingPage movieComing = PageFactory.initElements(driver, MovieShowingPage.class);
		movieComing.getExpectedPlay().click();
		assertTrue(driver.getCurrentUrl().contains("details2.html"));
	}
	
	@Test
	public void comingSoonClickClassif() {
		driver.get("http://localhost:" + port +"/comingSoon.html");
		MovieShowingPage movieComing = PageFactory.initElements(driver, MovieShowingPage.class);
		movieComing.getShowingClassif().click();
		assertTrue(driver.getCurrentUrl().contains("classifications.html"));
	}
	
	@Test
	public void comingSoonClickReset() {
		driver.get("http://localhost:" + port +"/comingSoon.html");
		SearchPage resetbut = PageFactory.initElements(driver, SearchPage.class);
		assertEquals("reset".toUpperCase(),resetbut.getResetButton().getText());
	}
}