package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(description = "Test 1", groups = {"Smoke"} )
    public void positiveLoginTest() {
        loginPage.setUserName(USERNAME);
        loginPage.setPassword(PASSWORD);
        loginPage.clickLoginButton();

    }
    @Test(groups = {"Regression", "Negative"},dataProvider = "negativeLoginTestData")
    public void negativeLoginTest(String userName, String password, String expectedErrorMassage) {
        loginPage.setUserName(userName);
        loginPage.setPassword(password);
        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.isErrorMassageDisplayed());
        Assert.assertEquals(loginPage.getErrorMassageText(), expectedErrorMassage);
        }
        @DataProvider()
        public Object[][] negativeLoginTestData(){
        return new Object[][]{
                {"",PASSWORD,"Epic sadface: Username is required"},
                {USERNAME,"","Epic sadface: Password is required"},
                {"locked_out_user",PASSWORD,"Epic sadface: Sorry, this user has been locked out"}
        };
        }
}


