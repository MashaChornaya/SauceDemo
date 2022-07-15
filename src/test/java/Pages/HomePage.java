package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class HomePage extends BasePage{
    private final By cartButtonLink=By.cssSelector(".shopping_cart_link");
    private final By burgerMenuButton=By.xpath("//button[@id='react-burger-menu-btn']");
    private final By burgerMenuAllItems=By.xpath("//a[@id='inventory_sidebar_link' and text()='All Items']");
    private final By burgerMenuAbout=By.xpath("//a[@id='about_sidebar_link' and text()='About']");
    private final By burgerMenuLogOut=By.xpath("//a[@id='logout_sidebar_link' and text()='Logout']");
    private final By burgerMenuResetAppState=By.xpath("//a[@id='reset_sidebar_link' and text()='Reset App State']");


    public HomePage(WebDriver driver) {

        super(driver);
    }
    public void clickCartButtonLink(){
        driver.findElement(cartButtonLink).click();
    }
    public void clickToBurgerMenu (){
        driver.findElement(burgerMenuButton).click();
    }
    public boolean isBurgerMenuAllItemsDisplayed() {
        return driver.findElement(burgerMenuAllItems).isDisplayed();
    }
    public boolean isBurgerMenuAboutDisplayed() {
        return driver.findElement(burgerMenuAbout).isDisplayed();
    }
    public boolean isBurgerMenuLogOutDisplayed() {
        return driver.findElement(burgerMenuLogOut).isDisplayed();
    }
    public boolean isBurgerMenuResetDisplayed() {
        return driver.findElement(burgerMenuResetAppState).isDisplayed();
    }
}
