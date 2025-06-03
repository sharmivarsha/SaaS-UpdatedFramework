package utils;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class ExtentReportListener implements ITestListener  {
 
    public  static ExtentSparkReporter reporter = new ExtentSparkReporter("ExtentReport.html");;
    public  static ExtentReports extent= new ExtentReports();
    //public  static ExtentTest test;
    public static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
    public  WebDriver driver;
    //public static ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();
   
   
   
    public void onStart(ITestContext context) {
         
    	reporter.config().setDocumentTitle("Automation Report");
		reporter.config().setReportName("Studio SaaS Automation");
        extent.attachReporter(reporter);
    	extent.setSystemInfo("Environment","Sandbox");
    	extent.setSystemInfo("Browser Name","Chrome");
    	extent.setSystemInfo("OS","Linux");
    }

    
   public void onTestStart(ITestResult result) {
	  
	 //test=extent.createTest(result.getName());
	   ExtentTest extentTest = extent.createTest(result.getName());
	    test.set(extentTest);
	    
   }
   
    public void onTestSuccess(ITestResult result) {
    	//test.log(Status.PASS,"Test Passed:" +result.getName());
    	test.get().log(Status.PASS, "Test Passed: " + result.getName());
    	
    	 
       
    }

    
    public void onTestFailure(ITestResult result) {
        //test.log(Status.FAIL, "Test Failed: " + result.getThrowable());
        test.get().log(Status.FAIL, "Test Failed: " + result.getThrowable());
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
        if (utils.RetryAnalyzer.getRetryCount(result.getName()) > 0) {
            System.out.println(result.getName() + " is being retried.");
        }
        
    }

    
    public void onTestSkipped(ITestResult result) {
        test.get().log(Status.SKIP, "Test Skipped: " + result.getThrowable());
        
    }

    
    public void onFinish(ITestContext context) {
        
    	 if (extent != null) {
        extent.flush();
    }
    }
}

