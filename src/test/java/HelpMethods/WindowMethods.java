package HelpMethods;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class WindowMethods {

    private   WebDriver driver;

    public WindowMethods(WebDriver driver){this.driver = driver; }
    public void moveSpecificTabWindow(Integer index){
        List<String> browserTabs=new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(browserTabs.get(index));

    }
    public void CloseCurrentTabWindow(){
        driver.close();

    }

}
