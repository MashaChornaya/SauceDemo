package Tests;

import Pages.*;
import io.qameta.allure.*;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
@Log4j2
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
        log.info("Set user name and password from Base Test");
        loginPage.login(USERNAME, PASSWORD);
        log.info("Open Item with product name from Base Test");
        productsPage.openItemByName(PRODUCT_NAME);
        itemDetailsPage.clickAddToCardButton();
        itemDetailsPage.clickCartButtonLink();
        cartPage.clickCheckoutButton();
        Assert.assertTrue(checkoutPage.isHeaderCheckoutPageDisplayed());
        log.info("Set First Name from Checkout Test");
        checkoutPage.setFirstName(CHECKOUT_FIRST_NAME);
        log.info("Set Last Name from Checkout Test");
        checkoutPage.setLastName(CHECKOUT_LAST_NAME);
        log.info("Set Zip Postal Code from Checkout Test");
        checkoutPage.setZipPostalCode(CHECKOUT_ZIP_POSTAL_CODE);
        checkoutPage.clickContinueButton();
        Assert.assertTrue(checkoutOverviewPage.isCheckoutOverviewPageHeaderDisplayed());
    }

    @Test(description = "field-first name is null", groups = {"Regression","Negative"})
    public void negativeActionsOnCheckoutYourInfoPageTest() {
        log.info("Set user name and password from Base Test");
        loginPage.login(USERNAME, PASSWORD);
        log.info("Open Item with product name from Base Test");
        productsPage.openItemByName(PRODUCT_NAME);
        itemDetailsPage.clickAddToCardButton();
        itemDetailsPage.clickCartButtonLink();
        cartPage.clickCheckoutButton();
        Assert.assertTrue(checkoutPage.isHeaderCheckoutPageDisplayed());
        log.info("Set First Name from Checkout Test");
        checkoutPage.setFirstName("");
        log.info("Set Last Name from Checkout Test");
        checkoutPage.setLastName(CHECKOUT_LAST_NAME);
        log.info("Set Zip Postal Code from Checkout Test");
        checkoutPage.setZipPostalCode(CHECKOUT_ZIP_POSTAL_CODE);
        checkoutPage.clickContinueButton();
        Assert.assertTrue(checkoutPage.isErrorMassageCheckoutPageDisplayed());
        Assert.assertEquals(checkoutPage.getErrorMassageCheckoutPageText(), "Error: First Name is required");
    }
    @Test(description = "all fields are filled in correctly.Checkout Overview Page is displayed,but user click button 'Cancel'",groups = {"Regression","Negative"})
    public void cancelActionOnCheckoutOverviewPageTest() {
        log.info("Set user name and password from Base Test");
        loginPage.login(USERNAME, PASSWORD);
        log.info("Open Item with product name from Base Test");
        productsPage.openItemByName(PRODUCT_NAME);
        itemDetailsPage.clickAddToCardButton();
        itemDetailsPage.clickCartButtonLink();
        cartPage.clickCheckoutButton();
        Assert.assertTrue(checkoutPage.isHeaderCheckoutPageDisplayed());
        log.info("Set First Name from Checkout Test");
        checkoutPage.setFirstName(CHECKOUT_FIRST_NAME);
        log.info("Set Last Name from Checkout Test");
        checkoutPage.setLastName(CHECKOUT_LAST_NAME);
        log.info("Set Zip Postal Code from Checkout Test");
        checkoutPage.setZipPostalCode(CHECKOUT_ZIP_POSTAL_CODE);
        checkoutPage.clickContinueButton();
        Assert.assertTrue(checkoutOverviewPage.isCheckoutOverviewPageHeaderDisplayed());
        checkoutOverviewPage.clickCancelButton();
        Assert.assertTrue(productsPage.isProductsPageHeaderDisplayed());
    }

    @Test(description = "Checkout was correctly",groups = {"Smoke"})
    public void finishActionOnCheckoutOverviewPageTest() {
        log.info("Set user name and password from Base Test");
        loginPage.login(USERNAME, PASSWORD);
        log.info("Open Item with product name from Base Test");
        productsPage.openItemByName(PRODUCT_NAME);
        itemDetailsPage.clickAddToCardButton();
        itemDetailsPage.clickCartButtonLink();
        cartPage.clickCheckoutButton();
        Assert.assertTrue(checkoutPage.isHeaderCheckoutPageDisplayed());
        log.info("Set First Name from Checkout Test");
        checkoutPage.setFirstName(CHECKOUT_FIRST_NAME);
        log.info("Set Last Name from Checkout Test");
        checkoutPage.setLastName(CHECKOUT_LAST_NAME);
        log.info("Set Zip Postal Code from Checkout Test");
        checkoutPage.setZipPostalCode(CHECKOUT_ZIP_POSTAL_CODE);
        checkoutPage.clickContinueButton();
        Assert.assertTrue(checkoutOverviewPage.isCheckoutOverviewPageHeaderDisplayed());
        checkoutOverviewPage.clickFinishButton();
        Assert.assertTrue(finishPage.isCheckoutCompletePageHeaderDisplayed());
        Assert.assertTrue(finishPage.waitPonyPicture());
        Assert.assertTrue(finishPage.isPonyPictureDisplayed());
    }
}
