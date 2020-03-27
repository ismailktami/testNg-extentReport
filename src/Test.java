import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.model.Log;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

import java.io.File;

public class Test {
    ExtentReports extent;
    ExtentTest logger;

  @org.testng.annotations.BeforeTest
    public void initializeContext(){
        extent=new ExtentReports(System.getProperty("user.dir")+"/test-output/Exemple.html",true);
        extent.addSystemInfo("host name","Software")
                .addSystemInfo("Environemment","Testing")
                .addSystemInfo("User Name","ismail")
        ;
        extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));

  }

  @org.testng.annotations.Test
    public void test(){
      logger=extent.startTest("passedTest");
      Assert.assertTrue(true);
      logger.log(LogStatus.PASS,"Test Case passed in passedTest");
  }
  @org.testng.annotations.Test
    public void test2(){
      logger=extent.startTest("failedTest");
      Assert.assertTrue(false);
      logger.log(LogStatus.FAIL,"Test Case passed in failedTest");
  }

  @AfterMethod
   public void getResult(ITestResult result){
      if(result.getStatus()==ITestResult.FAILURE)
          logger.log(LogStatus.FAIL,"Test case failes is "+result.getName());
      else if(result.getStatus()==ITestResult.SKIP)
          logger.log(LogStatus.SKIP,"Test case failed is "+result.getName());

      extent.endTest(logger);
  }
  @AfterTest
    public void endreport(){
      extent.flush();
      extent.close();
  }


}
