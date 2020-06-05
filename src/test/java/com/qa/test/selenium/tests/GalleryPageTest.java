package com.qa.test.selenium.tests;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertFalse;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


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

import com.qa.test.selenium.pages.GalleryPage;
import org.junit.*;
import org.testng.annotations.AfterTest;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class GalleryPageTest {

    public static WebDriver driver;


    @LocalServerPort
    private int port;

    @BeforeClass
    public static void init() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        ChromeOptions opts = new ChromeOptions();
        opts.setHeadless(true);
        driver = new ChromeDriver(opts);
//        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
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
    public void testResetButtonPresent() {
        driver.manage().window().maximize();
        driver.get("http://localhost:" + port +"/gallery.html");
        GalleryPage gallery = PageFactory.initElements(driver, GalleryPage.class);
        assertEquals("reset".toUpperCase(),gallery.getResetButton().getText());
    }

}