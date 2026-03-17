package baseTest;

import org.openqa.selenium.WebDriver;

public class DriverManager {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	public static void setDriver(WebDriver browserName) {
		driver.set(browserName);
	}

	public static WebDriver getDriver() {
		return driver.get();
	}

	public static void unloadDriver() {
		driver.remove();
	}

}
