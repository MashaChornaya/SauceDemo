package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FinishPage extends BasePage{
    private final By checkoutCompletePageHeader = By.cssSelector(".header_secondary_container");


    public FinishPage(WebDriver driver) {
        super(driver);
    }
    public boolean isCheckoutCompletePageHeaderDisplayed(){
        return driver.findElement(checkoutCompletePageHeader).isDisplayed();
    }
}
