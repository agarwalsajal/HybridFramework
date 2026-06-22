package tests;

import org.testng.annotations.Test;

import api.payloads.LoginData;
import utils.ScreenShotsUtil;
import base.BaseTest;
import driver.DriverFactory;
import pages.LoginPage;
import utils.ConfigReader;
import utils.JsonDataProvider;
import utils.LoggerUtil;

public class LoginTest extends BaseTest{

    @Test( dataProvider = "loginJsonData",
        dataProviderClass = JsonDataProvider.class)
    public void LoginTest(LoginData data)
    {
        LoggerUtil.logger.info("Framework Started");
         LoggerUtil.logger.info(
        "Starting Login Test");
        DriverFactory.getDriver().get(ConfigReader.getProperty("url"));  
        ScreenShotsUtil.captureScreenShot("LoginPage");    
        LoginPage page=new LoginPage(DriverFactory.getDriver());
        page.Login(data.getUsername(),data.getPassword());
        ScreenShotsUtil.captureScreenShot("AfterLogin");
        LoggerUtil.logger.info(
        "Login Test Completed");
    }

     @Test
    public void loginTest1() {

        System.out.println(
            "Thread Id : "
            + Thread.currentThread().threadId());
           
    }

    @Test
    public void loginTest2() {

        System.out.println(
            "Thread Id : "
            + Thread.currentThread().threadId());
    }

    @Test
    public void loginTest3() {

        System.out.println(
            "Thread Id : "
            + Thread.currentThread().threadId());
    }

    
    
}
