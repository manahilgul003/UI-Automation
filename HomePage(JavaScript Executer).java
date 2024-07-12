package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private WebDriver getDriver() {
        return this.driver;
    }

    public SearchContext expandRootElement(WebElement element) {
        SearchContext shadowRoot = (SearchContext) ((JavascriptExecutor) getDriver()).executeScript(
                "return arguments[0].shadowRoot", element);
        return shadowRoot;
    }

    public String getSomeText() {
        return getDriver().findElement(By.cssSelector("#shadow_content > span"))
                .getText();
    }

   

    public String getNestedTextUsingJSExecutor() {
        WebElement shadowHost = getDriver().findElement(By.id("shadow_host"));
        SearchContext shadowRootOne = expandRootElement(shadowHost);
        WebElement nestedShadowHost = shadowRootOne.findElement(By.cssSelector("#nested_shadow_host"));
        SearchContext shadowRootTwo = expandRootElement(nestedShadowHost);
        return shadowRootTwo.findElement(By.cssSelector("#nested_shadow_content > div"))
                .getText();
    }
}
