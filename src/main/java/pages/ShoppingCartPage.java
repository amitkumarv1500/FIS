package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage {

    WebDriver driver;

    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
    }

    By numberOfItemsInCart = By.xpath("//i[@id='gh-cart-n']");

    public int getNumberOfItemsInCart() {
        int numOfItemsInCart = 0;
        try {
            numOfItemsInCart = Integer.parseInt(driver.findElement(numberOfItemsInCart).getText());
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
        return numOfItemsInCart;
    }
}
