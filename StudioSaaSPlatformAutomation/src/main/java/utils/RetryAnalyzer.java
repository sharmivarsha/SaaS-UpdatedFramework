package utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import java.util.HashMap;
import java.util.Map;

public class RetryAnalyzer implements IRetryAnalyzer {

    private static final int maxRetryCount = 2;
    private static Map<String, Integer> retryCounts = new HashMap<String, Integer>();

   
    public boolean retry(ITestResult result) {
        String testName = result.getName();
        int currentRetry = retryCounts.getOrDefault(testName, 0);

        System.out.println("Retry attempt for " + testName + ": " + currentRetry);

        if (currentRetry < maxRetryCount) {
            retryCounts.put(testName, currentRetry + 1);
            return true;
        }

        return false;
    }

    public static int getRetryCount(String testName) {
        return retryCounts.getOrDefault(testName, 0);
    }
}
