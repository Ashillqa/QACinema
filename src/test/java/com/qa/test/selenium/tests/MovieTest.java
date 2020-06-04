package com.qa.test.selenium.tests;

import static java.lang.Thread.sleep;
import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;

import java.util.concurrent.TimeUnit;

import com.qa.test.selenium.pages.GalleryPage;
import com.qa.test.selenium.pages.SearchPage;
import org.junit.*;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class MovieTest {

	JavascriptExecutor js = (JavascriptExecutor) driver;
	public static WebDriver driver;
	GalleryPage movieShow = PageFactory.initElements(driver, GalleryPage.class);
	WebDriverWait wait = new WebDriverWait(driver, 5);

	@LocalServerPort
    private int port;
	
	@BeforeClass
    public static void init() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        ChromeOptions opts = new ChromeOptions();
        opts.setHeadless(true);
        driver = new ChromeDriver(opts);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

	@Before
	public void apiBreaker() throws InterruptedException {
		sleep(5000);
	}
	
	@AfterClass
	 public static void teardown() {
		 driver.quit();
	 }
	
	 @Test 
	 public void ShowingBreadcrumbTest() throws InterruptedException{
		 driver.get("http://localhost:" + port +"/gallery.html");
		 assertEquals("Home",movieShow.getBreadcrumbHome().getText());
		 movieShow.getBreadcrumbHome().click();
		 assertTrue(driver.getCurrentUrl().contains("index.html")); 
	 }
	 
	 @Test
	 public void showingPlayClick() {
		 driver.get("http://localhost:" + port +"/gallery.html");
		 wait.until(ExpectedConditions.presenceOfElementLocated(By.id("play124"))).click();
		 assertTrue(driver.getCurrentUrl().contains("details2.html"));
	 }
	 
	 @Test
	 public void showingTitleClick() {
		 driver.get("http://localhost:" + port +"/gallery.html");
		 wait.until(ExpectedConditions.presenceOfElementLocated(By.id("title130"))).click();
		 assertTrue(driver.getCurrentUrl().contains("details2.html"));
	 }
	 
	 @Test
	 public void showingCertififClick() {
		 driver.get("http://localhost:" + port +"/gallery.html");
		 movieShow.getShowingClassif().click();
		 assertTrue(driver.getCurrentUrl().contains("classifications.html"));
	 }
	 
	 @Test
	 public void expectedPlayClick() {
		 driver.get("http://localhost:" + port +"/gallery.html");
		 wait.until(ExpectedConditions.presenceOfElementLocated(By.id("play130"))).click();
		 assertTrue(driver.getCurrentUrl().contains("details2.html"));
	 }
	 
	 @Test
	 public void expectedTitleClick() {
		 driver.get("http://localhost:" + port +"/gallery.html");
		 movieShow.getExpectedTitle().click();
		 assertTrue(driver.getCurrentUrl().contains("details2.html"));
	 }
	 
	 @Test
	 public void expectedCertififClick() {
		 driver.get("http://localhost:" + port +"/gallery.html");
		 movieShow.getExpectedClassif().click();
		 assertTrue(driver.getCurrentUrl().contains("classifications.html"));
	 }
	 
	 @Test
	 public void showMoreClickTest() {
		 driver.get("http://localhost:" + port +"/gallery.html");
		 wait.until(ExpectedConditions.presenceOfElementLocated(By.id("comingButton")));
		 movieShow.getShowMore().click();
		 assertTrue(driver.getCurrentUrl().contains("comingSoon.html"));
	 }

	@Test
	public void testRating() {
		driver.get("http://localhost:" + port + "/search.html");
		GalleryPage search = PageFactory.initElements(driver, GalleryPage.class);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("title129")));
		assertTrue(driver.findElement(By.id("title123")).isDisplayed());
		assertTrue(driver.findElement(By.id("title126")).isDisplayed());
		assertTrue(driver.findElement(By.id("title121")).isDisplayed());
		js.executeScript("document.getElementById(\"filter__imbd-end\").innerHTML = 8.0\n");
		search.getGenre().click();
		assertFalse(driver.findElement(By.id("title123")).isDisplayed());
		assertTrue(driver.findElement(By.id("title126")).isDisplayed());
		assertTrue(driver.findElement(By.id("title121")).isDisplayed());
		js.executeScript("document.getElementById(\"filter__imbd-start\").innerHTML = 7.0\n");
		search.getTerm().sendKeys(Keys.SPACE);
		assertFalse(driver.findElement(By.id("title123")).isDisplayed());
		assertFalse(driver.findElement(By.id("title121")).isDisplayed());
		assertTrue(driver.findElement(By.id("title126")).isDisplayed());


	}

	@Test
	public void testFilter() {
		driver.get("http://localhost:" + port + "/search.html");
		GalleryPage search = PageFactory.initElements(driver, GalleryPage.class);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("title129")));
		assertTrue(driver.findElement(By.id("title120")).isDisplayed());
		assertTrue(driver.findElement(By.id("title126")).isDisplayed());
		assertTrue(driver.findElement(By.id("title121")).isDisplayed());
		search.getTerm().sendKeys("dete");
		assertFalse(driver.findElement(By.id("title120")).isDisplayed());
		assertTrue(driver.findElement(By.id("title126")).isDisplayed());
		assertTrue(driver.findElement(By.id("title121")).isDisplayed());
		search.getTerm().sendKeys("ctive to");
		assertFalse(driver.findElement(By.id("title120")).isDisplayed());
		assertTrue(driver.findElement(By.id("title126")).isDisplayed());
		assertFalse(driver.findElement(By.id("title121")).isDisplayed());
	}

	@Test
	public void testRelease() {
		driver.get("http://localhost:" + port + "/search.html");
		GalleryPage search = PageFactory.initElements(driver, GalleryPage.class);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("title129")));
		assertTrue(driver.findElement(By.id("title122")).isDisplayed());
		assertTrue(driver.findElement(By.id("title120")).isDisplayed());
		assertTrue(driver.findElement(By.id("title121")).isDisplayed());
		js.executeScript("document.getElementById(\"filter__years-end\").innerHTML =\"2018\"\n");
		search.getGenre().click();
		assertFalse(driver.findElement(By.id("title122")).isDisplayed());
		assertTrue(driver.findElement(By.id("title120")).isDisplayed());
		assertTrue(driver.findElement(By.id("title121")).isDisplayed());
		js.executeScript("document.getElementById(\"filter__years-start\").innerHTML = \"2012\"\n");
		search.getTerm().sendKeys(Keys.SPACE);
		assertFalse(driver.findElement(By.id("title122")).isDisplayed());
		assertTrue(driver.findElement(By.id("title120")).isDisplayed());
		assertFalse(driver.findElement(By.id("title121")).isDisplayed());
	}

}
