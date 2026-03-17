package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShotsUtility {

	public static void takeScreenShotasFile(WebDriver driver, String path) {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File dst = new File(path);
		try {
			FileUtils.copyFile(src, dst);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
