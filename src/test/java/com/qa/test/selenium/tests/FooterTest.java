package com.qa.test.selenium.tests;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.hibernate.jdbc.Expectations;
import org.junit.*;
import org.junit.runner.RunWith;
import org.openqa.selenium.JavascriptExecutor;
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

import com.qa.test.selenium.pages.FooterPage;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class FooterTest {
	
	public static WebDriver driver;
	JavascriptExecutor js = (JavascriptExecutor) driver;
	WebDriverWait wait = new WebDriverWait(driver, 5);
	FooterPage footer = PageFactory.initElements(driver, FooterPage.class);
	public static ExtentHtmlReporter reporter = new ExtentHtmlReporter("Reports/Footer.html");
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
		sleep(2000);
	}
	
	@AfterClass
	public static void teardown() {
		 driver.quit();
		 extent.flush();
	 }
	
	@Test
	public void FooterAboutTest() throws InterruptedException {
		logger=extent.createTest("About Link");
		driver.get("http://localhost:" + port +"/index.html");
		assertEquals("About", footer.getAboutPage().getText());
		footer.getAboutPage().click();
		assertEquals("http://localhost:" + port +"/about.html", driver.getCurrentUrl());
		
	}
	
	@Test
	public void FooterContactTest() throws InterruptedException {
		logger=extent.createTest("Contact Link");
		driver.get("http://localhost:" + port +"/index.html");
		assertEquals("Contact Us", footer.getContactPage().getText());
		footer.getContactPage().click();
		assertEquals("http://localhost:" + port +"/contactUs.html", driver.getCurrentUrl());
		
	}
	
	@Test
	public void FooterHomeTest() throws InterruptedException {
		logger=extent.createTest("Home Link");
		driver.get("http://localhost:" + port +"/index.html");
		assertEquals("Home", footer.getHome().getText());
		footer.getHome().click();
		assertEquals("http://localhost:" + port +"/index.html", driver.getCurrentUrl());
	}
	
	@Test
	public void FooterTermsTest() throws InterruptedException {
		logger=extent.createTest("Terms Link");
		driver.get("http://localhost:" + port +"/index.html");
		assertEquals("Terms of Use", footer.getTerms404().getText());
		footer.getTerms404().click();
		assertEquals("http://localhost:" + port +"/404.html", driver.getCurrentUrl());
	}
	
	@Test
	public void FooterPrivacyTest() throws InterruptedException {
		logger=extent.createTest("Privacy Link");
		driver.get("http://localhost:" + port +"/index.html");
		assertEquals("Privacy Policy", footer.getPrivacy404().getText());
		footer.getPrivacy404().click();
		assertEquals("http://localhost:" + port +"/404.html", driver.getCurrentUrl());
	}
	
	@Test
	public void FooterSecurityTest() throws InterruptedException {
		logger=extent.createTest("Security Link");
		driver.get("http://localhost:" + port +"/index.html");
		assertEquals("Security", footer.getSecurity404().getText());
		footer.getSecurity404().click();
		js.executeScript("");
		assertEquals("http://localhost:" + port +"/404.html", driver.getCurrentUrl());
	}
	
	@Test
	public void FooterNumberLinkTest() throws InterruptedException {
		logger=extent.createTest("Number Link");
		driver.get("http://localhost:" + port +"/index.html");
		assertEquals("0161 393 2271", footer.getNumberLink().getText());
		footer.getNumberLink().click();
		assertEquals("http://localhost:" + port +"/contactUs.html", driver.getCurrentUrl());
	}
	
	@Test
	public void FooterEmailLinkTest() throws InterruptedException {
		logger=extent.createTest("Email Link");
		driver.get("http://localhost:" + port +"/index.html");
		assertEquals("qacinema.jobs@gmail.com", footer.getEmailLink().getText());
		footer.getEmailLink().click();
		wait.until(ExpectedConditions.urlContains("contact"));
		assertEquals("http://localhost:" + port +"/contactUs.html", driver.getCurrentUrl());
	}
	
	@Test
	public void FooterTwitterLinkTest() throws InterruptedException {
		logger=extent.createTest("Twitter Link");
		driver.get("http://localhost:" + port +"/index.html");
		footer.getTwitterLink().click();
		assertEquals("https://twitter.com/QACinema2?ref_src=twsrc%5Etfw", driver.getCurrentUrl());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
