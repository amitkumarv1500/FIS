package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class LandingPage {

    WebDriver driver;

    By inputSearchField = By.xpath("//input[@id='gh-ac']");
    By dropdownCategory = By.xpath("//select[@id='gh-cat']");
    By buttonSearch = By.xpath("//input[@id='gh-btn']");

    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterSearchValue(String searchValue) {
        try {
            driver.findElement(inputSearchField).sendKeys(searchValue);
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }

    public void selectCategory(String category) {
        try {
            Select sl = new Select(driver.findElement(dropdownCategory));
            sl.selectByVisibleText(category);
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }

    public void clickSearchButton() {
        try {
            driver.findElement(buttonSearch).click();
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }

}
