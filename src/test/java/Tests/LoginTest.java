package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void positiveLoginTest() {
        loginPage.setUserName(USERNAME);
        loginPage.setPassword(PASSWORD);
        loginPage.clickLoginButton();
        WebElement productsPageEmblem = (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("header_container")));

        Assert.assertTrue(productsPageEmblem.isDisplayed());
    }
    @Test
    public void negativeLoginTest() {
        loginPage.setUserName("");
        loginPage.setPassword(PASSWORD);
        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.isErrorMassageDisplayed());
        Assert.assertEquals(loginPage.getErrorMassageText(), "Epic sadface: Username is required");
        }
    }


