package Pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
@Log4j2

public abstract class HomePage extends BasePage{
    private final By cartButtonLink=By.cssSelector(".shopping_cart_link");
    private final By burgerMenuButton=By.xpath("//button[@id='react-burger-menu-btn']");
    private final By burgerMenuAllItems=By.xpath("//nav[@class='bm-item-list']/a[@id='inventory_sidebar_link']");
    private final By burgerMenuAbout=By.xpath("//nav[@class='bm-item-list']/a[@id='about_sidebar_link']");
    private final By burgerMenuLogOut=By.xpath("//nav[@class='bm-item-list']/a[@id='logout_sidebar_link']");
    private final By burgerMenuResetAppState=By.xpath("//nav[@class='bm-item-list']/a[@id='reset_sidebar_link']");

    public HomePage(WebDriver driver) {

        super(driver);
    }
    public void clickCartButtonLink(){
        log.info("Click cart button ");
        driver.findElement(cartButtonLink).click();
    }
    public void clickToBurgerMenu (){
        log.info("Click to burger menu button ");
        driver.findElement(burgerMenuButton).click();
    }

    public boolean isBurgerMenuAllItemsDisplayed() {return driver.findElement(burgerMenuAllItems).isDisplayed();}
    public boolean isBurgerMenuAboutDisplayed() {return driver.findElement(burgerMenuAbout).isDisplayed();}

    public boolean isBurgerMenuLogOutDisplayed() {
        return driver.findElement(burgerMenuLogOut).isDisplayed();
    }
    public boolean isBurgerMenuResetDisplayed() {
        return driver.findElement(burgerMenuResetAppState).isDisplayed();
    }

}
