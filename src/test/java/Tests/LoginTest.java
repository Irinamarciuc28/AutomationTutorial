package Tests;

import HelpMethods.ElementMethods;
import Pages.IndexPage;
import Pages.LoginPage;
import ShareData.ShareData;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;



public class  LoginTest extends ShareData {




    @Test
    private void metodaTest(){

        //Declaram un obiect si refacturizam actiunile
        IndexPage indexPage = new IndexPage(getDriver());
        indexPage.clickSignIn();


        LoginPage login = new LoginPage(getDriver());
        login.LoginInvalid("irina@gmail.com","Parola", "Invalid User Name or PassWord" );

    }
}
