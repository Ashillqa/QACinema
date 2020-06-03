package com.qa.test.selenium.tests;

import com.qa.test.selenium.pages.DetailsPage;
import com.qa.test.selenium.pages.GalleryPage;
import com.qa.test.selenium.pages.SearchPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
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

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class SearchPageTest {

    private WebDriver driver;

    @LocalServerPort
    private int port;

    @Before
    public void init() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        ChromeOptions opts = new ChromeOptions();
        opts.setHeadless(true);
        this.driver = new ChromeDriver(opts);
//		this.driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @After
    public void teardown() {
        driver.quit();
    }

    @Test
    public void testResetButton() {
        driver.manage().window().maximize();
        driver.get("http://localhost:" + port +"/search.html");
        GalleryPage gallery = PageFactory.initElements(driver, GalleryPage.class);
        assertEquals("reset".toUpperCase(),gallery.getResetButton().getText());
        gallery.getResetButton().click();
        assertEquals("http://localhost:" + port +"/search.html", driver.getCurrentUrl());
    }

    @Test
    public void testMovieGalleryPlayButtonLink() {
        driver.manage().window().maximize();
        driver.get("http://localhost:" + port +"/search.html");
        SearchPage search = PageFactory.initElements(driver, SearchPage.class);

        String title = search.getMovie().findElement(By.id("title")).getText();
        search.getMovie().findElement(By.id("play")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("details2.html"));
        DetailsPage details = PageFactory.initElements(driver, DetailsPage.class);

        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.textToBePresentInElement(details.getTitle(), title));
        assertEquals(details.getTitle().getText(),title);
    }

}