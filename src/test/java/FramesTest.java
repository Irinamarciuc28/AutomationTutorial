import HelpMethods.ElementMethods;
import HelpMethods.FrameMethods;
import HelpMethods.PageMethod;
import ShareData.ShareData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.util.List;

public class FramesTest extends ShareData {

    @Test
    public void MetodaTest() {
        
        ElementMethods element = new ElementMethods(getDriver());
        PageMethod pElement =  new PageMethod(getDriver());
        FrameMethods fElement= new FrameMethods(getDriver());


        WebElement SkipRegister = getDriver().findElement(By.id("btn2"));
        element.clickElement(SkipRegister);

        //Wait explicit cu conditii diferite


        WebElement SwitchToElem = getDriver().findElement(By.xpath("//a[text()='SwitchTo']"));
        //Mergem cu mouse pe anumit element
        element.MoveToElement(SwitchToElem);//se muta pe un element si face perform


        WebElement clickFrames = getDriver().findElement(By.xpath("//a[text()='Frames']"));
        element.clickElement(clickFrames);

        //navigam catre un URL - metoda navigate nu asteapta sa incarce o pagina
        pElement.navigateToPage("http://demo.automationtesting.in/Frames.html");

        List<WebElement> FrameOptions = getDriver().findElements(By.cssSelector(".nav-tabs>li>a"));
        element.clickElement(FrameOptions.get(0));//facem click pe primul element


        //Ne mutam pe un Iframe=Iframe este un body mai mid dintre un body

        //getDriver().switchTo().frame("singleframe");//Linia aceasta ne-a bagat in acest frame/dreptunghi
        fElement.switchFrame("singleframe");
        WebElement input1 = getDriver().findElement(By.cssSelector("input[type='text']"));
        element.FillElement(input1,  "Am ajuns aici ");
        //input1.sendKeys("Am ajuns aici");//din toate iteractiunile frames dureaza cel mai mult
        fElement.switchDefault();//te scoate din orice frame este si te duce pe bodyul principal

        element.clickElement(FrameOptions.get(1));


        //Ne mutam pe un alt Frame

        fElement.switchFrame(getDriver().findElement(By.cssSelector("iframe[src='MultipleFrames.html']")));
        fElement.switchFrame(getDriver().findElement(By.cssSelector("iframe[src='SingleFrame.html']")));

        WebElement input2 = getDriver().findElement(By.cssSelector("input[type='text')"));
        element.fillElement(input2, "Acuma ma juns aici");
        fElement.switchDefault();

    }


}

