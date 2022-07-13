package Tests;

import Pages.*;
import com.beust.ah.A;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest{
    final static String PRODUCT_NAME="Sauce Labs Fleece Jacket";
    ItemDetailsPage itemDetailsPage;
    ProductsPage productsPage;
    CheckoutPage checkoutPage;
    HomePage homePage;
    CartPage cartPage;
    CheckoutOverviewPage checkoutOverviewPage;
    FinishPage  finishPage;


    @BeforeClass
    public void initialise(){
        itemDetailsPage=new ItemDetailsPage(driver);
        productsPage=new ProductsPage(driver);
        homePage=new HomePage(driver);
        checkoutPage=new CheckoutPage(driver);
        cartPage=new CartPage(driver);
        checkoutOverviewPage=new CheckoutOverviewPage(driver);
        finishPage= new FinishPage(driver);
    }
    @Test
    public void positiveActionsOnCheckoutYourInfoPageTest() {
        loginPage.login("standard_user", "secret_sauce");
        productsPage.openItemByName(PRODUCT_NAME);
        itemDetailsPage.clickAddToCartButton();
        homePage.clickCartButtonLink();
        cartPage.clickCheckoutButton();
        Assert.assertTrue(checkoutPage.isHeaderCheckoutPageDisplayed());
        checkoutPage.setFirstName("Lev");
        checkoutPage.setLastName("Tolstoy");
        checkoutPage.setZipPostalCode("12345");
        checkoutPage.clickContinueButton();
        Assert.assertTrue(checkoutOverviewPage.isCheckoutOverviewPageHeaderDisplayed());
    }
    @Test
    public void negativeActionsOnCheckoutYourInfoPageTest() {
        loginPage.login("standard_user", "secret_sauce");
        productsPage.openItemByName(PRODUCT_NAME);
        itemDetailsPage.clickAddToCartButton();
        homePage.clickCartButtonLink();
        cartPage.clickCheckoutButton();
        Assert.assertTrue(checkoutPage.isHeaderCheckoutPageDisplayed());
        checkoutPage.setFirstName("");
        checkoutPage.setLastName("Tolstoy");
        checkoutPage.setZipPostalCode("12345");
        checkoutPage.clickContinueButton();
        Assert.assertTrue(checkoutPage.isErrorMassageCheckoutPageDisplayed());
        Assert.assertEquals(checkoutPage.getErrorMassageCheckoutPageText(), "Error: First Name is required");
    }

    @Test
    public void cancelActionOnCheckoutOverviewPageTest() {
        loginPage.login("standard_user", "secret_sauce");
        productsPage.openItemByName(PRODUCT_NAME);
        itemDetailsPage.clickAddToCartButton();
        homePage.clickCartButtonLink();
        cartPage.clickCheckoutButton();
        Assert.assertTrue(checkoutPage.isHeaderCheckoutPageDisplayed());
        checkoutPage.setFirstName("Lev");
        checkoutPage.setLastName("Tolstoy");
        checkoutPage.setZipPostalCode("12345");
        checkoutPage.clickContinueButton();
        Assert.assertTrue(checkoutOverviewPage.isCheckoutOverviewPageHeaderDisplayed());
        checkoutOverviewPage.clickCancelButton();
        Assert.assertTrue(productsPage.isProductsPageHeaderDisplayed());
    }
    @Test
    public void finishActionOnCheckoutOverviewPageTest() {
        loginPage.login("standard_user", "secret_sauce");
        productsPage.openItemByName(PRODUCT_NAME);
        itemDetailsPage.clickAddToCartButton();
        homePage.clickCartButtonLink();
        cartPage.clickCheckoutButton();
        Assert.assertTrue(checkoutPage.isHeaderCheckoutPageDisplayed());
        checkoutPage.setFirstName("Lev");
        checkoutPage.setLastName("Tolstoy");
        checkoutPage.setZipPostalCode("12345");
        checkoutPage.clickContinueButton();
        Assert.assertTrue(checkoutOverviewPage.isCheckoutOverviewPageHeaderDisplayed());
        checkoutOverviewPage.clickFinishButton();
        Assert.assertTrue(finishPage.isCheckoutCompletePageHeaderDisplayed());
    }
}
