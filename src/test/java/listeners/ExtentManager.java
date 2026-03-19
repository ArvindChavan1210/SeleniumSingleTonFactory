package listeners;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

	private static ExtentReports extent;
	private static ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();

	private ExtentManager() {
	};

	public static ExtentReports setupReport() {
		try {
			String timeStamp = new SimpleDateFormat("dd_MM_yy_HH_mm").format(new Date());
			String filePath = System.getProperty("user.dir") + "//target//ExtentReports//" + timeStamp + ".html";
			System.out.println(filePath);
			extent = new ExtentReports();
			ExtentSparkReporter reporter = new ExtentSparkReporter(filePath);
			extent.attachReporter(reporter);
			reporter.config().setTheme(Theme.DARK);
			reporter.config().setDocumentTitle("QA Automation");
			reporter.config().setReportName("Test Execution Report");
			extent.setSystemInfo("OS", System.getProperty("os.name"));
			extent.setSystemInfo("TimeStamp", timeStamp);
			return extent;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static ExtentTest setTest(String testName, String description) {
		ExtentTest tst = extent.createTest(testName, description);
		test.set(tst);
		return tst;
	}

	public static ExtentTest getTest() {
		return test.get();
	}

	public static void flushReport() {
		if (extent != null) {
			extent.flush();
		}
	}


}
