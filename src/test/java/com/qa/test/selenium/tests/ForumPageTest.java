package com.qa.test.selenium.tests;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
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

import com.qa.test.selenium.pages.ForumPage;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ForumPageTest {
	
	public static WebDriver driver;
	ForumPage forum = PageFactory.initElements(driver, ForumPage.class);
	WebDriverWait wait = new WebDriverWait(driver, 5);
	public static ExtentHtmlReporter reporter = new ExtentHtmlReporter("Reports/Forum.html");
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
		sleep(1000);
	}
	
	@AfterClass
	 public static void teardown() {
		 driver.quit();
		extent.flush();
	 }
	
	@Test
	public void postComment() throws InterruptedException {
		logger=extent.createTest("Post Comment");
		driver.get("http://localhost:" + port +"/forum.html");
		assertEquals("Name",forum.getUsername().getAttribute("placeholder"));
		forum.getTitleOption().click();
		apiBreaker();
		forum.getMovieOption5().click();
		forum.getUsername().sendKeys("Ashill101");
		forum.getStars().click();
		apiBreaker();
		assertEquals("Add comment",forum.getPostComment().getAttribute("placeholder"));
		forum.getPostComment().sendKeys("My test comment");
		apiBreaker();
		assertEquals("send".toUpperCase(),forum.getComButton().getText());
		forum.getComButton().click();
		apiBreaker();
		
	}
	
	@Test
	public void readCommentAfterPost() throws InterruptedException {
		logger=extent.createTest("Read Comment");
		driver.get("http://localhost:" + port +"/forum.html");
		assertEquals("Name",forum.getUsername().getAttribute("placeholder"));
		forum.getTitleOption().click();
		apiBreaker();
		forum.getMovieOption5().click();
		forum.getUsername().sendKeys("Ashill102");
		forum.getStars().click();
		apiBreaker();
		assertEquals("Add comment",forum.getPostComment().getAttribute("placeholder"));
		forum.getPostComment().sendKeys("My next comment");
		apiBreaker();
		assertEquals("send".toUpperCase(),forum.getComButton().getText());
		forum.getComButton().click();
		apiBreaker();
		assertFalse(forum.getResultComment().getText().isEmpty());
	}
	
	@Test
	public void inappropriateAlertUserName() throws InterruptedException {
		logger=extent.createTest("Swearword catch");
		driver.get("http://localhost:" + port +"/forum.html");
		assertEquals("Name",forum.getUsername().getAttribute("placeholder"));
		forum.getTitleOption().click();
		apiBreaker();
		forum.getMovieOption5().click();
		forum.getUsername().sendKeys("#generic swear word");
		forum.getStars().click();
		apiBreaker();
		assertEquals("Add comment",forum.getPostComment().getAttribute("placeholder"));
		forum.getPostComment().sendKeys("My next comment");
		apiBreaker();
		assertEquals("send".toUpperCase(),forum.getComButton().getText());
		forum.getComButton().click();
		wait.until(ExpectedConditions.alertIsPresent());
		assertTrue(driver.switchTo().alert().getText().contains("The message will not be sent!!!"));
		driver.switchTo().alert().accept();
		
	}
	
	@Test
	public void inappropriateAlertComment() throws InterruptedException {
		logger=extent.createTest("Swearword Alert");
		driver.get("http://localhost:" + port +"/forum.html");
		assertEquals("Name",forum.getUsername().getAttribute("placeholder"));
		forum.getTitleOption().click();
		apiBreaker();
		forum.getMovieOption5().click();
		forum.getUsername().sendKeys("Ashill");
		forum.getStars().click();
		apiBreaker();
		assertEquals("Add comment",forum.getPostComment().getAttribute("placeholder"));
		forum.getPostComment().sendKeys("#generic swear word");
		apiBreaker();
		assertEquals("send".toUpperCase(),forum.getComButton().getText());
		forum.getComButton().click();
		wait.until(ExpectedConditions.alertIsPresent());
		assertTrue(driver.switchTo().alert().getText().contains("The message will not be sent!!!"));
		driver.switchTo().alert().accept();
		
	}
	
	
}
