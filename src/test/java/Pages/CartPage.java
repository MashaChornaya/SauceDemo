package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage{
    private final By headerCartPage = By.cssSelector(".header_secondary_container");
    private final By choosenItemName = By.cssSelector(".inventory_item_name");
    private final By choosenItemDescription=By.cssSelector(".inventory_item_desc");
    private final By choosenItemPrice = By.cssSelector(".inventory_item_price");
    private final By cartQuantity = By.cssSelector(".cart_quantity");
    private final By removeButton = By.xpath("//button[@class='btn btn_secondary btn_small cart_button' and text()='Remove']");
    private final By continueShoppingButton = By.xpath("//button[@class='btn btn_secondary back btn_medium' and text()='Continue Shopping']");
    private final By checkoutButton = By.xpath("//button[@class='btn btn_action btn_medium checkout_button' and text()='Checkout']");

    public CartPage(WebDriver driver) {

        super(driver);
    }
    public boolean isHeaderCartPageDisplayed() {return driver.findElement(headerCartPage).isDisplayed();}

    public String getChoosenItemName() {
        return driver.findElement(choosenItemName).getText();
    }

    public String getChoosenItemDescription(){return driver.findElement(choosenItemDescription).getText();}
    public String getChoosenItemPrice() {
        return driver.findElement(choosenItemPrice).getText();
    }
    public boolean isCartQuantityDisplayed() {
        return driver.findElement(cartQuantity).isDisplayed();
    }

    public void clickRemoveButton() {

        driver.findElement(removeButton).click();
    }
    public void clickContinueShoppingButton() {

        driver.findElement(continueShoppingButton).click();
    }
    public void clickCheckoutButton() {

        driver.findElement(checkoutButton).click();
    }
}
