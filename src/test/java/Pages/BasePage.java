package Pages;

import HelpMethods.AlertMethods;
import HelpMethods.ElementMethods;
import HelpMethods.PageMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    public WebDriver driver;
    public ElementMethods element;
    public PageMethod pageMethod;
    public AlertMethods alertMethods;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        element= new ElementMethods(driver);
        pageMethod = new PageMethod(driver);

        alertMethods = new AlertMethods(driver);

    }
}
