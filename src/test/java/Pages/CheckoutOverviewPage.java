package Pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
@Log4j2

public class CheckoutOverviewPage extends BasePage {
    @FindBy(css = ".header_secondary_container")
    private WebElement checkoutOverviewPageHeader;


    @FindBy(css = "#finish")
    private WebElement finishButton;


    @FindBy(css = "#cancel")
    private WebElement cancelButton;


    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public boolean isCheckoutOverviewPageHeaderDisplayed() {
        return checkoutOverviewPageHeader.isDisplayed();
    }

    public void clickCancelButton() {
        log.info("Click cancel button ");
        cancelButton.click();
    }

    public void clickFinishButton() {
        log.info("Click finish button ");
        finishButton.click();
    }
}
