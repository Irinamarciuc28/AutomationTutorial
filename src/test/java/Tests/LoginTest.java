package Tests;

import HelpMethods.ElementMethods;
import Objects.LoginObject;

import ShareData.Hooks;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;




public class  LoginTest extends Hooks {




    @Test
    private void metodaTest(){
        LoginObject loginObject = new LoginObject(TestData);

        //Declaram un obiect si refacturizam actiunile
        ElementMethods elementMethods = new ElementMethods(getDriver());


        //Declaram elementul Sign In
        WebElement SignIn = getDriver().findElement(By.id("btn1"));
        elementMethods.ClickElement(SignIn);


        WebElement email = getDriver().findElement(By.cssSelector("input[placeholder='E mail']"));
        String emailValue = "delia@gmail.com";
        email.sendKeys(emailValue);
        elementMethods.FillElement(email, emailValue);

        WebElement parola = getDriver().findElement(By.xpath("//input[@placeholder = 'Password']"));
        String parolaValue = "Parola";
        elementMethods.FillElement(parola, parolaValue);

        WebElement Enter = getDriver().findElement(By.id("enterbtn"));
        elementMethods.ClickElement(Enter);

        //validam un mesaj de eroare
        WebElement error = getDriver().findElement(By.id("errormsg"));
        String expectedError = "Invalid User Name or PassWord";
        elementMethods.ValidateElementText(error, expectedError);






    }
}
