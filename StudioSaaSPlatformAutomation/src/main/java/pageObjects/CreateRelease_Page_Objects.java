package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateRelease_Page_Objects {
	
	WebDriver driver;
	public CreateRelease_Page_Objects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		}
	@FindBy(xpath="//div[@class='flex flex-col flex-1 overflow-auto shadow-inner']")
	public WebElement tenantcreationsnapshot;
	@FindBy(xpath="//span[text()='Create Release']")
	public WebElement createReleaseButton;
	@FindBy(xpath="(//div[contains(@class,'transition-colors')])[2]")
	public WebElement Notification;
	@FindBy(xpath="//div[contains(@class,\"absolute border-border border\")]")
	//@FindBy(xpath="//body[@class='portal']")
	public WebElement createReleaseDialogBox;
	@FindBy(xpath="//h2[text()=\"Create a new VolPay release\"]")
	public WebElement ReleaseTittle;
	@FindBy(xpath="//label[@for='Label']")
	public WebElement labelLabel;
	@FindBy(xpath="//label[@for='Description']")
	public WebElement labelDescription;
	@FindBy(xpath="//label[@for='Branch']")
	public WebElement labelBranch;
	@FindBy(xpath="//label[@for='VolPay Version']")
	public WebElement labelVolpayVersion;
	@FindBy(xpath="//label[@for=\"Label\"]/child::div[@class='inline-block ml-2 text-gray-400 cursor-pointer']")
	public WebElement tooltipLabel;
	@FindBy(xpath="//label[@for=\"Description\"]/child::div[@class='inline-block ml-2 text-gray-400 cursor-pointer']")
	public WebElement tooltipDescription;
	@FindBy(xpath="//label[@for=\"Branch\"]/child::div[@class='inline-block ml-2 text-gray-400 cursor-pointer']")
	public WebElement tooltipBranch;
	@FindBy(xpath="//label[@for=\"VolPay Version\"]/child::div[@class='inline-block ml-2 text-gray-400 cursor-pointer']")
	public WebElement tooltipVolpayVersion;
	@FindBy(xpath="//label[@for=\"Label\"]/following::input[@class='p-inputtext p-component']")
	public WebElement releaseTextbox;
	@FindBy(xpath="//textarea[@name=\"description\"]")
	public WebElement descriptionTextbox;
	@FindBy(xpath="//label[@for=\"Branch\"]/following::input[@class='p-inputtext p-component']")
	public WebElement branchTextbox;
	@FindBy(xpath="//div[@class=\"p-dropdown-trigger\"]")
	public WebElement volpayversionDropdown;
	@FindBy(xpath="//li[@aria-label=\"3.3.1\"]")
	public WebElement dropdownSelect;
	@FindBy(xpath="//button[text()=\"Create release\"]")
	public WebElement createRelease;
	
}
