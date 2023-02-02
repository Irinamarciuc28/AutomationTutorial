package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.awt.*;

public class RegisterPage extends  BasePage{
    public RegisterPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//a[text()='SwitchTo']")
    private WebElement SwitchTo;

    @FindBy(xpath = "//a[text()='Alerts']")
    private WebElement AlertElement;

    @FindBy(xpath = "//a[text()='Frames']")
    private WebElement FrameElement;

    public void goToAlert(){


        element.MoveToElement(SwitchTo);
        element.ClickElement(AlertElement);
        pageMethod.NavigateToPage("http://demo.automationtesting.in/Alerts.html");

    }
    public void goToFrames(){


        element.MoveToElement(SwitchTo);
        element.ClickElement(FrameElement);
        pageMethod.NavigateToPage("http://demo.automationtesting.in/Frames.html");

    }
}
