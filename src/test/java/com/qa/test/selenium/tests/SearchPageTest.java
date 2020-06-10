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
import org.openqa.selenium.*;
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
import java.util.List;

import static java.lang.Thread.sleep;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class SearchPageTest {

    public static WebDriver driver;
    JavascriptExecutor js = (JavascriptExecutor) driver;
    public static ExtentHtmlReporter reporter = new ExtentHtmlReporter("Reports/SearchPage.html");
    public static ExtentReports extent = new ExtentReports();
    ExtentTest logger;
    WebDriverWait wait = new WebDriverWait(driver, 5);


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
        logger=extent.createTest("Reset Button");
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
        logger=extent.createTest("Play Button Link");
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
        logger=extent.createTest("Title Link");
        driver.get("http://localhost:" + port +"/search.html");
        SearchPage search = PageFactory.initElements(driver, SearchPage.class);


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
        logger=extent.createTest("Classification Link");
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
        logger=extent.createTest("Featured Movie Title Link");
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
        logger=extent.createTest("Show More Button");
        driver.get("http://localhost:" + port + "/search.html");
        SearchPage search = PageFactory.initElements(driver, SearchPage.class);

        wait.until(ExpectedConditions.elementToBeClickable(search.getShowMoreButton()));
        search.getShowMoreButton().click();
        assertTrue(driver.getCurrentUrl().contains("gallery"));
    }

    @Test
    public void testSearch1() {
        logger=extent.createTest("Search Presence");
        driver.get("http://localhost:" + port + "/search.html?term=joker");
        SearchPage search = PageFactory.initElements(driver, SearchPage.class);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("title129")));
        List<WebElement> children = driver.findElement(By.id("movieDisplay")).findElements(By.xpath(".//*"));
        assertEquals(children.size(),27);

        search.getResetButton().click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("title125")));
        children = driver.findElement(By.id("movieDisplay")).findElements(By.xpath(".//*"));
        if (children.size() == 27){
            throw new AssertionError();
        }

    }

    @Test
    public void testSearchNot1() {
        logger=extent.createTest("Search Elimination");
        driver.get("http://localhost:" + port + "/search.html?term=y");
        SearchPage search = PageFactory.initElements(driver, SearchPage.class);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("title129")));
        List<WebElement> children = driver.findElement(By.id("movieDisplay")).findElements(By.xpath(".//*"));
        if (children.size() == 27){
            throw new AssertionError();
        }
    }

    @Test
    public void testGenre() {
        logger=extent.createTest("Genre Filter");
        driver.get("http://localhost:" + port + "/search.html");
        SearchPage search = PageFactory.initElements(driver, SearchPage.class);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("title129")));
        js.executeScript("document.getElementById(\"selectGenre\").value = \"Adventure\"\n");
        search.getGenre().click();
        assertTrue(driver.findElement(By.id("title122")).isDisplayed());
        assertFalse(driver.findElement(By.id("title135")).isDisplayed());
    }

    @Test
    public void testRating() {
        logger=extent.createTest("Rating Filter");
        driver.get("http://localhost:" + port + "/search.html");
        SearchPage search = PageFactory.initElements(driver, SearchPage.class);

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
        logger=extent.createTest("Word Filter");
        driver.get("http://localhost:" + port + "/search.html");
        SearchPage search = PageFactory.initElements(driver, SearchPage.class);

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
        logger=extent.createTest("Release Filter");
        driver.get("http://localhost:" + port + "/search.html");
        SearchPage search = PageFactory.initElements(driver, SearchPage.class);

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