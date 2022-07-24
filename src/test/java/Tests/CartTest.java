package Tests;

import Pages.*;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CartTest extends BaseTest{
    ItemDetailsPage itemDetailsPage;
    ProductsPage productsPage;
    CheckoutPage checkoutPage;
    CartPage cartPage;


    @BeforeClass
    public void initialise(){

        productsPage=new ProductsPage(driver);
        checkoutPage=new CheckoutPage(driver);
        cartPage=new CartPage(driver);
        itemDetailsPage=new ItemDetailsPage(driver);
    }
    @Test(groups = {"Smoke"})
    public void actionsOnCartPageTest() {
        loginPage.login("standard_user", "secret_sauce");
        productsPage.openItemByName(PRODUCT_NAME);
        Assert.assertEquals(itemDetailsPage.getItemName(), PRODUCT_NAME);
        Assert.assertEquals(itemDetailsPage.getItemPrice(), "$49.99");
        Assert.assertEquals(itemDetailsPage.getItemDescription(),
                "It's not every day that you come across a midweight quarter-zip fleece jacket capable of handling everything from a relaxing day outdoors to a busy day at the office.");
        itemDetailsPage.clickAddToCardButton();
        itemDetailsPage.clickBackToProductsButton();
        itemDetailsPage.clickCartButtonLink();
        Assert.assertEquals(cartPage.getChosenItemName(),"Sauce Labs Fleece Jacket");
        Assert.assertTrue(cartPage.isCartQuantityDisplayed());
        Assert.assertEquals(cartPage.getChosenItemPrice(),"$49.99");
        Assert.assertEquals(cartPage.getChosenItemDescription(),
                "It's not every day that you come across a midweight quarter-zip fleece jacket capable of handling everything from a relaxing day outdoors to a busy day at the office.");
        cartPage.clickContinueShoppingButton();
        Assert.assertTrue(productsPage.isProductsPageHeaderDisplayed());
        productsPage.clickCartButtonLink();
        Assert.assertTrue(cartPage.isHeaderCartPageDisplayed());
        cartPage.clickCheckoutButton();
        Assert.assertTrue(checkoutPage.isHeaderCheckoutPageDisplayed());
    }
}
