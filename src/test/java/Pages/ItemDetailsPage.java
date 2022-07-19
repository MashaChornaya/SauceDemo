package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ItemDetailsPage extends HomePage {
    @FindBy(css = "button[id^=add-to-cart]")
    private WebElement addToCartButton;

    @FindBy(id = "back-to-products")
    private WebElement backToProductsButton;

    @FindBy(css = ".inventory_details_name")
    private WebElement itemName;
    @FindBy(css = ".inventory_details_desc")
    private WebElement itemDescription;
    @FindBy(css = ".inventory_details_price")
    private WebElement itemPrice;

    public ItemDetailsPage(WebDriver driver) {
        super(driver);
    }


    public void clickAddToCartButton() {
        addToCartButton.click();
    }

    public void clickBackToProductsButton() {
        backToProductsButton.click();
    }

    public String getItemName() {

        return itemName.getText();
    }

    public String getItemDescription() {
        return itemDescription.getText();
    }

    public String getItemPrice() {

        return itemPrice.getText();
    }

}
