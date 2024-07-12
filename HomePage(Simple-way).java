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

    public String getShadowDomText() {
        WebElement shadowHost = getDriver().findElement(By.id("shadow_host"));
        SearchContext shadowRoot = shadowHost.getShadowRoot();
        String text = shadowRoot.findElement(By.cssSelector("#shadow_content > span"))
                .getText();
        return text;
    }

    public String getNestedShadowText() {
        WebElement shadowHost = getDriver().findElement(By.id("shadow_host"));
        SearchContext shadowRoot = shadowHost.getShadowRoot();
        WebElement shadowContent = shadowRoot.findElement(By.cssSelector("#nested_shadow_host"));
        SearchContext shadowRootTwo = shadowContent.getShadowRoot();
        String nestedText = shadowRootTwo.findElement(By.cssSelector("#nested_shadow_content > div")).getText();
        return nestedText;
    }

}
