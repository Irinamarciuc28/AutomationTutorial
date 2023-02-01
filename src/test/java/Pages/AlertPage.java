package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.openqa.selenium.By.cssSelector;

public class AlertPage extends BasePage{

    public AlertPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css=".nav-stacked>li>a")
    private List<WebElement> AlertOptions;

    @FindBy(css="#OKTab>button")
    private WebElement btn1;

    @FindBy(css="#CanceTab>button")
    private WebElement  btn2;

    @FindBy(css ="#Textbox>button")
    private WebElement btn3;

    public void interactAlertAccept(){


        element.ClickElement(AlertOptions.get(0));
        element.ClickElement(btn1);
        alertMethods.AcceptAlert();

    }
   public void InteractAlertDismiss(){

       element.ClickElement(AlertOptions.get(1));


       element.ClickElement(btn2);

       alertMethods.DismissAlert();

   }

   public void InteractAlertValue(String value){
       element.ClickElement(AlertOptions.get(2));


       element.ClickElement(btn3);

       alertMethods.FillAlert(value, true);

   }
}

