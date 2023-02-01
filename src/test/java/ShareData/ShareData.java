package ShareData;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import javax.sound.midi.Soundbank;
import java.time.Duration;

public class ShareData {

    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }
    //folosim adnotarea de @before din TestNG


    public void Setup(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/Driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.automationtesting.in/Index.html");

        //Wait Implicit
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        //folosim @ After
    }


    public void Clear(){
        //inchiem un browser
        driver.quit();
        //driver.quit = inchide browserul cu oricate taburi deschise
        //close = inchide tabul curent

    }
}
