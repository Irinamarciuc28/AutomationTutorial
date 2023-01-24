package HelpMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageMethod {

    private WebDriver driver;

    public PageMethod (WebDriver driver) {
        this.driver = driver;
    }
    public void NavigateToPage(String url){
        driver.navigate().to(url);
        WebDriverWait WaitExplicit = new WebDriverWait(driver, Duration.ofSeconds(10));
        WaitExplicit.until(ExpectedConditions.urlToBe(url));

    }

    public void navigateToPage(String s) {
    }
}
