package Pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
@Log4j2
public class CartPage extends BasePage {

    @FindBy(css = ".header_secondary_container")
    private WebElement headerCartPage;

    @FindBy(css = ".inventory_item_name")
    private WebElement chosenItemName;

    @FindBy(css = ".inventory_item_desc")
    private WebElement chosenItemDescription;

    @FindBy(css = ".inventory_item_price")
    private WebElement chosenItemPrice;

    @FindBy(css = ".cart_quantity")
    private WebElement cartQuantity;

    @FindBy(xpath = "//button[@class='btn btn_secondary btn_small cart_button' and text()='Remove']")
    private WebElement removeButton;

    @FindBy(xpath = "//button[@class='btn btn_secondary back btn_medium' and text()='Continue Shopping']")
    private WebElement continueShoppingButton;

    @FindBy(xpath = "//button[@class='btn btn_action btn_medium checkout_button' and text()='Checkout']")
    private WebElement checkoutButton;

    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public boolean isHeaderCartPageDisplayed() {
        log.info("Header on cart page displayed");
        return headerCartPage.isDisplayed();
    }

    public String getChosenItemName() {
        log.info("Item name check");
        return chosenItemName.getText();
    }

    public String getChosenItemDescription() {
        log.info("Item description check");
        return chosenItemDescription.getText();
    }

    public String getChosenItemPrice() {
        log.info("Item price check");
        return chosenItemPrice.getText();
    }

    public boolean isCartQuantityDisplayed() {
        log.info("Cart Quantity on cart page displayed");
        return cartQuantity.isDisplayed();
    }

    public void clickRemoveButton() {

        removeButton.click();
    }

    public void clickContinueShoppingButton() {
        log.info("Click continue shopping button ");
        continueShoppingButton.click();
    }

    public void clickCheckoutButton() {
        log.info("Click checkout button ");
        checkoutButton.click();
    }
}
