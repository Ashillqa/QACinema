package com.qa.test.selenium.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.qa.App;
import com.qa.test.selenium.pages.ClassificationsPage;
import com.qa.test.selenium.pages.DetailsPage;
import com.qa.test.selenium.pages.GalleryPage;
import com.qa.test.selenium.pages.SearchPage;
import org.junit.*;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;

import java.io.File;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class SearchPageTest {

    public static WebDriver driver;
    public static ExtentHtmlReporter reporter = new ExtentHtmlReporter("Reports/SearchPage.html");
    public static ExtentReports extent = new ExtentReports();
    ExtentTest logger;

    @LocalServerPort
    private int port;

    @BeforeClass
    public static void init() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        ChromeOptions opts = new ChromeOptions();
        opts.setHeadless(true);
        driver = new ChromeDriver(opts);
//		this.driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        extent.attachReporter(reporter);
    }

    @AfterMethod
    public void result(ITestResult result){
        logger.log(Status.INFO, "asdf");
    }

    @AfterClass
    public static void teardown() {
        extent.flush();
        driver.quit();
    }

    @Test
    public void testResetButton() {
        logger=extent.createTest("test1");
        driver.get("http://localhost:" + port +"/search.html");
        GalleryPage gallery = PageFactory.initElements(driver, GalleryPage.class);
        assertEquals("reset".toUpperCase(),gallery.getResetButton().getText());
        gallery.getResetButton().click();
        assertEquals("http://localhost:" + port +"/search.html", driver.getCurrentUrl());
    }

    @Test
    public void testMovieGalleryPlayButtonLink() {
        logger=extent.createTest("test2");

        driver.get("http://localhost:" + port +"/search.html");
        SearchPage search = PageFactory.initElements(driver, SearchPage.class);

        logger.log(Status.INFO, "asdf");

        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("title1")));
        String title = search.getTitle1().getText();
        search.getPlay1().click();
        assertTrue(driver.getCurrentUrl().contains("details2.html"));
        DetailsPage details = PageFactory.initElements(driver, DetailsPage.class);

        wait.until(ExpectedConditions.textToBePresentInElement(details.getTitle(), title));
        assertEquals(details.getTitle().getText(),title);

    }

    @Test
    public void testMovieGalleryTitleLink() {
        logger=extent.createTest("test3");
        driver.get("http://localhost:" + port +"/search.html");
        SearchPage search = PageFactory.initElements(driver, SearchPage.class);
        WebDriverWait wait = new WebDriverWait(driver, 2);

        logger.log(Status.FAIL, "asdf");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("title1")));
        String title = search.getTitle1().getText();
        search.getTitle1().click();
        assertTrue(driver.getCurrentUrl().contains("details2.html"));
        DetailsPage details = PageFactory.initElements(driver, DetailsPage.class);

        wait.until(ExpectedConditions.textToBePresentInElement(details.getTitle(), title));
        assertEquals(details.getTitle().getText(),title);
    }

    @Test
    public void testMovieGalleryClassificationLink() {
        driver.get("http://localhost:" + port +"/search.html");
        SearchPage search = PageFactory.initElements(driver, SearchPage.class);
        WebDriverWait wait = new WebDriverWait(driver, 2);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"ageRating\"]")));
        search.getRating().click();
        assertTrue(driver.getCurrentUrl().contains("classifications"));
        ClassificationsPage classifications = PageFactory.initElements(driver, ClassificationsPage.class);

        wait.until(ExpectedConditions.textToBePresentInElement(classifications.getTitle(), "Classifications"));
        assertEquals(classifications.getTitle().getText(),"Classifications");
    }

    @Test
    public void testFeatureMovieGalleryPlayButtonLink() {
        driver.get("http://localhost:" + port +"/search.html");
        SearchPage search = PageFactory.initElements(driver, SearchPage.class);

        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"primeDiv\"]/div[4]")));

        String title = search.getMovieFeature().findElement(By.className("featuredMovieTitle")).getText();
        search.getMovieFeature().findElement(By.id("play")).click();
        assertTrue(driver.getCurrentUrl().contains("details2.html"));
        DetailsPage details = PageFactory.initElements(driver, DetailsPage.class);

        wait.until(ExpectedConditions.textToBePresentInElement(details.getTitle(), title));
        assertEquals(details.getTitle().getText(),title);
    }

    @Test
    public void testFeatureMovieGalleryTitleLink() {
        driver.get("http://localhost:" + port +"/search.html");
        SearchPage search = PageFactory.initElements(driver, SearchPage.class);

        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"primeDiv\"]/div[4]")));
        String title = search.getMovieFeature().findElement(By.className("featuredMovieTitle")).getText();
        search.getMovieFeature().findElement(By.className("featuredMovieTitle")).click();
        assertTrue(driver.getCurrentUrl().contains("details2.html"));
        DetailsPage details = PageFactory.initElements(driver, DetailsPage.class);

        wait.until(ExpectedConditions.textToBePresentInElement(details.getTitle(), title));
        assertEquals(details.getTitle().getText(),title);
    }

    @Test
    public void testFeatureMovieGalleryClassificationLink() {
        driver.get("http://localhost:" + port + "/search.html");
        SearchPage search = PageFactory.initElements(driver, SearchPage.class);

        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"primeDiv\"]/div[4]")));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("ageRating")));
        search.getMovieFeature().findElement(By.id("ageRating")).click();
        assertTrue(driver.getCurrentUrl().contains("classifications"));
        ClassificationsPage classifications = PageFactory.initElements(driver, ClassificationsPage.class);

        wait.until(ExpectedConditions.textToBePresentInElement(classifications.getTitle(), "Classifications"));
        assertEquals(classifications.getTitle().getText(), "Classifications");
    }

    @Test
    public void testShowMoreButton() {
        driver.get("http://localhost:" + port + "/search.html");
        SearchPage search = PageFactory.initElements(driver, SearchPage.class);

        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.elementToBeClickable(search.getShowMoreButton()));
        search.getShowMoreButton().click();
        assertTrue(driver.getCurrentUrl().contains("gallery"));
    }
}