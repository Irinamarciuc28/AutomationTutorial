package Tests;

import Objects.AlertObjects;
import Pages.AlertPage;
import Pages.IndexPage;
import Pages.RegisterPage;
import ShareData.ShareData;
import org.openqa.selenium.Alert;
import org.testng.annotations.Test;

public class AlertTEST extends Hooks {



    @Test
    public void MetodaTest(){

        AlertObjects alertObjects = new AlertObjects(testData);


        IndexPage indexPage = new IndexPage(getDriver());
        indexPage.clickSkipSignIn();
        RegisterPage registerPage = new RegisterPage(getDriver());
        registerPage.goToAlert();


        AlertPage alertPage = new AlertPage(getDriver());
        alertPage.interactAlertAccept();
        alertPage.InteractAlertDismiss();
        alertPage.InteractAlertValue(alertObjects);
    }
}
