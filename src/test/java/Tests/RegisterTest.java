package Tests;

import HelpMethods.ElementMethods;
import ShareData.ShareData;
import org.asynchttpclient.util.HttpConstants;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class RegisterTest extends ShareData {

    @Test
    public void metodaTest(){



        ElementMethods elementMethods= new ElementMethods(getDriver());

        WebElement SignIn = getDriver().findElement(By.id("btn1"));
        elementMethods.clickElement(SignIn);



        WebElement FirstName= getDriver().findElement(By.cssSelector("input[placeholder = 'First Name']"));
        String fistNameValue= "Irina";
        elementMethods.FillElement(FirstName, fistNameValue);

        WebElement SecondName= getDriver().findElement(By.cssSelector("input[placeholder = 'Second Name']"));
        String SecondNameValue= "Marciuc";
        elementMethods.FillElement(SecondName, SecondNameValue);

        WebElement Address = getDriver().findElement(By.cssSelector("textarea[ng-model='Address']"));
        String addressValue = "Str Gavril Musicescu 161";
        elementMethods.FillElement(Address,addressValue);


        WebElement Email= getDriver().findElement(By.cssSelector("input[ng-model='Email address']"));
        String emailValue= "marciuc.irina@gmail.com";
        elementMethods.FillElement(Email, emailValue);


        WebElement Phone = getDriver().findElement(By.xpath("//input[@ng-model='Phone']"));
        String phoneNumberValue="0746697868";
        elementMethods.FillElement(Phone,phoneNumberValue);

        WebElement Gen = getDriver().findElement(By.xpath("//input[@value='Female']"));
        elementMethods.clickElement(Gen);

        WebElement Hobby =getDriver().findElement(By.id("checkbox2"));
        elementMethods.clickElement(Hobby);

        //Interactionam cu un Drop down Clasic

        WebElement Skills = getDriver().findElement(By.id("Skills"));
        elementMethods.SelectElementText(Skills, "Java");

        WebElement Year = getDriver().findElement(By.id("yearbox"));
        elementMethods.SelectElementValue(Year, "1997");

        elementMethods.ScrollByPixel(0,300);

        WebElement LanguageElement= getDriver().findElement(By.id("msdd"));
        elementMethods.ClickElement(LanguageElement);

        //specify the WebElement till which the page has to be scrolled
        WebElement element = getDriver().findElement(By.linkText("All Browsers and Devices"));



        //Interactionam cu o multime de elemente (drop down complex)
        List<WebElement>  LanguageOptions = getDriver().findElements(By.cssSelector(".ui-autocomplete>li>a"));
        String ExpectedLanguage = "English";

        for (int index=0; index<LanguageOptions.size(); index ++) {
            if (LanguageOptions.get(index).getText().equals(ExpectedLanguage)) {
                elementMethods.clickElement(LanguageOptions.get(index));
            }
        }

         elementMethods.ClickElement(Gen);

            WebElement SelectCountry = getDriver().findElement(By.cssSelector(".select2-selection"));
            elementMethods.ClickElement(SelectCountry);

            WebElement SelectCountryInput = getDriver().findElement(By.className("select2-search__field"));
            elementMethods.FillElement(SelectCountryInput,"Australia");

            WebElement Month =getDriver().findElement(By.cssSelector("select[placeholder='Month']"));
            elementMethods.SelectElementText(Month, "August");

            WebElement Day = getDriver().findElement(By.id("daybox"));
            elementMethods.SelectElementValue(Day,"15");

             WebElement FirstPassword = getDriver().findElement(By.id("firstpassword"));
             String firstPasswordValue = "1234";
             elementMethods.FillElement(FirstPassword,firstPasswordValue );


             WebElement ConfirmPass = getDriver().findElement(By.id("secondpassword"));
             String ConfirmValue = "1234";
             elementMethods.FillElement(ConfirmPass,ConfirmValue );

             WebElement Submit = getDriver().findElement(By.id("submitbtn"));
             elementMethods.clickElement(Submit);

            WebElement SelectYear = getDriver().findElement(By.cssSelector(".ng-touched"));
            SelectYear.click();

            List<WebElement>SelectYearInput = getDriver().findElements(By.cssSelector(".ng-valid-required"));
            Integer ExpectYear=1996;
            for (int index = 3; index<SelectYearInput.size();index++){
                if(SelectYearInput.get(index).getText().equals(ExpectYear)){
                    SelectYearInput.get(index).click();
                }

        }



    }
}
