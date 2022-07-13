package Tests;

import Pages.CartPage;
import Pages.ItemDetailsPage;
import Pages.LoginPage;
import Pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ItemDetailsTest extends BaseTest{
    final static String PRODUCT_NAME="Sauce Labs Fleece Jacket";
   ItemDetailsPage itemDetailsPage;
   ProductsPage productsPage;
   LoginPage loginPage;
   CartPage cartPage;

   @BeforeClass
   public void initialise(){

       itemDetailsPage=new ItemDetailsPage(driver);
       productsPage=new ProductsPage(driver);
       loginPage=new LoginPage(driver);
       cartPage=new CartPage(driver);
   }
    @Test
    public void verifyItemNameAndPriceOnDetailsPageTest() {
        loginPage.login("standard_user", "secret_sauce");
        productsPage.openItemByName(PRODUCT_NAME);
        Assert.assertEquals(itemDetailsPage.getItemName(), PRODUCT_NAME);
        Assert.assertEquals(itemDetailsPage.getItemPrice(), "$49.99");
        Assert.assertEquals(itemDetailsPage.getItemDescription(), "It's not every day that you come across a midweight quarter-zip fleece jacket capable of handling everything from a relaxing day outdoors to a busy day at the office.");
        itemDetailsPage.clickAddToCartButton();
    }
    @Test
    public void openCheckCartPageTest() {
        loginPage.login("standard_user", "secret_sauce");
        productsPage.openItemByName(PRODUCT_NAME);
        Assert.assertEquals(itemDetailsPage.getItemName(), PRODUCT_NAME);
        Assert.assertEquals(itemDetailsPage.getItemPrice(),"$49.99");
        Assert.assertEquals(itemDetailsPage.getItemDescription(), "It's not every day that you come across a midweight quarter-zip fleece jacket capable of handling everything from a relaxing day outdoors to a busy day at the office.");
        itemDetailsPage.clickAddToCartButton();
        itemDetailsPage.clickCartButtonLink();
        Assert.assertTrue(cartPage.isCartQuantityDisplayed());
    }
       @Test
    public void openBurgerMenuTest() {
           loginPage.login("standard_user", "secret_sauce");
           productsPage.clickToBurgerMenu();
           Assert.assertTrue(productsPage.isBurgerMenuAllItemsDisplayed());
           Assert.assertTrue(productsPage.isBurgerMenuAboutDisplayed());
           Assert.assertTrue(productsPage.isBurgerMenuLogOutDisplayed());
           Assert.assertTrue(productsPage.isBurgerMenuResetDisplayed());
       }
    }

