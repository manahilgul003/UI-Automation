#Feature File
Feature: Shopping based on weather

  Scenario: Shop for products based on the temperature
    Given I am on the Weather Shopper homepage
    When the temperature is checked
    Then I choose the appropriate product category based on the temperature
    And I add the necessary products to the cart
    And I click on the cart
Java File 
package com.tau.steps;

import static org.junit.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.time.Duration;

public class Weather {
    WebDriver driver;
    String temperatureText;
    int currentTemperature;
    WebDriverWait wait;

    @Before
    public void before_setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ayesha Noor\\eclipse-workspace\\tau-tester-course\\src\\test\\resources\\chromedriver.exe"); // Update with your path
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Given("I am on the Weather Shopper homepage")
    public void i_am_on_the_Weather_Shopper_homepage() {
        driver.get("https://weathershopper.pythonanywhere.com/");
    }

    @When("the temperature is checked")
    public void the_temperature_is_checked() {
        WebElement temperatureElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("temperature")));
        temperatureText = temperatureElement.getText();
        currentTemperature = Integer.parseInt(temperatureText.replaceAll("[^\\d]", "").trim());
    }

    @Then("I choose the appropriate product category based on the temperature")
    public void i_choose_the_appropriate_product_category_based_on_the_temperature() {
        if (currentTemperature < 19) {
            WebElement moisturizersButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Buy moisturizers')]")));
            moisturizersButton.click();
        } else if (currentTemperature > 34) {
            WebElement sunscreensButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Buy sunscreens')]")));
            sunscreensButton.click();
        }
    }

    @Then("I add the necessary products to the cart")
    public void i_add_the_necessary_products_to_the_cart() {
        if (currentTemperature < 19) {
            // Add least expensive moisturizer that contains Aloe
            WebElement aloeMoisturizer = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[contains(text(), 'Aloe')]/following-sibling::button")));
            aloeMoisturizer.click();
            // Add least expensive moisturizer that contains Almond
            WebElement almondMoisturizer = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[contains(text(), 'Almond')]/following-sibling::button")));
            almondMoisturizer.click();
        } else if (currentTemperature > 34) {
            // Add least expensive sunscreen that is SPF-50
            WebElement spf50Sunscreen = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[contains(text(), 'SPF-50')]/following-sibling::button")));
            spf50Sunscreen.click();
            // Add least expensive sunscreen that is SPF-30
            WebElement spf30Sunscreen = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[contains(text(), 'SPF-30')]/following-sibling::button")));
            spf30Sunscreen.click();
        }
    }

    @Then("I click on the cart")
    public void i_click_on_the_cart() {
        WebElement cartButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("cart")));
        cartButton.click();
    }

    @Then("I verify that the shopping cart looks correct")
    public void i_verify_that_the_shopping_cart_looks_correct() {
        // Verify cart has the correct items
        if (currentTemperature < 19) {
            WebElement aloeMoisturizerCart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(), 'Aloe')]")));
            WebElement almondMoisturizerCart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(), 'Almond')]")));
            assertTrue(aloeMoisturizerCart.isDisplayed());
            assertTrue(almondMoisturizerCart.isDisplayed());
        } else if (currentTemperature > 34) {
            WebElement spf50SunscreenCart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(), 'SPF-50')]")));
            WebElement spf30SunscreenCart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(), 'SPF-30')]")));
            assertTrue(spf50SunscreenCart.isDisplayed());
            assertTrue(spf30SunscreenCart.isDisplayed());
        }
    }

    @Then("I fill out my payment details and submit the form")
    public void i_fill_out_my_payment_details_and_submit_the_form() {
        // Switch to the iframe for Stripe
        WebElement stripeIframe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[contains(@name, 'stripe_checkout_app')]")));
        driver.switchTo().frame(stripeIframe);

        // Fill out the payment form
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
        emailField.sendKeys("test@example.com");

        WebElement cardNumberField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("card_number")));
        cardNumberField.sendKeys("4242424242424242");

        WebElement cardExpiryField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cc-exp")));
        cardExpiryField.sendKeys("1234");

        WebElement cardCvcField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cc-csc")));
        cardCvcField.sendKeys("123");

        WebElement zipCodeField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("billing-zip")));
        zipCodeField.sendKeys("12345");

        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("submitButton")));
        submitButton.click();

        // Switch back to the default content
        driver.switchTo().defaultContent();
    }

    @After
    public void quit() {
        if (driver != null) {
            driver.quit();
        }
    }
}
