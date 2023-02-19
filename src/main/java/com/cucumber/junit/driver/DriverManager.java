package com.cucumber.junit.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.openqa.selenium.chrome.ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY;
import static org.openqa.selenium.firefox.GeckoDriverService.GECKO_DRIVER_EXE_PROPERTY;


public class DriverManager {

    private static final String CHROME_DRIVER_PATH = "src/main/resources/chromedriver.exe";
    private static final String FIREFOX_DRIVER_PATH = "src/main/resources/geckodriver.exe";
    private static final int IMPLICIT_WAIT_TIMEOUT = 15;
    private static final int PAGE_LOAD_TIMEOUT = 30;

    public WebDriver setupDriver() {
        String browser = System.getProperty("browser", "chrome");
        WebDriver driver;
        if (browser.equalsIgnoreCase("FF")) {
            System.setProperty(GECKO_DRIVER_EXE_PROPERTY, FIREFOX_DRIVER_PATH);
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty(CHROME_DRIVER_EXE_PROPERTY, CHROME_DRIVER_PATH);
            driver = new ChromeDriver();
        } else {
            throw new IllegalStateException(String.format("%s browser is not supported", browser));
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT_TIMEOUT, SECONDS);
        driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, SECONDS);
        return driver;
    }
}

