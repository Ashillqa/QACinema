package com.qa.test.selenium.tests;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.qa.test.selenium.pages.BookingPage;
import com.qa.test.selenium.pages.PaymentPage;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import com.qa.test.selenium.pages.DetailsPage;
import com.qa.test.selenium.pages.GalleryPage;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class BookingTest {

    public static WebDriver driver;
    private final WebDriverWait wait = new WebDriverWait(driver, 2);
    BookingPage booking = PageFactory.initElements(driver, BookingPage.class);
    PaymentPage payment = PageFactory.initElements(driver, PaymentPage.class);
    public static ExtentHtmlReporter reporter = new ExtentHtmlReporter("Reports/Booking.html");
    public static ExtentReports extent = new ExtentReports();
    ExtentTest logger;

    JavascriptExecutor js = (JavascriptExecutor) driver;

    @LocalServerPort
    private int port;

    @BeforeClass
    public static void init() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        ChromeOptions opts = new ChromeOptions();
        opts.setHeadless(true);
        driver = new ChromeDriver(opts);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        sleep(8000);
        extent.attachReporter(reporter);
    }

    @AfterClass
    public static void teardown() {
        driver.quit();
        extent.flush();
    }

    @Test
    public void makeBooking() {
        logger=extent.createTest("Create Booking");
        driver.get("http://localhost:" + port +"/details2.html?title=Onward&id=133");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#collapse0 > div > table > tbody > tr > th > a"))).click();
        wait.until(ExpectedConditions.urlContains("bookings"));
        assertTrue(driver.getCurrentUrl().contains("bookings2.html"));
        booking.getName().sendKeys("Tester");
        booking.getEmail().sendKeys("Tester@email.com");
        booking.getNumber().sendKeys("0044 88112384");
        Select adults = new Select(booking.getAdult());
        adults.selectByVisibleText("2");
        Select student = new Select(booking.getStudent());
        student.selectByVisibleText("2");
        Select child = new Select(booking.getChild());
        child.selectByVisibleText("1");
        js.executeScript("document.getElementById(`extra2Pounds`).click();");
        assertEquals("£34",booking.getTotalPrice().getText());
        booking.getPayButton().click();
        wait.until(ExpectedConditions.urlContains("payment"));
        payment.getName().sendKeys("Jeff Tester");
    }

}
