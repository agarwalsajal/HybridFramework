package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import driver.DriverFactory;


public class BaseTest {
  
    @BeforeMethod

    public void setup()
    {
        DriverFactory.initDriver();
    }
    @AfterMethod

    public void tearDown()
    {
        DriverFactory.quitDriver();
    }

    
}
