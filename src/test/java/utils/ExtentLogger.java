package utils;

import com.aventstack.extentreports.ExtentTest;

public class ExtentLogger {

    public static void info(String message) {

        ExtentTestManager.getTest()
                         .info(message);
    }

    public static void pass(String message) {

        ExtentTestManager.getTest()
                         .pass(message);
    }

    public static void fail(String message) {

        ExtentTestManager.getTest()
                         .fail(message);
    }
}