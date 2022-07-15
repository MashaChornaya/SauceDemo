package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPage extends BasePage{

    private final By checkoutOverviewPageHeader = By.cssSelector(".header_secondary_container");
    private final By finishButton = By.cssSelector("#finish");
    private final  By cancelButton = By.cssSelector("#cancel");

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }
    public boolean isCheckoutOverviewPageHeaderDisplayed(){
       return driver.findElement(checkoutOverviewPageHeader).isDisplayed();
    }
    public void clickCancelButton(){
         driver.findElement(cancelButton).click();
    }
    public void clickFinishButton(){
        driver.findElement(finishButton).click();
    }
}
