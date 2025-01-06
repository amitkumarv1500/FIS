import common.WebActionLib;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import java.util.LinkedHashMap;

public class RestAPI_Automation {

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

}
