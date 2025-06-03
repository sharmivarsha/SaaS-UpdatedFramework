package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateDeployment_Page_Objects {

	@FindBy(xpath="//span[text()='Create Deployment']")
	public static WebElement createDeploymentButton;
	@FindBy(xpath="//div[contains(@class,\"absolute border-border border\")]")
	public static WebElement createDeploymentDialogBox;
	@FindBy(xpath="//h2[text()=\"Create a new VolPay deployment\"]")
	public static WebElement deploymentTittle;
	@FindBy(xpath="//label[@for='Environment']")
	public static WebElement labelEnvironment;
	@FindBy(xpath="//label[@for='Label']")
	public static WebElement labelLabel;
	@FindBy(xpath="//label[@for='Provisioning Group']")
	public static WebElement labelProvisioningGroup;
	@FindBy(xpath="//label[@for='Prefer Spot Instance']")
	public static WebElement labelPreferSpotInstance;
	//@FindBy(xpath="(//div[@class=\"p-dropdown-trigger\"])[1]")
	@FindBy(xpath="(//div[@class='p-dropdown-trigger']/child::*[local-name()='svg'])[1]")
	public static WebElement Environment;
	@FindBy(xpath="//li[contains(@class, 'p-dropdown-item')]/span[text()='Development']")
	public static WebElement environmentList;
	@FindBy(xpath="//input[@class='p-inputtext p-component']")
	public static WebElement labelTextBox;
	@FindBy(xpath="(//div[@class=\"p-dropdown-trigger\"])[2]")
	public static WebElement provisioninggroupDropDown;
	@FindBy(xpath="//li[contains(@class, 'p-dropdown-item')]/span[text()='vm-sandbox']")
	public static WebElement provisioninggroupList;
	@FindBy(xpath="//input[@id='useSpotInstance']")
	public static WebElement spotInstanceCheckbox;
	@FindBy(xpath="//button[text()='Create deployment']")
	public static WebElement createDeployment;
	//@FindBy(xpath="(//span[@class='hover:underline'])[2]")
	@FindBy(xpath="//a[span[starts-with(text(), 'HSBC Bank - ')]]")
	public static WebElement hyperlink;
	
	
}
