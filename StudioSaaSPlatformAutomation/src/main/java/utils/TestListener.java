package utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class TestListener implements ITestListener{
	WebDriver driver;

    // This will execute before each test
   
    public void onTestStart(ITestResult result) {
    	System.out.println("Listener Started: " + result.getName());
    	Reporter.log("Test Started: " + result.getName());
    }

    // This executes when a test case passes
    public void onTestSuccess(ITestResult result) {
    	System.out.println("Test Passed: " + result.getName());
    	Reporter.log("Test Passed: " + result.getName());
    }

    // This executes when a test case fails

    public void onTestFailure(ITestResult result) {
    	System.out.println("Listener Failed: " + result.getName());
    	Reporter.log("Test Failed: " + result.getName());
        // Capture a screenshot on failure
        Object testClass = result.getInstance();
        driver = ((CommonFunctions) testClass).getDriver(); // Fetch WebDriver instance

        if (driver != null) {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String screenshotPath = "screenshots/" + result.getName() + ".png";

            try {
                FileUtils.copyFile(screenshot, new File(screenshotPath));
                System.out.println("Screenshot saved at: " + screenshotPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // This executes when a test case is skipped
   
    public void onTestSkipped(ITestResult result) {
    	System.out.println("Test Skipped: " + result.getName());
    	Reporter.log("Test Skipped: " + result.getName());
    }

    
    public void onStart(ITestContext context) {
    	System.out.println("Test Suite Started: " + context.getName());
    	Reporter.log("Test Suite Started: " + context.getName());
    }

    
    public void onFinish(ITestContext context) {
        Reporter.log("Test Suite Finished: " + context.getName());
        
    }
}

