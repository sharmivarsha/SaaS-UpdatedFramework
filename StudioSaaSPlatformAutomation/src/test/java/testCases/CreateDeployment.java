package testCases;

import java.io.IOException;
import java.time.Duration;
import java.util.UUID;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pageObjects.CreateDeployment_Page_Objects;
import utils.CommonFunctions;

public class CreateDeployment extends CommonFunctions {

	@Test(retryAnalyzer = utils.RetryAnalyzer.class)
	public void createDeployment() throws IOException, InterruptedException {
		PageFactory.initElements(driver, CreateDeployment_Page_Objects.class);
		CreateDeployment_Page_Objects.createDeploymentButton.click();
		// CreateDeployment_Page_Objects.createDeploymentDialogBox.click();
		String tittle = CreateDeployment_Page_Objects.deploymentTittle.getText();
		softAssert.assertEquals("Create a new VolPay deployment", tittle);
		String labelenvironment = CreateDeployment_Page_Objects.labelEnvironment.getText();
		softAssert.assertEquals(labelenvironment, "Environment *");
		String labellabel = CreateDeployment_Page_Objects.labelLabel.getText();
		softAssert.assertEquals(labellabel, "Label *");
		String labelprovisioning = CreateDeployment_Page_Objects.labelProvisioningGroup.getText();
		softAssert.assertEquals(labelprovisioning, "Provisioning Group ");
		String labelpreferspotinstance = CreateDeployment_Page_Objects.labelPreferSpotInstance.getText();
		softAssert.assertEquals(labelpreferspotinstance, "Prefer Spot Instance");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2000));
		wait.until(ExpectedConditions.elementToBeClickable(CreateDeployment_Page_Objects.Environment));
		CreateDeployment_Page_Objects.Environment.click();
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(1000));
		wait1.until(ExpectedConditions.elementToBeClickable(CreateDeployment_Page_Objects.environmentList));
		CreateDeployment_Page_Objects.environmentList.click();
		String labelname = UUID.randomUUID().toString().substring(0, 8);
		System.out.println(labelname);
		CreateDeployment_Page_Objects.labelTextBox.sendKeys(labelname);
		CreateDeployment_Page_Objects.provisioninggroupDropDown.click();
		CreateDeployment_Page_Objects.provisioninggroupList.click();
		CreateDeployment_Page_Objects.spotInstanceCheckbox.click();
		CreateDeployment_Page_Objects.createDeployment.click();
		CreateDeployment_Page_Objects.hyperlink.click();

	}
}
