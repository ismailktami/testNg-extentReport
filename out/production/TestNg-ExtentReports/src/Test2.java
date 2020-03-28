import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import environement.ExtentInitializer;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class Test2 extends ExtentInitializer {
    @Test
    public void test(){
        logger=extent.startTest("test started");
        Assert.assertTrue(false);
    }


}
