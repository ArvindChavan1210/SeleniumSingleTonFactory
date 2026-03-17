package testMethods;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import baseTest.BaseTest;
import listeners.Retry;
import listeners.TestNgListners;
import utilities.PropertiesReader;

@Listeners(TestNgListners.class)
public class FirstTest extends BaseTest {

	@Test(priority = 1, description = "Validate login with fields & check validation message")
	public void validateBlankFieldValidations() {
		goTo(PropertiesReader.getProperties("config", "url"));
		String message = loginPage.blankFieldValidation();
		Assert.assertNull(message, "Validation Message is not displayed");
	}

	@Test(priority = 2, retryAnalyzer =Retry.class, description ="Validate login security for wrong username and password")
	public void validateWrongUserNameOrPassword() {
		goTo(PropertiesReader.getProperties("config", "url"));
		String message = loginPage.performLogin(PropertiesReader.getProperties("config", "username"), "Tst");
		Assert.assertEquals(message, "Incorrect email or password.", "Different message printed than expected");
	}

	@Test(priority = 3, retryAnalyzer =Retry.class, description="Validate login with correct username and password")
	public void loginUsingCorrectCredentials() {
		goTo(PropertiesReader.getProperties("config", "url"));
		String message = loginPage.performLogin(PropertiesReader.getProperties("config", "username"),
				PropertiesReader.getProperties("config", "password"));
		Assert.assertEquals(message, "Login Successfully", "Different message printed than expected");
	}

}
