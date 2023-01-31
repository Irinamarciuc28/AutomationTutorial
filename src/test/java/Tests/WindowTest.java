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


            //Mergem cu mouse pe anumit element
            Actions actions = new Actions(getDriver());

            //this.driver = asa recunoastem un constructor
            actions.moveToElement(SwitchTo).perform();

            WebElement WindowElement = getDriver().findElement(By.xpath("//a[text()='Windows']"));
            WindowElement.click();


            pelement.navigateToPage("http://demo.automationtesting.in/Windows.html");



            List<WebElement> WindowOptions =getDriver().findElements(cssSelector(".nav-stacked>li>a"));
            element.clickElement(WindowOptions.get(0));

            WebElement TabButton=getDriver().findElement(By.cssSelector("#Tabbed>a>button"));
            element.clickElement(TabButton);

            //Identificam multimea de taburi/Windows

            List <String>Tabs=new ArrayList<>(getDriver().getWindowHandles());
            //ne mutam cu focusul pe un tab specific
            WebDriver window = getDriver().switchTo().window(Tabs.get(1));

            //Inchidem tabul curent

            getDriver().close();
            getDriver().switchTo().window(Tabs.get(0));

            WindowOptions.get(1).click();
            WebElement WindowButton = getDriver().findElement(By.cssSelector("#Seperate>button"));
            WindowButton.click();

            List<String>Windows=new ArrayList<>(getDriver().getWindowHandles());
            //Ne mutam cu focusul pe un window specific
            welement.moveSpecificTabWindow(1);
            getDriver().close();
            welement.moveSpecificTabWindow(0);

            WindowOptions.get(2).click();
            WebElement MultipleButton = getDriver().findElement(By.cssSelector("#Multiple>button"));
            MultipleButton.click();

            List<String>Multiple=new ArrayList<>(getDriver().getWindowHandles());
            getDriver().switchTo().window(Multiple.get(2));
            getDriver().close();
            getDriver().switchTo().window(Multiple.get(1));
            getDriver().close();
            getDriver().switchTo().window(Multiple.get(0));
            getDriver().close();
        }
    }
