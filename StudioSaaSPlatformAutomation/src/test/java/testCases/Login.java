package testCases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pageObjects.Login_Page_Objects;
import utils.CommonFunctions;
import utils.ExtentReportListener;
import utils.Constants;

public class Login extends CommonFunctions {

	@BeforeMethod
	public void startBrowser() throws IOException {
		setUp("chrome"); // Start fresh browser
	}

	@Test(dataProvider = "loginData")
	public void loginPage(String username, String password) throws IOException {
		Login_Page_Objects login = new Login_Page_Objects(driver);
		String labelvalue = login.usernamelabel.getText();
		softAssert.assertEquals(labelvalue, "Business Email Address (Username)");
		// login.username.sendKeys(constants.username);
		login.username.sendKeys(username);
		String labelvalue1 = login.passwordlabel.getText();
		softAssert.assertEquals(labelvalue1, "Password");
		// login.password.sendKeys(constants.password);
		login.password.sendKeys(password);
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File Img_Loginpage = screenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(Img_Loginpage, new File(Constants.Img_Loginpage));
		login.submitbutton.click();
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement errorMsg = wait.until(ExpectedConditions.visibilityOf(login.errormessage));
			String actualError = errorMsg.getText();
			System.out.println("Login failed for username: " + username + ", Error: " + actualError);
			ExtentReportListener.test.get().log(Status.FAIL,
					"Login failed<br><b>Username:</b> " + username + "<br><b>Error Message:</b> " + actualError);
			softAssert.assertTrue(actualError.contains("Invalid"), "Unexpected error message: " + actualError);
		} catch (Exception e) {
			// Assume success if no error message appears
			System.out.println("Login successful for username: " + username);
			ExtentReportListener.test.get().log(Status.PASS, "Login successful for username: " + username);
		}

		File Img_Welcomepage = screenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(Img_Welcomepage, new File(Constants.Img_Welcomepage));
		softAssert.assertAll();

	}

	@DataProvider(name = "loginData")
	public Object[][] getData() {
		return new Object[][] { { "admin", "volante@12" }, // invalid
				{ "vol-admin", "volante@123" },// valid
		};
	}
}
