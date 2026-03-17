package abstractMethods;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractClass {

	protected static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	protected static WebDriverWait wait;

	public AbstractClass(WebDriver webDriver) {
		driver.set(webDriver);
		wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
	}


	// wait until Element visible
	public static void waitForVisibilityofElement(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	// wait until Element click-able
	public static void waitForElementClickable(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	// wait until pageLoad
	public static void waitForVisibilityofAllElements(List<WebElement> elements) {
		wait.until(ExpectedConditions.visibilityOfAllElements(elements));
	}

	// wait until in-visiblity of element
	public static void invisibilityofWebElement(WebElement element) {
		wait.until(ExpectedConditions.invisibilityOf(element));
	}

}
