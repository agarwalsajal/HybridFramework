package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getInstance() {

        if(extent == null) {

            ExtentSparkReporter spark =
                new ExtentSparkReporter(
                    "reports/ExtentReport.html");

            spark.config().setReportName(
                "Hybrid Automation Report");

            spark.config().setDocumentTitle(
                "Execution Report");

            extent = new ExtentReports();

            extent.attachReporter(spark);

            extent.setSystemInfo(
                "Tester",
                "Sajal");
        }

        return extent;
    }
}