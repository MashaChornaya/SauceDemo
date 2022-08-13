package Tests;

import Pages.CartPage;
import Pages.ItemDetailsPage;
import Pages.LoginPage;
import Pages.ProductsPage;
import io.qameta.allure.*;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
@Log4j2
public class ItemDetailsTest extends BaseTest{
   ItemDetailsPage itemDetailsPage;
   ProductsPage productsPage;
   LoginPage loginPage;
   CartPage cartPage;

   @BeforeClass (alwaysRun = true)
   public void initialise(){

       itemDetailsPage=new ItemDetailsPage(driver);
       productsPage=new ProductsPage(driver);
       loginPage=new LoginPage(driver);
       cartPage=new CartPage(driver);
   }
    @Test(groups={"Regression"},dataProvider = "inventoryItemsTestData")
    @Description("Check item name, price and description")
    @Severity(SeverityLevel.NORMAL)
    @Link("https://www.saucedemo.com")
    @TmsLink("6")
    public void inventoryItemsTest(String itemName, String itemPrice, String itemDescription) {
        log.info("Set user name and password from Base Test");
        loginPage.login(USERNAME, PASSWORD);
        log.info("Open Item with product links from Products Page and name from data provider");
        productsPage.openItemByName(itemName);
        Assert.assertEquals(itemDetailsPage.getItemName(), itemName);
        Assert.assertEquals(itemDetailsPage.getItemPrice(), itemPrice);
        Assert.assertEquals(itemDetailsPage.getItemDescription(), itemDescription);
    }
    @DataProvider()
    public Object[][] inventoryItemsTestData(){
       return new Object[][]{
               {"Sauce Labs Backpack","$29.99","carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection."},
               {"Sauce Labs Bike Light","$9.99","A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included."},
               {"Sauce Labs Bolt T-Shirt","$15.99","Get your testing superhero on with the Sauce Labs bolt T-shirt. From American Apparel, 100% ringspun combed cotton, heather gray with red bolt."},
               {"Sauce Labs Fleece Jacket","$49.99","It's not every day that you come across a midweight quarter-zip fleece jacket capable of handling everything from a relaxing day outdoors to a busy day at the office."},
               {"Sauce Labs Onesie","$7.99","Rib snap infant onesie for the junior automation engineer in development. Reinforced 3-snap bottom closure, two-needle hemmed sleeved and bottom won't unravel."},
               {"Test.allTheThings() T-Shirt (Red)","$15.99","This classic Sauce Labs t-shirt is perfect to wear when cozying up to your keyboard to automate a few tests. Super-soft and comfy ringspun combed cotton."}
       };
    }
    @Test(description ="open cart page" ,groups = {"Smoke"})
    public void openCheckCartPageTest() {
        log.info("Set user name and password from Base Test");
        loginPage.login(USERNAME, PASSWORD);
        log.info("Open Item with product name from Base Test");
        productsPage.openItemByName(PRODUCT_NAME);
        Assert.assertEquals(itemDetailsPage.getItemName(), PRODUCT_NAME);
        Assert.assertEquals(itemDetailsPage.getItemPrice(),"$49.99");
        Assert.assertEquals(itemDetailsPage.getItemDescription(), "It's not every day that you come across a midweight quarter-zip fleece jacket capable of handling everything from a relaxing day outdoors to a busy day at the office.");
        itemDetailsPage.clickAddToCardButton();
        itemDetailsPage.clickCartButtonLink();
        Assert.assertTrue(cartPage.isCartQuantityDisplayed());
    }
       @Test(description = "check for all strings of Burger menu",groups = {"Regression"})
    public void openBurgerMenuTest() {
           log.info("Set user name and password from Base Test");
           loginPage.login(USERNAME, PASSWORD);
           log.info("Open burger menu");
           productsPage.clickToBurgerMenu();
           Assert.assertTrue(productsPage.isBurgerMenuAllItemsDisplayed());
           Assert.assertTrue(productsPage.isBurgerMenuAboutDisplayed());
           Assert.assertTrue(productsPage.isBurgerMenuLogOutDisplayed());
           Assert.assertTrue(productsPage.isBurgerMenuResetDisplayed());
       }
    }

