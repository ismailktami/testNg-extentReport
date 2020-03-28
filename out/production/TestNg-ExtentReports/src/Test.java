import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import environement.ExtentInitializer;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class Test extends ExtentInitializer{

   @org.testng.annotations.Test(testName = "hay")
    public void test(){
      logger=extent.startTest("passedTest");
      Assert.assertTrue(true);
  }
  @org.testng.annotations.Test
    public void test2(){
      logger=extent.startTest("failedTest");
      Assert.assertTrue(false);
  }


}
