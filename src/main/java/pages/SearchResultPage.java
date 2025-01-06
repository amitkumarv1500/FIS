package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SearchResultPage {

    WebDriver driver;

    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectItemFromSearchResult(int itemNumber) {
        try {
            driver.findElement(By.xpath("//div[@id='srp-river-results']/ul/li[contains(@id,'item')][" + itemNumber + "]//a[@class='s-item__link']")).click();
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }

}
