package environement;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;

public class ExtentInitializer {
    //System.getProperty("user.dir")+"/test-output/Exemple.html",true
    //        extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));

    public static ExtentReports extent;
    public static ExtentTest logger;

    @BeforeSuite
    public void setUp() {
        extent = new ExtentReports(System.getProperty("user.dir")+"/test-output/Exemple.html",true);
        extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));

    }

    @AfterMethod
    public void getResult(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            logger.log(LogStatus.FAIL, result.getThrowable());

        } else if (result.getStatus() == ITestResult.SUCCESS) {
            logger.log(LogStatus.PASS, result.getName());
        } else {
            logger.log(LogStatus.SKIP,result.getThrowable());
        }
    }

    @AfterSuite
    public void tearDown() {
        extent.flush();
    }

}
