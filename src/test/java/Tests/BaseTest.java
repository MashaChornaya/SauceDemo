package Tests;

import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    final static String USERNAME="standard_user";
    final static String PASSWORD="secret_sauce";
    final static String PRODUCT_NAME="Sauce Labs Fleece Jacket";

    protected WebDriver driver;
    protected LoginPage loginPage;
    protected ProductsPage productsPage;
    protected ItemDetailsPage itemDetailsPage;
    protected HomePage homePage;
    protected CartPage cartPage;


    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        loginPage=new LoginPage(driver);
        productsPage=new ProductsPage(driver);
    }

    @BeforeMethod
    public void navigate(){

        driver.get("https://www.saucedemo.com");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
