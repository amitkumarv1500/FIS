import common.WebActionLib;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.ItemListingPage;
import pages.LandingPage;
import pages.SearchResultPage;
import pages.ShoppingCartPage;

import java.util.LinkedHashMap;
import java.util.concurrent.TimeUnit;

public class RestAPI_Automation {

    WebDriver driver;
    JavascriptExecutor js;
    LandingPage landingPage;
    SearchResultPage searchResultPage;
    ItemListingPage itemListingPage;
    ShoppingCartPage shoppingCartPage;
    WebActionLib lib;

    @BeforeSuite
    public void setup() {}

    @Test(priority = 1)
    public void testRestAPI() throws InterruptedException {
        Response response = RestAssured.given().get("http://api.coindesk.com/v1/bpi/currentprice.json");

        JsonPath jsonPathEvaluator = response.jsonPath();
        LinkedHashMap<String, String> lhm = jsonPathEvaluator.get("bpi");

        Assert.assertTrue(lhm.containsKey("USD"), "API response doesn't have USD");
        Assert.assertTrue(lhm.containsKey("GBP"), "API response doesn't have USD");
        Assert.assertTrue(lhm.containsKey("EUR"), "API response doesn't have USD");

        String GBPDescription = jsonPathEvaluator.get("bpi.GBP.description");
        Assert.assertEquals(GBPDescription, "British Pound Sterling", "GBP description not matching.");
    }

    @AfterSuite
    public void tearDown() {}
}
