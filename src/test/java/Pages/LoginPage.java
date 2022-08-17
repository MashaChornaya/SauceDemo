package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

   private final By usernameInput= By.id("user-name");
   private final By passwordInput= By.id("password");
   private final By loginButton= By.id("login-button");
   private final By errorMassage= By.cssSelector(".error-massage-container");

    public LoginPage(WebDriver driver){

        super(driver);
    }
    public boolean isErrorMassageDisplayed(){

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

        driver.findElement(usernameInput).sendKeys(userName);
}
public void setPassword(String password){

        driver.findElement(passwordInput).sendKeys(password);
    }
    public void clickLoginButton(){
        driver.findElement(loginButton).click();
    }
}
