package listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import utils.ExtentLogger;
import utils.LoggerUtil;

public class RetryAnalyzer implements IRetryAnalyzer {

private int count = 0;

    private static final int maxRetryCount = 2;

    @Override
    public boolean retry(
            ITestResult result) {

        if (count < maxRetryCount) {

            count++;

          LoggerUtil.logger.info(
                    "Retrying Test: "
                            + result.getName()
                            + " Attempt: "
                            + count);
         ExtentLogger.info(
        "Retry Attempt : "
        + count);

            return true;
        }

        return false;
    }
    
}
