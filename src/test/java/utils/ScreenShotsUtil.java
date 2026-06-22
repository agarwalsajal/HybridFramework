package utils;

import driver.DriverFactory;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public class ScreenShotsUtil {
    
    public static String captureScreenShot(String testName)
    {
    WebDriver driver=DriverFactory.getDriver();
    TakesScreenshot ts=(TakesScreenshot) driver;
    File src=ts.getScreenshotAs(OutputType.FILE);
       String destination =
                System.getProperty("user.dir")
                + "/screenshots/"
                + testName
                + "_"
                + System.currentTimeMillis()
                + ".png";

                  try {

            Files.createDirectories(
                    new File(
                        System.getProperty("user.dir")
                        + "/screenshots")
                        .toPath());

            Files.copy(
                    src.toPath(),
                    new File(destination).toPath(),
                    StandardCopyOption.REPLACE_EXISTING);

        } catch (IOException e) {

            e.printStackTrace();
        }

        return destination;
    }
    }



