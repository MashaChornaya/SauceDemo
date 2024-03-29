package Pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
@Log4j2
public class CheckoutPage extends BasePage{

private final By checkoutPageHeader = By.xpath("//div[@class='header_secondary_container']");
private final By checkoutPageInputFirstName = By.xpath("//input[@placeholder='First Name']");
private final By checkoutPageInputLastName = By.xpath("//input[@placeholder='Last Name']");
private final By checkoutPageInputZipPostalCode = By.xpath("//input[@placeholder='Zip/Postal Code']");
private final By continueButton = By.cssSelector("#continue");

private final By errorMassageCheckoutPage =By.xpath("//h3[@data-test]");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }
    public boolean isHeaderCheckoutPageDisplayed(){
        return driver.findElement(checkoutPageHeader).isDisplayed();
    }

    public void checkout(String firstName, String lastName, String zipPostalCode){
      setFirstName(firstName);
      setLastName(lastName);
      setZipPostalCode(zipPostalCode);
      clickContinueButton();
    }
    public void setFirstName(String firstName){
        log.info(String.format("Set name %s from Checkout Test",firstName));
        driver.findElement(checkoutPageInputFirstName).sendKeys(firstName);
    }
    public void setLastName(String lastName){
        log.info(String.format("Set lastname % from Checkout Test",lastName));
        driver.findElement(checkoutPageInputLastName).sendKeys(lastName);
    }
    public void setZipPostalCode(String zipPostalCode){
        log.info(String.format("Set Code % from Checkout Test",zipPostalCode));
        driver.findElement(checkoutPageInputZipPostalCode).sendKeys(zipPostalCode);
    }
    public void clickContinueButton(){
        log.info("Click continue button ");
        driver.findElement(continueButton).click();
    }

    public boolean isErrorMassageCheckoutPageDisplayed(){
        return  driver.findElement(errorMassageCheckoutPage).isDisplayed();
    }
    public String getErrorMassageCheckoutPageText(){

        return  driver.findElement(errorMassageCheckoutPage).getText();
    }
}
