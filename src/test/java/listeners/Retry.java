package listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {

	private int RetryCount = 0;
	private int Max_Retry = 2;

	@Override
	public boolean retry(ITestResult result) {
		while (RetryCount < Max_Retry) {
			RetryCount++;
			return true;
		}
		return false;
	}

}
