import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BusketTest extends BaseClass {
    @BeforeMethod
    public void navigate() {

        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void logAndBusketTest() {
        WebElement userName=driver.findElement(By.cssSelector("[placeholder=Username]"));
        userName.sendKeys("standard_user");
        WebElement password= driver.findElement(By.cssSelector("[placeholder=Password]"));
        password.sendKeys("secret_sauce");
        WebElement login= driver.findElement(By.cssSelector("[name=login-button]"));
        login.click();
        WebElement title=driver.findElement(By.className("title"));
        Assert.assertEquals(title.getText(),"PRODUCTS","No title 'Products'");

        WebElement addButton=driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-backpack"));
        addButton.click();
        WebElement addShure= driver.findElement(By.xpath("//button[text()='Remove']"));
        Assert.assertEquals(addShure.getText(),"REMOVE","Item not add in busket");

        WebElement busket=driver.findElement(By.cssSelector(".shopping_cart_link"));
        busket.click();
        WebElement busketShure=driver.findElement(By.xpath("//span[text()='Your Cart']"));
        Assert.assertEquals(busketShure.getText(),"YOUR CART","You not in your busket");

        WebElement price=driver.findElement(By.cssSelector(".inventory_item_price"));
        Assert.assertEquals(price.getText(),"$29.99","Error price");

        WebElement name=driver.findElement(By.cssSelector(".inventory_item_name"));
        Assert.assertEquals(name.getText(),"Sauce Labs Backpack","Error name");
    }
}