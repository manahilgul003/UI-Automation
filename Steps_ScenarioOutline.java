package com.tau.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Steps_ScenarioOutline {
	private WebDriver mydriver;


	@Given("I am in the login page of Sauce Demo Application")
	public void i_am_in_the_login_page_of_Sauce_Demo_Application() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ayesha Noor\\eclipse-workspace\\tau-tester-course\\src\\test\\resources\\chromedriver.exe");
		mydriver=new ChromeDriver();
	  mydriver.get("https://www.saucedemo.com/");
	}
	@When("I enter valid {string} and {string}")
	public void i_enter_valid_and(String string, String string1) {
		WebElement username1 = mydriver.findElement(By.id("user-name"));
        WebElement password1 = mydriver.findElement(By.id("password"));
        username1.sendKeys(string);
        password1.sendKeys(string1);
        WebElement loginButton = mydriver.findElement(By.id("login-button"));
      loginButton.click();
	   
	}

	@Then("I should be taken to the Product Page")
	public void i_should_be_taken_to_the_Product_Page() {
		mydriver.findElement(By.className("header_secondary_container")).isDisplayed();
		
	}



	

}
