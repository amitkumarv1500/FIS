package common;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class WebActionLib {

    WebDriver driver;

    public WebActionLib(WebDriver driver) {
        this.driver = driver;
    }

	public void switchToChildWindow() {
		String mainWindow = driver.getWindowHandle();
		Set<String> windowHandles = driver.getWindowHandles();

		Iterator<String> windowIterator = windowHandles.iterator();
		while (windowIterator.hasNext()) {
			String ChildWindow = windowIterator.next();
			if (!mainWindow.equalsIgnoreCase(ChildWindow)) {
				driver.switchTo().window(ChildWindow);
				System.out.println("switched to child window");
			}
		}
	}
}
