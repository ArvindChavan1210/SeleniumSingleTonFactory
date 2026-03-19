package abstractMethods;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractClass {

//	private static WebDriver driver;
	private static WebDriverWait wait;

	public AbstractClass(WebDriver driver) {
//		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(25));
	}

	public static void waitUntilElementVisible(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static void waitUntilElementClickable(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public static void waitUntilElementInvisible(WebElement element) {
		wait.until(ExpectedConditions.invisibilityOf(element));
	}

	public static void waitUntillAlertPresent(WebElement element) {
		wait.until(ExpectedConditions.alertIsPresent());
	}

	public static void waitUntilVisiblityofAllElements(List<WebElement> element) {
		wait.until(ExpectedConditions.visibilityOfAllElements(element));
	}

	public static WebElement waitUntilLocatorVisible(By locator) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public static WebElement waitUntilLocatorClickable(By locator) {
		return wait.until(ExpectedConditions.elementToBeClickable(locator));

	}

	public static void waitUntilIframeVisibleByLocatorAndSwitchtoIt(By locator) {
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
	}

	public static void waitUntilIframeVisibleByIndexAndSwitchToIt(int index) {
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(index));
	}

}
