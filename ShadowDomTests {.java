package base;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import static org.junit.Assert.assertEquals;

public class ShadowDomTests {

    private WebDriver driver;

    public WebDriver getDriver() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
            driver = new ChromeDriver();
        }
        return driver;
    }

    @Test
    public void testShadowDomWatir() {
        getDriver().get("http://watir.com/examples/shadow_dom.html");
        HomePage homePage = new HomePage(getDriver());
        // assertEquals(homePage.getSomeText(), "some text");
        assertEquals(homePage.getShadowDomText(), "some text");
        assertEquals(homePage.getNestedShadowText(), "nested text");
        assertEquals(homePage.getNestedText(), "nested text");
        assertEquals(homePage.getNestedTextUsingJSExecutor(), "nested text");
        getDriver().quit();
    }
}
