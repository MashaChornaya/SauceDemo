package Pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
@Log4j2

public class ItemDetailsPage extends HomePage {

    @FindBy(id = "back-to-products")
    private WebElement backToProductsButton;

    @FindBy(css = ".inventory_details_name")
    private WebElement itemName;
    @FindBy(css = ".inventory_details_desc")
    private WebElement itemDescription;
    @FindBy(css = ".inventory_details_price")
    private WebElement itemPrice;

    @FindBy(css="button[id^=add-to-cart]")
    private WebElement addToCartButton;

    public ItemDetailsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void clickBackToProductsButton() {
        log.info("Click to button for back to products");
        backToProductsButton.click();
    }

    public String getItemName() {
        log.info("Get item name");
        return itemName.getText();
    }
    public String getItemDescription(){
        log.info("Get item description");
        return itemDescription.getText();
    }

    public String getItemPrice() {
        log.info("Get item price");
        return itemPrice.getText();
    }
    public void clickAddToCardButton() {
        log.info("Click to cart button");
        addToCartButton.click();
    }

}
