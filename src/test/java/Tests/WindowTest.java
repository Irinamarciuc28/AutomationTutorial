package Tests;

import HelpMethods.ElementMethods;
import HelpMethods.PageMethod;
import HelpMethods.WindowMethods;
import ShareData.ShareData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.openqa.selenium.By.cssSelector;

public class WindowTest extends ShareData {

        @Test
        public void MetodaTest() {

            ElementMethods element = new ElementMethods(getDriver());
            PageMethod pelement = new PageMethod(getDriver());
            WindowMethods welement = new WindowMethods(getDriver());


            WebElement SkipSignIn = getDriver().findElement(By.id("btn2"));
            element.clickElement(SkipSignIn);

            WebElement SwitchTo = getDriver().findElement(By.xpath("//a[text()='SwitchTo']"));
            element.MoveToElement(SwitchTo);

            WebElement WindowElement = getDriver().findElement(By.xpath("//a[text()='Windows']"));
            element.clickElement(WindowElement);


            pelement.navigateToPage("http://demo.automationtesting.in/Windows.html");



            List<WebElement> WindowOptions =getDriver().findElements(cssSelector(".nav-stacked>li>a"));
            element.clickElement(WindowOptions.get(0));

            WebElement TabButton=getDriver().findElement(By.cssSelector(">a>button"));
            element.clickElement(TabButton);

            //Identificam multimea de taburi/Windows


            //ne mutam cu focusul pe un tab specific
            welement.moveSpecificTabWindow(1);
            welement.CloseCurrentTabWindow();
            welement.moveSpecificTabWindow(0);



            WindowOptions.get(1).click();
            WebElement WindowButton = getDriver().findElement(By.cssSelector("#Seperate>button"));
            element.clickElement(WindowButton);

            List<String>Windows=new ArrayList<>(getDriver().getWindowHandles());

            //Ne mutam cu focusul pe un window specific
            welement.moveSpecificTabWindow(1);
            welement.CloseCurrentTabWindow();
            welement.moveSpecificTabWindow(0);

            WindowOptions.get(2).click();
            WebElement MultipleButton = getDriver().findElement(By.cssSelector("#Multiple>button"));
            element.clickElement(MultipleButton);

            welement.moveSpecificTabWindow(2);
            welement.CloseCurrentTabWindow();
            welement.moveSpecificTabWindow(1);
            welement.CloseCurrentTabWindow();
            welement.moveSpecificTabWindow(0);





        }
    }
