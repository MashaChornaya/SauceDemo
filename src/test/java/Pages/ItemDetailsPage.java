package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ItemDetailsPage extends HomePage {

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
        PageFactory.initElements(driver,this);
    }


    public void clickBackToProductsButton() {
        backToProductsButton.click();
    }

    public String getItemName() {

        return itemName.getText();
    }
    public String getItemDescription(){
        return itemDescription.getText();
    }


    public String getItemPrice() {

        return itemPrice.getText();
    }

}
