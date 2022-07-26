package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FinishPage extends BasePage{
    private final By checkoutCompletePageHeader = By.cssSelector(".header_secondary_container");
    private final By checkoutCompletePicture=By.cssSelector(".pony_express");

    public FinishPage(WebDriver driver) {
        super(driver);
    }
    public boolean isCheckoutCompletePageHeaderDisplayed(){
        return driver.findElement(checkoutCompletePageHeader).isDisplayed();
    }
   public boolean  isPonyPictureDisplayed() {
       return driver.findElement(checkoutCompletePicture).isDisplayed();
   }
    public void waitPonyPicture(){
        WebElement ponyPicture=(new WebDriverWait(driver, 5))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".pony_express")));
    }
}
