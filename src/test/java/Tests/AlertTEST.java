package Tests;

import HelpMethods.AlertMethods;
import HelpMethods.ElementMethods;
import HelpMethods.PageMethod;
import ShareData.ShareData;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;

import static org.openqa.selenium.By.*;
import static org.openqa.selenium.By.cssSelector;

public class AlertTEST extends ShareData {



    @Test
    public void MetodaTest(){


        ElementMethods elementMethods = new ElementMethods(getDriver());
        PageMethod pageMethods = new PageMethod(getDriver());
        AlertMethods alertMethods = new AlertMethods(getDriver());

        WebElement SkipSignIn = getDriver().findElement(id("btn2"));
        elementMethods.ClickElement(SkipSignIn);

        WebElement SwitchTo = getDriver().findElement(xpath("//a[text()='SwitchTo']"));
        //Mergem cu mouse pe anumit element
        elementMethods.MoveToElement(SwitchTo);
        Actions actions = new Actions(getDriver());


      WebElement AlertElement = getDriver().findElement(xpath("//a[text()='Alerts']"));
      elementMethods.ClickElement(AlertElement);

      //Navigam catre un URL
       pageMethods.NavigateToPage("http://demo.automationtesting.in/Alerts.html");

        List<WebElement> AlertOptions;
        AlertOptions = getDriver().findElements(cssSelector(".nav-stacked>li>a"));
        elementMethods.ClickElement(AlertOptions.get(0));

        WebElement AlertOk = getDriver().findElement(cssSelector("#OKTab>button"));
        elementMethods.ClickElement(AlertOk);

        //interactionam cu o alerta
        alertMethods.AcceptAlert();

        elementMethods.ClickElement(AlertOk);

        elementMethods.ClickElement(AlertOptions.get(1));

        WebElement AlertOkCancel = cssSelector("CancelTab").findElement(getDriver());
        elementMethods.ClickElement(AlertOkCancel);

        alertMethods.DismissAlert();

        Alert SecondAlert = getDriver().switchTo().alert();
        SecondAlert.dismiss();

        elementMethods.ClickElement(AlertOptions.get(2));

        WebElement AlertText =getDriver().findElement(cssSelector("#Textbox>button"));
        elementMethods.ClickElement(AlertText);

        alertMethods.FillAlert("test", true);


    }
}
