package com.qa.test.selenium.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class SearchPageTest {

    public static WebDriver driver;
    public static ExtentHtmlReporter reporter = new ExtentHtmlReporter("Reports/SearchPage.html");
    public static ExtentReports extent = new ExtentReports();
    WebDriverWait wait = new WebDriverWait(driver, 5);
    ExtentTest logger;

    @LocalServerPort
    private int port;

    @BeforeClass
    public static void init() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        ChromeOptions opts = new ChromeOptions();
        opts.setHeadless(true);
        driver = new ChromeDriver(opts);
//		this.driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        extent.attachReporter(reporter);

    }

    @Before
    public void apiBreaker() throws InterruptedException {
        sleep(5000);
    }

    @AfterClass
    public static void teardown() {
        extent.flush();
        driver.quit();
    }

    @Test
    public void testResetButton () throws InterruptedException, IOException {
        logger=extent.createTest("Reset Button Test");
        driver.get("http://localhost:" + port +"/search.html");
        logger.log(Status.INFO, "navigating to site");
        GalleryPage gallery = PageFactory.initElements(driver, GalleryPage.class);
        assertEquals("reset".toUpperCase(),gallery.getResetButton().getText());
        logger.log(Status.INFO, "obtaining text from button, making sure it's written as 'reset'");
        gallery.getResetButton().click();
        logger.log(Status.INFO, "clicking button");
        assertEquals("http://localhost:" + port +"/search.html",driver.getCurrentUrl());
        logger.log(Status.PASS, "Test Passed");
    }

    @Test
    public void testMovieGalleryPlayButtonLink() {
        logger=extent.createTest("test2");
        driver.get("http://localhost:" + port +"/search.html");
        SearchPage search = PageFactory.initElements(driver, SearchPage.class);
        String title = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("title124"))).getText();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("play124"))).click();
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

        logger.log(Status.FAIL, "asdf");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("title124")));
        String title = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("title124"))).getText();
        search.getShowingTitle().click();
        assertTrue(driver.getCurrentUrl().contains("details2.html"));
        DetailsPage details = PageFactory.initElements(driver, DetailsPage.class);

        wait.until(ExpectedConditions.textToBePresentInElement(details.getTitle(), title));
        assertEquals(details.getTitle().getText(),title);
    }

    @Test
    public void testMovieGalleryClassificationLink() {
        driver.get("http://localhost:" + port +"/search.html");
        SearchPage search = PageFactory.initElements(driver, SearchPage.class);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"ageRating\"]")));
        search.getRating().click();
        assertTrue(driver.getCurrentUrl().contains("classifications"));
        ClassificationsPage classifications = PageFactory.initElements(driver, ClassificationsPage.class);

        wait.until(ExpectedConditions.textToBePresentInElement(classifications.getTitle(), "Classifications"));
        assertEquals(classifications.getTitle().getText(),"Classifications");
    }


    @Test
    public void testFeatureMovieGalleryTitleLink() {
        driver.get("http://localhost:" + port +"/search.html");
        SearchPage search = PageFactory.initElements(driver, SearchPage.class);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"primeDiv\"]/div[4]")));
        String title = search.getMovieFeature().findElement(By.className("featuredMovieTitle")).getText();
        search.getMovieFeature().findElement(By.className("featuredMovieTitle")).click();
        assertTrue(driver.getCurrentUrl().contains("details2.html"));
        DetailsPage details = PageFactory.initElements(driver, DetailsPage.class);

        wait.until(ExpectedConditions.textToBePresentInElement(details.getTitle(), title));
        assertEquals(details.getTitle().getText(),title);
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