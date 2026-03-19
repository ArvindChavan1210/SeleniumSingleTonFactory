package baseTest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import listeners.ExtentManager;
import pageObjects.LoginPage;
import utilities.PropertiesReader;

public class BaseTest {

	private static WebDriver driver;
	public static LoginPage loginPage;
	protected static String UserName;
	protected static String password;
	
	@BeforeSuite
	public void setUpExtent() {
		ExtentManager.setupReport();
	}

	@Parameters("browser")
	@BeforeMethod
	public void setup(String browser){
		DriverManager.setDriver(DriverFactory.loadBrowser(browser));
		driver = DriverManager.getDriver();
		goTo(PropertiesReader.getProperty("config", "url"));
		UserName = PropertiesReader.getProperty("config", "username");
		password = PropertiesReader.getProperty("config", "password");
	}

	public void goTo(String url) {
		driver.get(url);
		loginPage=new LoginPage(driver);
	}

	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
		DriverManager.unloadDriver();
	}
	
	@AfterSuite
	public void flushExtent() {
		ExtentManager.flushReport();
	}

}
