package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractMethods.AbstractClass;
import utilities.JSExecutor;

public class LoginPage extends AbstractClass {

	private static WebDriver driver;
	public static DashBoardPage dashBoardPage;

	public LoginPage(WebDriver driver) {
		super(driver);
		LoginPage.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "login")
	private static WebElement loginButton;
	@FindBy(id = "userEmail")
	private static WebElement userNameField;
	@FindBy(id = "userPassword")
	private static WebElement userPassword;
	@FindBy(css = ".ng-trigger-flyInOut")
	private static WebElement toastContainer;

	public String blankFieldMessage() {

		waitUntilElementClickable(loginButton);
		loginButton.click();
		WebElement lo = waitUntilLocatorVisible(By.cssSelector(".invalid-feedback"));
		JSExecutor.heighLightWebElement(driver, lo);
		return lo.getText();

	}

	public static String login(String user, String pass) {
		waitUntilElementClickable(loginButton);
		userNameField.sendKeys(user);
		waitUntilElementVisible(userPassword);
		userPassword.sendKeys(pass);
		loginButton.click();
		dashBoardPage = new DashBoardPage(driver);
		return waitUntilLocatorVisible(By.cssSelector(".ng-trigger-flyInOut")).getText();

	}

}
