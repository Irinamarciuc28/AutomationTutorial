package Pages;

import HelpMethods.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    public WebDriver driver;

    public ElementMethods element;
    public PageMethods pageMethods;
    public AlertMethods alertsMethods;
    public FrameMethods frameMethods;
    public WindowMethods windowMethods;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        element = new ElementMethods(driver);
        pageMethods = new PageMethods(driver);
        alertsMethods = new AlertMethods(driver);
        frameMethods = new FrameMethods(driver);
        windowMethods = new WindowMethods(driver);
    }

}