
import Objects.FrameObject;
import Pages.FramePage;
import Pages.IndexPage;
import Pages.RegisterPage;
import ShareData.Hooks;
import org.testng.annotations.Test;

import java.util.HashMap;


public class FrameTest extends Hooks {

    @Test
    public void metodaTest(){


        FrameObject frameObject = new FrameObject(TestData);
        IndexPage indexPage = new IndexPage(getDriver());
        indexPage.clickSkipSignIn();

        RegisterPage registerPage = new RegisterPage(getDriver());
        registerPage.goToFrame();

        FramePage framePage = new FramePage(getDriver());
        framePage.firstFrame(frameObject);
        framePage.secondFrame(frameObject);
    }

}
