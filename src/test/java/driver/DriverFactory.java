package driver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utils.ConfigReader;

import org.openqa.selenium.WebDriver;
public class DriverFactory {

     private static ThreadLocal<WebDriver> driver=new ThreadLocal<>();

    public static void initDriver()
    {
         String browser = ConfigReader.getProperty("browser");
          WebDriver webDriver = null;

    if(browser.equalsIgnoreCase("chrome")) {
        webDriver = new ChromeDriver();
    }
    else if(browser.equalsIgnoreCase("firefox")) {
        webDriver = new FirefoxDriver();
    }
    else if(browser.equalsIgnoreCase("edge")) {
        webDriver = new EdgeDriver();
    }
        driver.set(webDriver);
        getDriver().manage().window().maximize();
    }


    public static WebDriver getDriver()
    {
        return driver.get();
    }
    public static void quitDriver()
    {
        if(getDriver()!=null)
        {
            getDriver().quit();
            driver.remove();
        }
    }
    
}
