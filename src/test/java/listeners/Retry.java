package listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {

	private int retryCount = 0;
	private int Max_Retry = 1;

	@Override
	public boolean retry(ITestResult result) {

		if (retryCount < Max_Retry) {
			retryCount++;
			return true; // retry test
		}

		return false;
	}

}
