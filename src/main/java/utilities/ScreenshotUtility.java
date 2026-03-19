package utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtility {

	public static void TakeScreenshotAsFile(WebDriver driver) {
		String timeStamp = new SimpleDateFormat("dd_MM_yyyy_HH_mm").format(new Date());
		String filePath = System.getProperty("user.dir") + "\\target\\Screnshots\\P_" + timeStamp + ".png";
		try {
			TakesScreenshot screenshot = (TakesScreenshot) driver;
			File src = screenshot.getScreenshotAs(OutputType.FILE);
			File dst = new File(filePath);
			FileUtils.copyFile(src, dst);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String TakeScreenshotAsBase64(WebDriver driver) {
		try {
			return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
