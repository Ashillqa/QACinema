package com.qa.test.selenium.tests;

import static org.junit.Assert.assertEquals;

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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import static java.lang.Thread.sleep;



import com.qa.test.selenium.pages.NavBarPage;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class NavBarPageTest {
	
	  public static WebDriver driver;

	    @LocalServerPort
	    private int port;

	    @BeforeClass
	    public static void init() {
	        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	        ChromeOptions opts = new ChromeOptions();
	        //opts.setHeadless(true);
	        driver = new ChromeDriver(opts);
			//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	        driver.manage().window().maximize();
	    }
	    
	    @AfterClass
	    public static void teardown() {
	        driver.quit();
	    }
	    
	    
	    
	    @Test
	    public void testMoviesShowingNav() throws InterruptedException {
	        driver.get("http://localhost:" + port +"/index.html");
	        NavBarPage navigation = PageFactory.initElements(driver, NavBarPage.class);
	        WebDriverWait wait = new WebDriverWait(driver, 2);
	        sleep(2000);
	        assertEquals("movies".toUpperCase(),navigation.getMovieNav().getText());
	        navigation.getMovieNav().click();
	        wait.until(ExpectedConditions.elementToBeClickable(By.id("showing")));
	        assertEquals("Showing",navigation.getShowing().getText());
	        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("showing")));
	        navigation.getShowing().click();
	        assertEquals("http://localhost:" + port +"/gallery.html", driver.getCurrentUrl());
	     
	    }
	    
	    @Test
	    public void testSearchNav() throws InterruptedException {
	    	driver.get("http://localhost:" + port +"/index.html");
	    	NavBarPage navigation = PageFactory.initElements(driver, NavBarPage.class);
	    	WebDriverWait wait = new WebDriverWait(driver, 2);
	    	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("search")));
	    	navigation.getSearch().click();
	    	sleep(2000);
	    	navigation.getSearchMain().click();
	    	assertEquals("http://localhost:" + port +"/search.html?term=", driver.getCurrentUrl());
	    }


	    
	    @Test
	    public void testMoviesComingNav() {
	        driver.get("http://localhost:" + port +"/index.html");
	        NavBarPage navigation = PageFactory.initElements(driver, NavBarPage.class);
	        WebDriverWait wait = new WebDriverWait(driver, 2);
	        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"dropdownMenuCatalog\"]")));
	        assertEquals("movies".toUpperCase(),navigation.getMovieNav().getText());
	        navigation.getMovieNav().click();	        
	        wait.until(ExpectedConditions.elementToBeClickable(By.id("coming")));
	        assertEquals("Coming Soon",navigation.getComing().getText());
	        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("coming")));
	        navigation.getComing().click();
	        assertEquals("http://localhost:" + port +"/comingSoon.html", driver.getCurrentUrl());
	    }
	    

	    
	    @Test
	    public void testScreensNav() {
	        driver.get("http://localhost:" + port +"/index.html");
	        NavBarPage navigation = PageFactory.initElements(driver, NavBarPage.class);
	        WebDriverWait wait = new WebDriverWait(driver, 2);
	        assertEquals("SCREENS", navigation.getScreens().getText());
	        navigation.getScreens().click();	        
	        
	        assertEquals("http://localhost:" + port +"/screens.html", driver.getCurrentUrl());
	    }


	    
	    @Test
	    public void testPlanningTripNav() {
	    	driver.get("http://localhost:" + port +"/index.html");
	        NavBarPage navigation = PageFactory.initElements(driver, NavBarPage.class);
	        WebDriverWait wait = new WebDriverWait(driver, 2);
	        assertEquals("PLANNING YOUR TRIP", navigation.getPlanningNav().getText());
	        navigation.getPlanningNav().click();	        
	        wait.until(ExpectedConditions.elementToBeClickable(By.id("gettingHere")));;
	        assertEquals("Getting Here",navigation.getGettingHere().getText());
	        navigation.getGettingHere().click();
	        assertEquals("http://localhost:" + port +"/gettingHere.html", driver.getCurrentUrl());
	    }

	    
	    @Test
	    public void testPlanningToDoNav() {
	    	driver.get("http://localhost:" + port +"/index.html");
	        NavBarPage navigation = PageFactory.initElements(driver, NavBarPage.class);
	        WebDriverWait wait = new WebDriverWait(driver, 2);
	        assertEquals("PLANNING YOUR TRIP", navigation.getPlanningNav().getText());
	        navigation.getPlanningNav().click();	     
	        wait.until(ExpectedConditions.elementToBeClickable(By.id("whatToDo")));
	        assertEquals("What To Do",navigation.getWhatToDo().getText());
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
	        WebDriverWait wait = new WebDriverWait(driver, 2);
	        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"dropdownMenuMore\"]/i")));
	        navigation.getMore().click();	
	        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("contact")));
	        assertEquals("Contact Us", navigation.getContact().getText());
	        navigation.getContact().click();
	        assertEquals("http://localhost:" + port +"/contactUs.html", driver.getCurrentUrl());
	    }
	    
}
