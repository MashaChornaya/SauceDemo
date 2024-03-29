package Tests;

import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;
@Log4j2
@Listeners(TestListener.class)
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

    @Parameters({"browser"})
    @BeforeClass (alwaysRun = true, description = "initialise driver")
    public void setUp(@Optional("chrome") String browserName, ITestContext testContext) throws Exception {
        log.debug("Browser started");
        if (browserName.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browserName.equals("opera")) {
            WebDriverManager.operadriver().setup();
            driver = new OperaDriver();
        } else {
            throw new Exception("Undefined browser type");
        }
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        loginPage=new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        testContext.setAttribute("driver", driver);
    }

    @BeforeMethod(description = "navigate")
    public void navigate(){
        log.debug("Page opened");
        driver.get("https://www.saucedemo.com");
    }
    @AfterMethod(alwaysRun = true, description = "close browser")
    public void clearCookies() {
        log.debug("Clear all cookies here");
        driver.manage().deleteAllCookies();
        ((JavascriptExecutor) driver).executeScript(String.format("window.localStorage.clear();"));
        ((JavascriptExecutor) driver).executeScript(String.format("window.sessionStorage.clear();"));
    }
    @AfterClass
    public void tearDown() {
        log.debug("Driver closed");
        driver.quit();

    }
}
