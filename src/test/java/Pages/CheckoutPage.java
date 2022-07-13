package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage{

private final By checkoutPageHeader = By.xpath("//div[@class='header_secondary_container']");
private final By checkoutPageInputFirstName = By.xpath("//input[@placeholder='First Name']");
private final By checkoutPageInputLastName = By.xpath("//input[@placeholder='Last Name']");
private final By checkoutPageInputZipPostalCode = By.xpath("//input[@placeholder='Zip/Postal Code']");
private final By continueButton = By.cssSelector("#continue");

//private By errorMassageCheckoutPage= By.cssSelector(".error-message-container ");
private By errorMassageCheckoutPage =By.xpath("//h3[@data-test]");
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

        driver.findElement(checkoutPageInputFirstName).sendKeys(firstName);
    }
    public void setLastName(String lastName){

        driver.findElement(checkoutPageInputLastName).sendKeys(lastName);
    }
    public void setZipPostalCode(String zipPostalCode){
        driver.findElement(checkoutPageInputZipPostalCode).sendKeys(zipPostalCode);
    }
    public void clickContinueButton(){
        driver.findElement(continueButton).click();
    }

    public boolean isErrorMassageCheckoutPageDisplayed(){

        return  driver.findElement(errorMassageCheckoutPage).isDisplayed();
    }
    public String getErrorMassageCheckoutPageText(){

        return  driver.findElement(errorMassageCheckoutPage).getText();
    }
}
