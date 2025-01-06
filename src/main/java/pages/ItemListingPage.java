package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ItemListingPage {

    WebDriver driver;

    By buttonAddToCard = By.xpath("//a[@id='atcBtn_btn_1']");

    public ItemListingPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAddToCart() {
        try {
            driver.findElement(buttonAddToCard).click();
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }

}
