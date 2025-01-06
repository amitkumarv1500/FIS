import common.WebActionLib;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.*;

import java.util.concurrent.TimeUnit;

public class UI_Automation {

    WebDriver driver;
    JavascriptExecutor js;
    LandingPage landingPage;
    SearchResultPage searchResultPage;
    ItemListingPage itemListingPage;
    ShoppingCartPage shoppingCartPage;
    WebActionLib lib;

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        lib = new WebActionLib(driver);
    }

    @Test(priority = 1)
    public void testEbayCart() throws InterruptedException {
        landingPage = new LandingPage(driver);
        driver.navigate().to("https://www.ebay.com/");

        landingPage.enterSearchValue("book");
        landingPage.selectCategory("Books");
        landingPage.clickSearchButton();

        searchResultPage = new SearchResultPage(driver);
        searchResultPage.selectItemFromSearchResult(1);

        lib.switchToChildWindow();

        itemListingPage = new ItemListingPage(driver);
        itemListingPage.clickAddToCart();

        shoppingCartPage = new ShoppingCartPage(driver);
        int numOfItemsInCart = shoppingCartPage.getNumberOfItemsInCart();
        System.out.print("Number of items in cart: " + numOfItemsInCart);

        Assert.assertEquals(numOfItemsInCart, 1, "Number of items in cart do not match.");
    }

    @AfterTest
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}
