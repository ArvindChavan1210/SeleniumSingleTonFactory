package testMethods;

import static org.testng.Assert.assertNotNull;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import baseTest.BaseTest;
import listeners.Retry;
import listeners.TestNGListners;
import pageObjects.LoginPage;
import utilities.PropertiesReader;

@Listeners(TestNGListners.class)
public class FirstTest extends BaseTest {

	@Test(retryAnalyzer = Retry.class, description = "Validate Blank field validation Message", priority = 1)
	public void validate_blank_field_validation_message() {
		String blankFieldMessage = loginPage.blankFieldMessage();
		Assert.assertEquals(blankFieldMessage, "*Email is required", "Differnt message than expected");
	}

	@Test(retryAnalyzer = Retry.class, description = "Validate toast message for wrong username or password", priority=2)
	public void validate_login_feature_with_wrong_userpassword() {
		String toastMessage= LoginPage.login("test@email.com", "123");
		Assert.assertEquals(toastMessage, "Incorrect email or password.","Incorrect toast message displayed");
	}
	
	@Test(retryAnalyzer = Retry.class, description="Validate login with valid credentials", priority=3)
	public void validate_login_feature_with_valid_credentials() {
		String validLoginMessage = LoginPage.login(UserName, password);
		Assert.assertEquals(validLoginMessage, "Login Successfully","Different Message is displayed");
	}

	@Test(retryAnalyzer=Retry.class, description="Validate item list is not empty on dashboard", priority = 4)
	public void validate_dashboardPage_item_List() {
		LoginPage.login(UserName, password);
		assertNotNull(LoginPage.dashBoardPage.validateDashboardPageDisplayedItems());
	}
}
