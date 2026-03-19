package baseTest;

import static org.testng.Assert.assertThrows;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverFactory {

	private static WebDriver driver;

	public static WebDriver loadBrowser(String browsername) {
		switch (browsername.toLowerCase()) {
		case "chrome":
			ChromeOptions chromeoptions = new ChromeOptions();
			chromeoptions.addArguments("--disable-popup-blocking");
			driver = new ChromeDriver(chromeoptions);
			driver.manage().window().maximize();
			return driver;
		case "firefox":
			FirefoxOptions firefoxoptions = new FirefoxOptions();
			firefoxoptions.addArguments("--disable-popup-blocking");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			return driver;
		default:
			throw new RuntimeException("Invalid browser");
		}
	}

}
