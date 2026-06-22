package base;

import org.testng.annotations.*;

import com.aventstack.extentreports.*;

import utils.ExtentManager;

public class ApiBaseTest {

    protected static ExtentReports extent;

    protected ExtentTest test;

    @BeforeSuite
    public void setupReport() {

        extent =
            ExtentManager.getInstance();
    }

    @AfterSuite
    public void flushReport() {

        extent.flush();
    }
}