package Tests;

import Pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CartTest extends BaseTest{
    final static String PRODUCT_NAME="Sauce Labs Fleece Jacket";
    ItemDetailsPage itemDetailsPage;
    ProductsPage productsPage;
    CheckoutPage checkoutPage;
    HomePage homePage;
    CartPage cartPage;


    @BeforeClass
    public void initialise(){
        itemDetailsPage=new ItemDetailsPage(driver);
        productsPage=new ProductsPage(driver);
        homePage=new HomePage(driver);
        checkoutPage=new CheckoutPage(driver);
        cartPage=new CartPage(driver);
    }
    @Test
    public void actionsOnCartPageTest() {
        loginPage.login("standard_user", "secret_sauce");
        productsPage.openItemByName(PRODUCT_NAME);
        Assert.assertEquals(itemDetailsPage.getItemName(), PRODUCT_NAME);
        Assert.assertEquals(itemDetailsPage.getItemPrice(), "$49.99");
        Assert.assertEquals(itemDetailsPage.getItemDescription(), "It's not every day that you come across a midweight quarter-zip fleece jacket capable of handling everything from a relaxing day outdoors to a busy day at the office.");
        itemDetailsPage.clickAddToCartButton();
        itemDetailsPage.clickBackToProductsButton();
        homePage.clickCartButtonLink();
        Assert.assertEquals(cartPage.getChoosenItemName(),"Sauce Labs Fleece Jacket");
        Assert.assertTrue(cartPage.isCartQuantityDisplayed());
        Assert.assertEquals(cartPage.getChoosenItemPrice(),"$49.99");
        Assert.assertEquals(cartPage.getChoosenItemDescription(),"It's not every day that you come across a midweight quarter-zip fleece jacket capable of handling everything from a relaxing day outdoors to a busy day at the office.");
        cartPage.clickContinueShoppingButton();
        Assert.assertTrue(productsPage.isProductsPageHeaderDisplayed());
        homePage.clickCartButtonLink();
        Assert.assertTrue(cartPage.isHeaderCartPageDisplayed());
        cartPage.clickCheckoutButton();
        Assert.assertTrue(checkoutPage.isHeaderCheckoutPageDisplayed());
    }
}
