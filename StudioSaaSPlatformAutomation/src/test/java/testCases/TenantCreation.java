package testCases;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.CommonFunctions;
import utils.Constants;
import pageObjects.TenantCreation_Page_Objects;

public class TenantCreation extends CommonFunctions {

	@Test(retryAnalyzer = utils.RetryAnalyzer.class)
	public void tenantCreation() throws IOException, InterruptedException {
		TenantCreation_Page_Objects tenant = new TenantCreation_Page_Objects(driver);
		tenant.clickicon.click();
		tenant.AddButton.click();
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File Img_AddTenant = screenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(Img_AddTenant, new File(Constants.Img_AddTenant));
		String labelname = tenant.LabelNameTenant.getText();
		softAssert.assertEquals(labelname, "Name *");
		tenant.NameTextbox.sendKeys(Constants.TenantName);
		String labelgroup = tenant.LabelGroup.getText();
		softAssert.assertEquals(labelgroup, "Group *");
		String grpname = UUID.randomUUID().toString().substring(0, 8);
		System.out.println(grpname);
		// TenantCreation_Page_Objects.GroupTextbox.sendKeys(constants.GroupName);
		tenant.GroupTextbox.sendKeys(grpname);
		String labelorgprefix = tenant.LabelOrgPrefix.getText();
		softAssert.assertEquals(labelorgprefix, "Organization Prefix *");
		// Thread.sleep(3000);
		String prefixvalue = tenant.OrgPrefixTextbox.getAttribute("value");
		softAssert.assertEquals(prefixvalue, Constants.OrgPrefixValue);
		String displayvalue = tenant.DisplayNameTextbox.getAttribute("value");
		softAssert.assertEquals(displayvalue, Constants.DisplayName);
		String addresslabel = tenant.LabelAddress.getText();
		softAssert.assertEquals(addresslabel, "Address *");
		tenant.AddressTextbox.sendKeys(Constants.Address);
		String countrylabel = tenant.LabelCountry.getText();
		softAssert.assertEquals(countrylabel, "Country *");
		tenant.CountryTextbox.click();
		FileReader file = new FileReader(Constants.Dropdownvalues);
		BufferedReader reader = new BufferedReader(file);
		String line = reader.readLine();
		reader.close();
		String[] expectedDropDownItemsInArray = line.split(",");
		// System.out.println(expectedDropDownItemsInArray);
		ArrayList<String> expectedItems = new ArrayList<String>();
		for (int i = 0; i < expectedDropDownItemsInArray.length; i++)
			expectedItems.add(expectedDropDownItemsInArray[i]);

		List<String> actualDropDownItems = new ArrayList<String>();
		for (WebElement actualItems : tenant.CountriesList) {
			actualDropDownItems.add(actualItems.getText());
			for (int i = 0; i < actualDropDownItems.size(); i++) {
				if (!expectedItems.get(i).equals(actualDropDownItems.get(i)))
					System.out.println("Drop-down values are same and no difference found");
			}
			tenant.SelectValuesFromDropDown.click();
			String labelzip = tenant.LabelZip.getText();
			softAssert.assertEquals(labelzip, "Zip *");
			tenant.ZipTextBox.sendKeys(Constants.Zip);
			String labelWebsite = tenant.LabelWebsite.getText();
			softAssert.assertEquals(labelWebsite, "Website *");
			tenant.WebsiteTextBox.sendKeys(Constants.Website);
			String labelPhone = tenant.LabelPhone.getText();
			softAssert.assertEquals(labelPhone, "Phone *");
			tenant.PhoneTextBox.sendKeys(Constants.Phone);
			String labelEmail = tenant.LabelEmail.getText();
			softAssert.assertEquals(labelEmail, "Email *");
			tenant.EmailTextBox.sendKeys(Constants.Email);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3000));
			wait.until(ExpectedConditions.elementToBeClickable(tenant.Button));
			tenant.Button.click();
			tenant.Checkbox.click();
			tenant.Region.click();
			// tenant.RegionList.click();
			tenant.DropdownValueRegion.click();
			tenant.VolpayVersion.click();
			tenant.DropdownValueVolpayversion.click();
			tenant.Button1.click();
			tenant.UsersFirstName.sendKeys(Constants.UserFirstName);
			tenant.UsersLastName.sendKeys(Constants.UserLastName);
			tenant.Email.sendKeys(Constants.UserEmail);
			tenant.Phone.sendKeys(Constants.UserPhone);
			tenant.Button2.click();
			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(3000));
			wait1.until(ExpectedConditions.elementToBeClickable(tenant.AddTenant));
			tenant.AddTenant.click();
			WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10000));
			wait2.until(ExpectedConditions.elementToBeClickable(tenant.GoToTenant));
			tenant.GoToTenant.click();

		}
	}

}
