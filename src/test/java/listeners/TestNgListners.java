package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.Markup;

import baseTest.DriverManager;
import utilities.ScreenShotsUtility;

public class TestNgListners implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Started Execution");
		String TestName = result.getMethod().getMethodName();
		ExtentReportsManager.createTest(TestName, result.getMethod().getDescription());
		ExtentReportsManager.getTest().info("Test Started:" + result.getMethod().getMethodName());
		ITestListener.super.onTestStart(result);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("[Pass] :" + result.getName());
		ExtentReportsManager.getTest().pass("Test Passed:" + result.getMethod().getMethodName());
		ITestListener.super.onTestSuccess(result);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("[Fail] :" + result.getName());
		String path = System.getProperty("user.dir") + "//target/Screenshots/p.png";
		ScreenShotsUtility.takeScreenShotasFile(DriverManager.getDriver(), path);
		try {
			Thread.sleep(500);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ExtentReportsManager.getTest().fail(result.getThrowable());
		ExtentReportsManager.getTest().fail("Fail:",MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		ITestListener.super.onTestFailure(result);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {

		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Numeber of Tests Executed:" + context.getAllTestMethods().length);
		System.out.println("Number of Test Passed:" + context.getPassedTests().size());
		System.out.println("Number of Failed Tests:" + context.getFailedTests().size());
		System.out.println("Number of Skipped Tests:" + context.getSkippedTests().size());
		ITestListener.super.onFinish(context);
	}

}
