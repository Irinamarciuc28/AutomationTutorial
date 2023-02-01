package Tests;

import HelpMethods.AlertMethods;
import HelpMethods.ElementMethods;
import HelpMethods.PageMethod;
import Pages.AlertPage;
import Pages.IndexPage;
import Pages.RegisterPage;
import ShareData.ShareData;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;

import static org.openqa.selenium.By.*;

public class AlertTEST extends ShareData {



    @Test
    public void MetodaTest(){


        IndexPage indexPage = new IndexPage(getDriver());
        indexPage.clickSkipSignIn();
        RegisterPage registerPage = new RegisterPage(getDriver());
        registerPage.goToAlert();


        AlertPage alertPage = new AlertPage(getDriver());
        alertPage.interactAlertAccept();
        alertPage.InteractAlertDismiss();
        alertPage.InteractAlertValue("ceva");
    }
}
