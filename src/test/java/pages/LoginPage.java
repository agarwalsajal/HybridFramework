package pages;
import org.openqa.selenium.*;

import utils.LoggerUtil;
import utils.WaitUtils;
public class LoginPage extends BasePage{

    WebDriver driver ;

    public LoginPage(WebDriver driver)
    {
        super(driver);
    }

    By username=By.xpath("//input[@data-qa='login-email']");
    By password=By.xpath("//input[@data-qa='login-password']");
    By loginButton=By.xpath("//button[@data-qa='login-button']");
    public void Login(String user, String pass)
    {
        LoggerUtil.logger.info(
        "Entering Username");
        type(username,user);

    LoggerUtil.logger.info(
        "Entering Password");
        type(password,pass);
         LoggerUtil.logger.info(
        "Clicking Login Button");
        click(loginButton);

    }

    
}
