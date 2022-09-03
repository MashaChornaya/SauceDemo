package Pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
@Log4j2

public class LoginPage extends BasePage {

   private final By usernameInput= By.id("user-name");
   private final By passwordInput= By.id("password");
   private final By loginButton= By.id("login-button");
   private final By errorMassage= By.cssSelector(".error-massage-container");

    public LoginPage(WebDriver driver){

        super(driver);
    }
    public boolean isErrorMassageDisplayed(){
        log.info("Error massage displayed");
        return  driver.findElement(errorMassage).isDisplayed();
    }
    public String getErrorMassageText(){

        return  driver.findElement(errorMassage).getText();
    }

    public void login(String userName, String password){
        setUserName(userName);
        setPassword(password);
        clickLoginButton();
    }
public void setUserName(String userName){
        log.info(String.format("Set username % from Base test",userName));
        driver.findElement(usernameInput).sendKeys(userName);
}
public void setPassword(String password){
        log.info(String.format("Set password % from Base test",password));
        driver.findElement(passwordInput).sendKeys(password);
    }
    public void clickLoginButton(){
        log.info("click on login button");
        driver.findElement(loginButton).click();
    }
}
