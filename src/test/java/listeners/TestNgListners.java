package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import baseTest.DriverManager;
import utilities.ScreenshotUtility;

public class TestNGListners implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Test Start:" + result.getMethod().getDescription());
		String testname = result.getMethod().getMethodName();
		ExtentManager.setTest(testname, result.getMethod().getDescription());
		ITestListener.super.onTestStart(result);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("[Pass]:" + result.getMethod().getMethodName());
		ExtentManager.getTest().log(Status.INFO, result.getMethod().getDescription()).pass("Test Passed");
		ITestListener.super.onTestSuccess(result);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("[Fail]:" + result.getMethod().getMethodName());
		String screenShot = ScreenshotUtility.TakeScreenshotAsBase64(DriverManager.getDriver());
		ExtentManager.getTest().info(result.getMethod().getDescription())
				.log(Status.FAIL, "Test Failed" + result.getThrowable()).addScreenCaptureFromBase64String(screenShot);
		ITestListener.super.onTestFailure(result);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("[Skipped]:" + result.getMethod().getMethodName());
		ExtentManager.getTest().skip("Test Skipped").
		info("Test Skipped :"+result.getSkipCausedBy());
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
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Number of Tests Passed :" + context.getPassedTests().size());
		System.out.println("Number of Tests Failed :" + context.getFailedTests().size());

		ITestListener.super.onFinish(context);
	}

}
