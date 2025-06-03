package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UpgradeVolpay_Page_Objects {
	WebDriver driver;
	public UpgradeVolpay_Page_Objects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		}

	@FindBy(xpath="//span[text()='Upgrade VolPay']")
	public WebElement UpgradeVolpay;
	@FindBy(xpath="//h2[text()='Upgrade VolPay Version']")
	public WebElement Tittle;
	@FindBy(xpath="//label[@for='VolPay Version']")
	public WebElement LabelVolpayVersion;
	@FindBy(xpath="//div[@class='p-dropdown-trigger']")
	public WebElement TextBoxVolpayVersion;
	@FindBy(xpath="//li[@role='option']/span[text()='3.3.1']")
	public WebElement DropDown;
	@FindBy(xpath="//button[text()='Upgrade']")
	public WebElement UpgradeButton;
}
