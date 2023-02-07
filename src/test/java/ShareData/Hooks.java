package ShareData;

import ExtentUtility.ExtentReport;
import InputFile.PropertiesUtility;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.model.Log;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Hooks extends  ShareData{

    public HashMap<String, String> TestData;
    private String TestName;

    //Implementam o logica de generare a unui singur raport pentru N teste

    public static ExtentReport ExtentReportUtility= new ExtentReport();
    public static List<Log>LogContext = new ArrayList<>();
    public ExtentReport TestReport;


    @BeforeMethod
    public void PrepareEnvironment(){
        Setup();
        TestName = this.getClass().getSimpleName();
        PropertiesUtility propertiesUtility = new PropertiesUtility(TestName);
        TestData = propertiesUtility.GetAllData();
        TestReport =  new ExtentReport(TestName);


    }
    @AfterMethod
    public void ClearEnvironment(ITestResult Result){

        //trebuie sa tratam cazul cand cade un test
        if (Result.getStatus()==ITestResult.FAILURE){

        }
        //facem o logica care sa genereze raportul inainte sa inchida driverul
        synchronized (ExtentReportUtility){
            ExtentTest CurentTest = ExtentReportUtility.getExtent().createTest(""+TestName+"- report");
            LogContext.addAll(TestReport.getTestReport().getModel().getLogs());
            for (Log log:LogContext){
                CurentTest.getModel().getLogs().add(log);
            }
            ExtentReportUtility.getExtent().flush();
            LogContext.clear();
        }
        Clear();

    }
}
