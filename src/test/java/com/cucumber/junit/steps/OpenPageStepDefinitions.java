package com.cucumber.junit.steps;

import com.cucumber.junit.driver.DriverManager;
import com.cucumber.junit.pages.BasePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class OpenPageStepDefinitions {

    private WebDriver driver;
    private final DriverManager driverManager = new DriverManager();

    @Before
    public void setUp() {
        driver = driverManager.setupDriver();
    }

    @Given("I am an anonymous customer with clear cookies")
    public void clearCookies() {
        driver.manage().deleteAllCookies();
    }

    @When("I open the {string}")
    public void openThePage(String url) {
        driver.get(url);
    }

    @Then("I am redirected to a {string}")
    public void verifyUserIsAtCorrectPage(String pageTitle) {
        String expectedTitle = BasePage.getExpectedUrlTitle(pageTitle);
        String actualTitle = driver.getTitle();
        Assert.assertEquals("Wrong page!", expectedTitle, actualTitle);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}