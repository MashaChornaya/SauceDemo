package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutOverviewPage extends BasePage {
    @FindBy(css = ".header_secondary_container")
    private WebElement checkoutOverviewPageHeader;


    @FindBy(css = "#finish")
    private WebElement finishButton;


    @FindBy(css = "#cancel")
    private WebElement cancelButton;


    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    public boolean isCheckoutOverviewPageHeaderDisplayed() {
        return checkoutOverviewPageHeader.isDisplayed();
    }

    public void clickCancelButton() {
        cancelButton.click();
    }

    public void clickFinishButton() {
        finishButton.click();
    }
}
