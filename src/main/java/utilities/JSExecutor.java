package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JSExecutor {

	public static void heighLightWebElement(WebDriver driver, WebElement el) {
		((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'", el);
	}
	
}
