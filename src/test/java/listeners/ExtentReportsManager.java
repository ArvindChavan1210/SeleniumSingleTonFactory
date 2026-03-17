package listeners;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportsManager {

	private static ExtentReports extents;
	private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

	private ExtentReportsManager() {
	};

	public static ExtentReports setupReports() {

		String timeStamp = new SimpleDateFormat("dd-MM-YYYY_HH.mm").format(new Date());
		String filePath = System.getProperty("user.dir") + "//target//ExtentReports//" + timeStamp + "_report.html";
		System.out.println(filePath);
		extents = new ExtentReports();
		ExtentSparkReporter reporter = new ExtentSparkReporter(filePath);
		reporter.config().setTheme(Theme.DARK);
		reporter.config().setDocumentTitle("Test Results");
		reporter.config().setReportName("Automation Test Reprot");
		extents.attachReporter(reporter);
		extents.setSystemInfo("OS", System.getProperty("os.name"));
		extents.setSystemInfo("Tester", "QA");
		return extents;
	}

	public static ExtentTest createTest(String testname, String description) {
		ExtentTest extenttest = extents.createTest(testname, description);
		test.set(extenttest);
		return extenttest;
	}

	public static ExtentTest getTest() {
		return test.get();
	}

	public static void flushReport() {
		if (extents != null) {
			extents.flush();
		}
	}

}
