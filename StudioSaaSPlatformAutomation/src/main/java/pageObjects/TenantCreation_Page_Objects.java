package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TenantCreation_Page_Objects {
	 WebDriver driver;

		public TenantCreation_Page_Objects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		}
	
	@FindBy(xpath="//a[@title='Tenants']")
	public WebElement clickicon;
	@FindBy(xpath="//span[text()='Add']")
	public  WebElement AddButton;
	@FindBy(xpath="//label[@for='Name']")
	public  WebElement LabelNameTenant;
	@FindBy(xpath="(//input[@class='p-inputtext p-component'])[1]")
	public  WebElement NameTextbox;
	@FindBy(xpath="//label[@for='Group']")
	public  WebElement LabelGroup;
	@FindBy(xpath="(//input[@class='p-inputtext p-component'])[1]")
	public  WebElement GroupTextbox;
	@FindBy(xpath="//label[@for='Organization Prefix']")
	public  WebElement LabelOrgPrefix;
	@FindBy(xpath="(//input[@class='p-inputtext p-component p-filled'])[3]")
	public  WebElement OrgPrefixTextbox;
	@FindBy(xpath="//label[@for='Display Name']")
	public  WebElement DisplayName;
	@FindBy(xpath="(//input[@class='p-inputtext p-component p-filled'])[4]")
	public  WebElement DisplayNameTextbox;
	@FindBy(xpath="//label[@for='Address']")
	public  WebElement LabelAddress;
	@FindBy(xpath="//textarea[@id='organization.address']")
	public  WebElement AddressTextbox;
	@FindBy(xpath="//label[@for='Country']")
	public  WebElement LabelCountry;
	@FindBy(xpath="//div[@class='p-dropdown-trigger']")
	public  WebElement CountryTextbox;
	//@FindBy(xpath="//ul[@class='p-dropdown-items']")
	//public static WebElement Countries;
	@FindBy(xpath="//ul[@class='p-dropdown-items']")
	public  List<WebElement> CountriesList;
	@FindBy(xpath="//span[text()=\"Singapore\"]")
	public  WebElement SelectValuesFromDropDown;
	@FindBy(xpath="//label[@for='Zip']")
	public  WebElement LabelZip;
	@FindBy(xpath="(//input[@class='p-inputtext p-component'])[1]")
	public  WebElement ZipTextBox;
	@FindBy(xpath="//label[@for='Website']")
	public  WebElement LabelWebsite;
	@FindBy(xpath="(//input[@class='p-inputtext p-component'])[1]")
	public  WebElement WebsiteTextBox;
	@FindBy(xpath="//label[@for='Phone']")
	public  WebElement LabelPhone;
	@FindBy(xpath="(//input[@class='p-inputtext p-component'])[1]")
	public  WebElement PhoneTextBox;
	@FindBy(xpath="//label[@for='Email']")
	public  WebElement LabelEmail;
	@FindBy(xpath="(//input[@class='p-inputtext p-component'])[1]")
	public  WebElement EmailTextBox;
	@FindBy(xpath="//button[text()='Next']")
	public  WebElement Button;
	//@FindBy(xpath="//div[@class='flex flex-col flex-1 overflow-auto shadow-inner']")
	//public static WebElement TenantConfiguration;
	@FindBy(xpath="(//input[@class=\"mx-auto h-[1.4rem] w-[1.4rem]\"])[1]")
	public  WebElement Checkbox;
	@FindBy(xpath="(//div[@class=\"p-dropdown-trigger\"])[1]")
	public  WebElement Region;
	//@FindBy(xpath="//ul[@class='p-dropdown-items']")
	//public  WebElement RegionList;
	@FindBy(xpath="//span[text()='East US 2']")
	public  WebElement DropdownValueRegion;
	@FindBy(xpath="(//div[@class=\"p-dropdown-trigger\"])[2]")
	public  WebElement VolpayVersion;
	@FindBy(xpath="//span[text()='3.3.0']")
	public  WebElement DropdownValueVolpayversion;
	@FindBy(xpath="//button[text()=\"Next\"]")
	public  WebElement Button1;
	@FindBy(xpath="//input[@name='users.0.firstName']")
	public  WebElement UsersFirstName;
	@FindBy(xpath="//input[@name='users.0.lastName']")
	public WebElement UsersLastName;
	@FindBy(xpath="//input[@name='users.0.email']")
	public WebElement Email;
	@FindBy(xpath="//input[@name='users.0.phone']")
	public WebElement Phone;
	@FindBy(xpath="//button[text()=\"Next\"]")
	public  WebElement Button2;
	@FindBy(xpath="//button[text()='Add Tenant']")
	public  WebElement AddTenant;
	@FindBy(xpath="//button[text()=\"Goto Tenant\"]")
	public  WebElement GoToTenant;
	

}
