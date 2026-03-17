package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractMethods.AbstractClass;

public class LoginPage extends AbstractClass {

	ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	public LoginPage(WebDriver webDriver) {
		super(webDriver);
		driver.set(webDriver);
		PageFactory.initElements(webDriver, this);
	}

	@FindBy(id = "userEmail")
	private WebElement username;
	@FindBy(id = "userPassword")
	private WebElement password;
	@FindBy(name = "login")
	private WebElement LoginButton;
	@FindBy(className = "invalid-feedback")
	private List<WebElement> blankfieldValidation;
	@FindBy(css = ".ng-trigger-flyInOut")
	private List<WebElement> toastContainer;

	public String performLogin(String name, String pass) {
		waitForElementClickable(LoginButton);
		username.sendKeys(name);
		password.sendKeys(pass);
		LoginButton.click();

		waitForVisibilityofAllElements(toastContainer);

		if (!toastContainer.isEmpty()) {
			return toastContainer.get(0).getText();
		}
		return null;
	}

	public String blankFieldValidation() {
		waitForElementClickable(LoginButton);
		username.sendKeys("");
		password.sendKeys("");
		LoginButton.click();
		waitForVisibilityofAllElements(blankfieldValidation);
		if (!blankfieldValidation.isEmpty()) {
			return blankfieldValidation.get(0).getText();
		}
		return null;
	}

}
