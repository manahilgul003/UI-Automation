package com.tau.steps;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Weather {
    WebDriver driver;
    String temperatureText;
    int currentTemperature;

    @Before
    public void before_setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ayesha Noor\\eclipse-workspace\\tau-tester-course\\src\\test\\resources\\chromedriver.exe"); // Update with your path
        driver = new ChromeDriver();
    }

    @Given("I am on the Weather Shopper homepage")
    public void i_am_on_the_Weather_Shopper_homepage() {
        driver.get("https://weathershopper.pythonanywhere.com/");
    }

    @When("the temperature is checked")
    public void the_temperature_is_checked() {
        WebElement temperatureElement = driver.findElement(By.id("temperature"));
        temperatureText = temperatureElement.getText();
        currentTemperature = Integer.parseInt(temperatureText.replaceAll("[^\\d]", "").trim());
    }

    @Then("I should see whether the temperature is below or above nineteen or thirty degrees respectively by the recommended product")
    public void i_should_see_whether_the_temperature_is_below_or_above_nineteen_or_thirty_degrees_respectively_by_the_recommended_product() {
       

        if (currentTemperature < 19) {
            WebElement moist = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/a/button"));
            moist.click();
        } else if (currentTemperature > 34) {
            WebElement sun = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/a/button"));
            sun.click();
        } 

       
    }

    @After
    public void quit() {
        if (driver != null) {
            driver.quit();
        }
    }
}
Feature: Shopping based on weather

  Scenario: Shop for products based on the temperature
    Given I am on the Weather Shopper homepage
    When the temperature is checked
    Then I should see whether the temperature is below or above nineteen or thirty degrees respectively by the recommended product

