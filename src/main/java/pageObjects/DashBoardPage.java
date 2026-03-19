package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractMethods.AbstractClass;

public class DashBoardPage extends AbstractClass {
	
	private static WebDriver driver;
	

	public DashBoardPage(WebDriver driver) {
		super(driver);
		DashBoardPage.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="h5 b")
	private static java.util.List<WebElement> itemNames;
	
	public int validateDashboardPageDisplayedItems() {
		waitUntilVisiblityofAllElements(itemNames);
		return itemNames.size();
	}
	
	
}
