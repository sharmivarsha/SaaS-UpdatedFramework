
package testCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;
import utils.CommonFunctions;
import utils.Constants;
import pageObjects.AddUser_Page_Objects;

public class AddUser extends CommonFunctions {

	@Test(retryAnalyzer = utils.RetryAnalyzer.class)
	public void addUser() throws IOException {
		AddUser_Page_Objects user = new AddUser_Page_Objects(driver);
		user.adduserButton.click();
		user.adduserDialogBox.click();
		String tittle = user.addUserTittle.getText();
		softAssert.assertEquals("Add User", tittle);
		String labelfirstname = user.labelFirstName.getText();
		softAssert.assertEquals("First Name *", labelfirstname);
		String labellastname = user.labelLastName.getText();
		softAssert.assertEquals("Last Name *", labellastname);
		user.firstNameTextbox.sendKeys(Constants.adduserfirstname);
		user.lastNameTextbox.sendKeys(Constants.adduserlastname);
		String email = user.email.getText();
		softAssert.assertEquals("Email *", email);
		String phone = user.Phone.getText();
		softAssert.assertEquals("Phone *", phone);
		user.emailTextbox.sendKeys(Constants.adduseremail);
		user.phoneTextbox.sendKeys(Constants.adduserphone);
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File Img_AddUser = screenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(Img_AddUser, new File(Constants.Img_AddUser));
		user.userButton.click();

	}

}
