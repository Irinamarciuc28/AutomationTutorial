package ExtentUtility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;

public class ExtentReport {

    private ExtentSparkReporter HTMLReporter;
    private ExtentReports Extent;
    private ExtentTest TestReport;
    private final String PathToProject = System.getProperty("user.dir")+"/target/report/";


    public ExtentReport(String ReportName){
        //trebuie sa facem un Folder
        CreateDirectory();
        //trebuie sa curat vechile fisiere
        DeleteFiles();
        //trebuie sa fac raportul
        CreateReport(ReportName);
    }

    //Suport pentru Executia in Paralel
    public ExtentReport(){
        //trebuie sa facem un Folder
        CreateDirectory();
        //trebuie sa curat vechile fisiere
        DeleteFiles();
        //trebuie sa fac raportul
        CreateReport();
    }

    public void CreateDirectory(){
        File Directory = new File(PathToProject);
        if (!Directory.exists())
        {
            Directory.mkdirs();
        }
    }

    public void DeleteFiles(){
        File Directory = new File(PathToProject);
        //trebuie sa iau toate fisiserele din folder
        File[] ListFiles =  Directory.listFiles();
        for (Integer index = 0;index<ListFiles.length;index++){
            ListFiles[index].delete();
        }
    }
    public void CreateReport(String ReportName){
        HTMLReporter=new ExtentSparkReporter("target/report/"+ReportName+".html");
        HTMLReporter.config().setTheme(Theme.DARK);
        Extent=new ExtentReports();
        Extent.attachReporter(HTMLReporter);
        TestReport=Extent.createTest(""+ReportName+"- report");
    }

    public void CreateReport(){
        HTMLReporter=new ExtentSparkReporter("target/report/Report.html");
        HTMLReporter.config().setTheme(Theme.DARK);
        Extent=new ExtentReports();
        Extent.attachReporter(HTMLReporter);

    }

    public ExtentReports getExtent() {
        return Extent;
    }

    public ExtentTest getTestReport() {
        return TestReport;
    }
}
