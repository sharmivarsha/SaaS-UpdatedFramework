package testCases;

import java.io.IOException;
import org.testng.annotations.Test;
import pageObjects.CreateRelease_Page_Objects;
import utils.CommonFunctions;
import utils.ScreenshotTest;
import utils.Constants;

public class CreateRelease extends CommonFunctions {

	@Test(retryAnalyzer = utils.RetryAnalyzer.class)
	public void createRelease() throws IOException, InterruptedException {
		CreateRelease_Page_Objects release = new CreateRelease_Page_Objects(driver);
		// PageFactory.initElements(driver,CreateRelease_Page_Objects.class);
		/*
		 * CreateRelease_Page_Objects.tenantcreationsnapshot.click();
		 * CreateRelease_Page_Objects.Notification.click();
		 * CreateRelease_Page_Objects.Notification.click(); Thread.sleep(2000);
		 * JavascriptExecutor js = (JavascriptExecutor) driver;
		 * //js.executeScript("arguments[0].scrollIntoView(true);",
		 * CreateRelease_Page_Objects.tenantcreationsnapshot);
		 * js.executeScript("window.scrollTo(0, document.body.scrollHeight)"
		 * ,CreateRelease_Page_Objects.tenantcreationsnapshot); Thread.sleep(2000);
		 * boolean tenantsnapshot = ScreenshotTest.compareScreenshot(driver,
		 * CreateRelease_Page_Objects.tenantcreationsnapshot,
		 * constants.expectedtenantsnapshot,constants.actualtenantsnapshot);
		 * softAssert.assertTrue(
		 * tenantsnapshot,"Screenshot comparison failed! Check the diff image.");
		 */

		// CreateRelease_Page_Objects.hyperlink.click();
		Thread.sleep(2000);
		release.createReleaseButton.click();
		// CreateRelease_Page_Objects.createReleaseDialogBox.click();
		release.Notification.click();
		release.Notification.click();
		takeScreenshot();
		boolean isMatch = ScreenshotTest.compareScreenshot(driver, release.createReleaseDialogBox,
				Constants.expectedcreatereleasesnapshot, Constants.actualcreatereleasesnapshot);
		softAssert.assertTrue(isMatch, "Screenshot comparison failed! Check the diff image.");
		// System.out.println(isMatch);
		// CreateDeployment_Page_Objects.createDeploymentDialogBox.click();
		String tittle = release.ReleaseTittle.getText();
		softAssert.assertEquals("Create a new VolPay release", tittle);
		String labellabel = release.labelLabel.getText();
		softAssert.assertEquals(labellabel, "Label *");
		String labeldesc = release.labelDescription.getText();
		softAssert.assertEquals(labeldesc, "Description *");
		String labelbranch = release.labelBranch.getText();
		softAssert.assertEquals(labelbranch, "Branch *");
		String labelvolpayversion = release.labelVolpayVersion.getText();
		softAssert.assertEquals(labelvolpayversion, "VolPay Version *");
		String labeltooltip = release.tooltipLabel.getAttribute("title");
		softAssert.assertEquals(labeltooltip, "Name for the release, this should be unique and easily identifiable.");
		String desctooltip = release.tooltipDescription.getAttribute("title");
		softAssert.assertEquals(desctooltip, "Description for the release");
		String branchtooltip = release.tooltipBranch.getAttribute("title");
		softAssert.assertEquals(branchtooltip, "Branch name from which the release should be built.");
		String volpayversiontooltip = release.tooltipVolpayVersion.getAttribute("title");
		softAssert.assertEquals(volpayversiontooltip, "VolPay Version of the Branch.");
		release.releaseTextbox.sendKeys(Constants.releasetextbox);
		release.descriptionTextbox.sendKeys(Constants.descriptiontextbox);
		release.branchTextbox.sendKeys(Constants.releasebranch);
		Thread.sleep(2000);
		release.volpayversionDropdown.click();
		release.dropdownSelect.click();
		release.createRelease.click();

	}
}
