package baseTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverFactory {

	private static WebDriver driver;

	public static WebDriver loadDriver(String browser) {
		switch (browser.toLowerCase()) {
		case "chrome":
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-popup-blocking");
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			return driver;
		case "firefox":
			FirefoxOptions options1 = new FirefoxOptions();
			options1.addArguments("--disable-popup-blocking");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			return driver;
		default:
			return null;
		}
	}

}
