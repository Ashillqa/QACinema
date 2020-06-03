package com.qa.test.selenium.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import com.qa.test.selenium.pages.GalleryPage;

import java.util.concurrent.TimeUnit;



@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class GalleryPageTest {

    private WebDriver driver;
    ExtentHtmlReporter reporter = new ExtentHtmlReporter("Reports/learn_automation1.html");
    ExtentReports extent = new ExtentReports();


    @LocalServerPort
    private int port;

    @Before
    public void init() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        ChromeOptions opts = new ChromeOptions();
        opts.setHeadless(true);
        this.driver = new ChromeDriver(opts);
//		this.driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        extent.attachReporter(reporter);
    }

    @After
    public void teardown() {
        driver.quit();
    }

    @Test
    public void testResetButtonPresent() {
        driver.manage().window().maximize();
        ExtentTest logger=extent.createTest("LoginTest");
        logger.log(Status.PASS, "Title verified");
        logger.log(Status.INFO, "Login to amazon");
        driver.get("http://localhost:" + port +"/gallery.html");
        GalleryPage gallery = PageFactory.initElements(driver, GalleryPage.class);

        assertEquals("reset".toUpperCase(),gallery.getResetButton().getText());
        extent.flush();
    }

}