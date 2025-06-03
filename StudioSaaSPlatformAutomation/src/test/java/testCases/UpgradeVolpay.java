package testCases;

import java.io.IOException;
import org.testng.annotations.Test;
import pageObjects.UpgradeVolpay_Page_Objects;
import utils.CommonFunctions;

public class UpgradeVolpay extends CommonFunctions {

	@Test(retryAnalyzer = utils.RetryAnalyzer.class)
	public void upgradeVolpay() throws IOException {
		UpgradeVolpay_Page_Objects upgrade = new UpgradeVolpay_Page_Objects(driver);
		upgrade.UpgradeVolpay.click();
		String tittle = upgrade.Tittle.getText();
		softAssert.assertEquals(tittle, "Upgrade VolPay Version");
		String label = upgrade.LabelVolpayVersion.getText();
		softAssert.assertEquals(label, "VolPay Version *");
		upgrade.TextBoxVolpayVersion.click();
		upgrade.DropDown.click();
		upgrade.UpgradeButton.click();

	}
}
