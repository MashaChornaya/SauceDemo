package Tests;

import Pages.*;
import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Collections;

public class CheckoutTest extends BaseTest {
    final static String CHECKOUT_FIRST_NAME = "Lev";
    final static String CHECKOUT_LAST_NAME = "Tolstoy";
    final static String CHECKOUT_ZIP_POSTAL_CODE = "12345";
    ItemDetailsPage itemDetailsPage;
    ProductsPage productsPage;
    CheckoutPage checkoutPage;
    CartPage cartPage;
    CheckoutOverviewPage checkoutOverviewPage;
    FinishPage finishPage;


    @BeforeClass(alwaysRun = true)
    public void initialise() {
        itemDetailsPage = new ItemDetailsPage (driver);
        productsPage = new ProductsPage(driver);
        checkoutPage = new CheckoutPage(driver);
        cartPage = new CartPage(driver);
        checkoutOverviewPage = new CheckoutOverviewPage(driver);
        finishPage = new FinishPage(driver);
    }

    @Test(groups = {"Smoke"}, description = "all fields are filled in correctly")
    @Description("Successful addition and checkout")
    @Severity(SeverityLevel.CRITICAL)
    @Link("https://www.saucedemo.com")
    @TmsLink("5")
    public void positiveActionsOnCheckoutYourInfoPageTest() {
        loginPage.login(USERNAME, PASSWORD);
        productsPage.openItemByName(PRODUCT_NAME);
        itemDetailsPage.clickAddToCardButton();
        itemDetailsPage.clickCartButtonLink();
        cartPage.clickCheckoutButton();
        Assert.assertTrue(checkoutPage.isHeaderCheckoutPageDisplayed());
        checkoutPage.setFirstName(CHECKOUT_FIRST_NAME);
        checkoutPage.setLastName(CHECKOUT_LAST_NAME);
        checkoutPage.setZipPostalCode(CHECKOUT_ZIP_POSTAL_CODE);
        checkoutPage.clickContinueButton();
        Assert.assertTrue(checkoutOverviewPage.isCheckoutOverviewPageHeaderDisplayed());
    }

    @Test(description = "field-first name is null", groups = {"Regression","Negative"})
    public void negativeActionsOnCheckoutYourInfoPageTest() {
        loginPage.login(USERNAME, PASSWORD);
        productsPage.openItemByName(PRODUCT_NAME);
        itemDetailsPage.clickAddToCardButton();
        itemDetailsPage.clickCartButtonLink();
        cartPage.clickCheckoutButton();
        Assert.assertTrue(checkoutPage.isHeaderCheckoutPageDisplayed());
        checkoutPage.setFirstName("");
        checkoutPage.setLastName(CHECKOUT_LAST_NAME);
        checkoutPage.setZipPostalCode(CHECKOUT_ZIP_POSTAL_CODE);
        checkoutPage.clickContinueButton();
        Assert.assertTrue(checkoutPage.isErrorMassageCheckoutPageDisplayed());
        Assert.assertEquals(checkoutPage.getErrorMassageCheckoutPageText(), "Error: First Name is required");
    }
    @Test(description = "all fields are filled in correctly.Checkout Overview Page is displayed,but user click button 'Cancel'",groups = {"Regression","Negative"})
    public void cancelActionOnCheckoutOverviewPageTest() {
        loginPage.login(USERNAME, PASSWORD);
        productsPage.openItemByName(PRODUCT_NAME);
        itemDetailsPage.clickAddToCardButton();
        itemDetailsPage.clickCartButtonLink();
        cartPage.clickCheckoutButton();
        Assert.assertTrue(checkoutPage.isHeaderCheckoutPageDisplayed());
        checkoutPage.setFirstName(CHECKOUT_FIRST_NAME);
        checkoutPage.setLastName(CHECKOUT_LAST_NAME);
        checkoutPage.setZipPostalCode(CHECKOUT_ZIP_POSTAL_CODE);
        checkoutPage.clickContinueButton();
        Assert.assertTrue(checkoutOverviewPage.isCheckoutOverviewPageHeaderDisplayed());
        checkoutOverviewPage.clickCancelButton();
        Assert.assertTrue(productsPage.isProductsPageHeaderDisplayed());
    }

    @Test(description = "Checkout was correctly",groups = {"Smoke"})

    public void finishActionOnCheckoutOverviewPageTest() {
        loginPage.login(USERNAME, PASSWORD);
        productsPage.openItemByName(PRODUCT_NAME);
        itemDetailsPage.clickAddToCardButton();
        itemDetailsPage.clickCartButtonLink();
        cartPage.clickCheckoutButton();
        Assert.assertTrue(checkoutPage.isHeaderCheckoutPageDisplayed());
        checkoutPage.setFirstName(CHECKOUT_FIRST_NAME);
        checkoutPage.setLastName(CHECKOUT_LAST_NAME);
        checkoutPage.setZipPostalCode(CHECKOUT_ZIP_POSTAL_CODE);
        checkoutPage.clickContinueButton();
        Assert.assertTrue(checkoutOverviewPage.isCheckoutOverviewPageHeaderDisplayed());
        checkoutOverviewPage.clickFinishButton();
        Assert.assertTrue(finishPage.isCheckoutCompletePageHeaderDisplayed());
        finishPage.waitPonyPicture();
        Assert.assertTrue(finishPage.isPonyPictureDisplayed());

    }
}
