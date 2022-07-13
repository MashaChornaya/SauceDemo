package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void positiveLoginTest() {
        loginPage.setUserName("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();
        Assert.assertTrue(productsPage.isProductsPageHeaderDisplayed());
    }
    @Test
    public void negativeLoginTest() {
        loginPage.setUserName("");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.isErrorMassageDisplayed());
        Assert.assertEquals(loginPage.getErrorMassageText(), "Epic sadface: Username is required");
        }
    }


