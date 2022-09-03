package Pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
@Log4j2

public class ProductsPage extends HomePage {
    private final By cartButton = By.cssSelector("button[id^=add-to-cart]");
    private final By productLink = By.cssSelector("a[id$=_link]");
    private final String productContainerLocator
            = "//div[@class = 'inventory_item_name' and text() = '%s']/ancestor::div[@class='inventory_item']";
    private final By productsPageHeader = By.id("header_container");
    private final By productDescription = By.cssSelector(".inventory_item_desc");
    private final By productPrice = By.cssSelector(".inventory_item_price");

    public ProductsPage(WebDriver driver) {

        super(driver);
    }
    public boolean isProductsPageHeaderDisplayed() {
        return driver.findElement(productsPageHeader).isDisplayed();
    }

    public String getProductDescription(String productsName) {
        return driver.findElement(productDescription).getText();
    }

    public String getProductPrice(String productsName) {

        return driver.findElement(productPrice).getText();
    }
    public void openItemByName(String productsName) {
        log.info(String.format("Open Item with product name % from Base Test"));
        WebElement productContainer = getProductContainerByName(productsName);
        productContainer.findElement(productLink).click();
    }
    private WebElement getProductContainerByName(String productsName) {
        return driver.findElement(
                By.xpath(
                        String.format(productContainerLocator, productsName)
                )
        );
    }
}



