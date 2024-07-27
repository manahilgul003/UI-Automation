#Feature File
Feature: Shopping based on weather

  Scenario: Shop for products based on the temperature
    Given I am on the Weather Shopper homepage
    When the temperature is checked
    Then I choose the appropriate product category based on the temperature
    And I add the necessary products to the cart
    And I click on the cart

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

    @Then("I choose the appropriate product category based on the temperature")
    public void i_choose_the_appropriate_product_category_based_on_the_temperature() {
        if (currentTemperature < 19) {
            WebElement moisturizersButton = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/a/button"));
            moisturizersButton.click();
        } else if (currentTemperature > 34) {
            WebElement sunscreensButton = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/a/button"));
            sunscreensButton.click();
        }
    }

    @Then("I add the necessary products to the cart")
    public void i_add_the_necessary_products_to_the_cart() {
        if (currentTemperature < 19) {
            // Add least expensive moisturizer that contains Aloe
            WebElement aloeMoisturizer = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/button"));
            aloeMoisturizer.click();
            // Add least expensive moisturizer that contains Almond
            WebElement almondMoisturizer = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/button"));
            almondMoisturizer.click();
        } else if (currentTemperature > 34) {
            // Add least expensive sunscreen that is SPF-50
            WebElement spf50Sunscreen = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/button"));
            spf50Sunscreen.click();
            // Add least expensive sunscreen that is SPF-30
            WebElement spf30Sunscreen = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/button"));
            spf30Sunscreen.click();
        }
    }

    @Then("I click on the cart")
    public void i_click_on_the_cart() {
        WebElement cartButton = driver.findElement(By.xpath("/html/body/nav/ul/button"));
        cartButton.click();
    }
    

    @After
    public void quit() {
        if (driver != null) {
            driver.quit();
        }
    }
}
