package baseTest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import listeners.ExtentReportsManager;
import pageObjects.LoginPage;

public class BaseTest {

	private WebDriver driver;
	public static LoginPage loginPage;
	
	  @BeforeSuite
	  
	    public void suiteSetup() {
	        ExtentReportsManager.setupReports();      // init ONCE for entire suite
	    }

	@Parameters("browser")
	@BeforeMethod(alwaysRun = true)
	public void setUp(String browser) {
		System.out.println("Broweser:"+browser);
		DriverManager.setDriver(DriverFactory.loadDriver(browser));
		driver = DriverManager.getDriver();
		
	}

	public void goTo(String url) {
		driver.get(url);
		loginPage = new LoginPage(driver);
	}

	@AfterMethod
	public void TearDown() {
		if (driver != null) {
			driver.quit();
		}
		DriverManager.unloadDriver();
	}
	
	@AfterSuite
    public void suiteTearDown() {
        ExtentReportsManager.flushReport();     // MUST flush — writes HTML!
    }
}
