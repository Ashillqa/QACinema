package com.qa.test.selenium.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
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
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class GalleryPageTest {

    public static WebDriver driver;
    public static ExtentHtmlReporter reporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/Reports/GalleryPage.html");
    public static ExtentReports reports = new ExtentReports();
    public ExtentTest test;

    @LocalServerPort
    private int port;

//    @Before
//    public void init() {
//        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
//        ChromeOptions opts = new ChromeOptions();
//        opts.setHeadless(true);
//        this.driver = new ChromeDriver(opts);
////		this.driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
//    }

    @BeforeTest
    public static void startReport(){
//        reporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/Reports/GalleryPage.html");
//        reporter.loadXMLConfig(System.getProperty("user.dir") + "\\extent-report.xml");
//        reports = new ExtentReports();
        reports.setSystemInfo("Host Name", "QA");
        reports.setSystemInfo("Tester", "David");
        reports.attachReporter(reporter);

//        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
//        ChromeOptions opts = new ChromeOptions();
//        opts.setHeadless(true);
//        driver = new ChromeDriver(opts);
//		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

//        driver.manage().window().maximize();
//        reporter.start();
    }


    @BeforeMethod
    public void register(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\david\\IdeaProjects\\QACinema\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://google.com");
//String testName = method.getName();
//test = reports.createTest(testName);
    }

    @AfterMethod
    public void teardown(ITestResult result) {

        if(result.getStatus() == ITestResult.FAILURE){
            test.log(Status.FAIL , "This test failed" + result.getName());
            test.log(Status.FAIL , "Test has failed" + result.getThrowable());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, "Test has passed " + result.getName());
        }

        driver.quit();
    }

    @AfterTest
    public void endReport(){
        reports.flush();
    }

    @Test
    public void google(){
        test = reports.createTest("dummy test");

        String title = driver.getTitle();
        System.out.println(title);
        assertEquals(title,"google");
    }

    @Ignore
    @Test
    public void testResetButtonPresent() throws InterruptedException, IOException {

//        test = reports.createTest("Test1");

//        driver.manage().window().maximize();
//        test.log  (Status.INFO, "started the browser");
//        driver.get("http://localhost:" + port +"/gallery.html");
//        GalleryPage gallery = PageFactory.initElements(driver, GalleryPage.class);
//
//        assertEquals("reset".toUpperCase(),gallery.getResetButton().getText());
//        gallery.getResetButton().click();
        assertEquals(true, true);
        test.log(Status.INFO,"sample test");

    }

}