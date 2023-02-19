package com.cucumber.junit.grid;

import com.cucumber.junit.pages.BasePage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class SeleniumGridTest {

    private WebDriver driver;

    public WebDriver initializeBrowser(String browserName) throws MalformedURLException {

        DesiredCapabilities dc = new DesiredCapabilities();

        if(browserName.equalsIgnoreCase("chrome")) {
            dc.setBrowserName("chrome");
        }else if(browserName.equalsIgnoreCase("ff"))
            dc.setBrowserName("firefox");

        driver = new RemoteWebDriver(new URL("http://localhost:4444"),dc);

        return driver;
    }

    @Test
    public void testFacebookChrome() throws MalformedURLException, InterruptedException {

        driver = initializeBrowser("chrome");
        driver.get("https://www.bookdepository.com/");

        assertEquals(BasePage.getExpectedUrlTitle("Home page"),
                driver.getTitle(), "Wrong page!");
        driver.quit();
    }

    @Test
    public void testFacebookFromFF() throws MalformedURLException, InterruptedException {
        driver = initializeBrowser("ff");
        driver.get("https://www.bookdepository.com/");

        assertEquals(BasePage.getExpectedUrlTitle("Home page"),
                driver.getTitle(), "Wrong page!");
        driver.quit();
    }
}