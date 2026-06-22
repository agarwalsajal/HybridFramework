package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import utils.ExtentManager;
import utils.ExtentTestManager;

public class ExtentListeners
        implements ITestListener {

    ExtentReports extent =
            ExtentManager.getInstance();

             private static ThreadLocal<ExtentTest> extentTest =
            new ThreadLocal<>();

    ExtentTest test;

  @Override
public void onTestStart(ITestResult result) {
  System.out.println("Extent Listener Started");
    ExtentTest test =
            ExtentManager.getInstance()
                         .createTest(result.getMethod().getMethodName());

    ExtentTestManager.setTest(test);
    System.out.println("Extent Listener Started");
}

    @Override
    public void onTestSuccess(
            ITestResult result) {

       ExtentTestManager.getTest()
                 .pass("Test Passed");
    }

    @Override
    public void onTestFailure(
            ITestResult result) {

        ExtentTestManager.getTest()
                 .fail(result.getThrowable());
    }

    @Override
    public void onTestSkipped(
            ITestResult result) {

        ExtentTestManager.getTest()
                 .skip("Test Skipped");
    }

    @Override
    public void onFinish(
            ITestContext context) {

        extent.flush();
    }
}