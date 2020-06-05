package com.qa.test.selenium.tests;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.*;
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

import com.qa.test.selenium.pages.ComingSoon;
import com.qa.test.selenium.pages.SearchPage;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class MovieComingTest {
	
	public static WebDriver driver;
	private WebDriverWait wait = new WebDriverWait(driver, 10);
	ComingSoon movieComing = PageFactory.initElements(driver, ComingSoon.class);
	public static ExtentHtmlReporter reporter = new ExtentHtmlReporter("Reports/comingMovies.html");
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
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
		extent.attachReporter(reporter);

        
    }

	@Before
	public void apiBreaker() throws InterruptedException {
		sleep(8000);
	}
	
	@AfterClass
	 public static void teardown() {
		 driver.quit();
		extent.flush();
	 }
	
	@Test
	public void ComingSoonBreadcrumbTest() {
		logger=extent.createTest("BreadCrumb Link");
		 driver.get("http://localhost:" + port +"/comingSoon.html");
		 assertEquals("Home",movieComing.getBreadcrumbHome().getText());
//		 wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.id("homeBread")), "Home"));
		 movieComing.getBreadcrumbHome().click();
		 assertTrue(driver.getCurrentUrl().contains("index.html"));
		 
	}
	
	@Test
	public void comingSoonClickTitleTest() {
		logger=extent.createTest("Title Link");
		driver.get("http://localhost:" + port +"/comingSoon.html");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("title130"))).click();
//		movieComing.getComingTitle().click();
		assertTrue(driver.getCurrentUrl().contains("details2.html?title=The%20SpongeBob"));
	}
	
	@Test
	public void comingSoonClickPlay() {
		logger=extent.createTest("Play Link");
		driver.get("http://localhost:" + port +"/comingSoon.html");
//		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("play130"))).click();
		movieComing.getComingPlay().click();
		assertTrue(driver.getCurrentUrl().contains("details2.html?title=The%20SpongeBob"));
	}
	


	@Test
	public void comingSoonClickReset() {
		logger=extent.createTest("Reset Link");
		driver.get("http://localhost:" + port +"/comingSoon.html");
		assertEquals("reset".toUpperCase(),movieComing.getResetButton().getText());
	}
}
