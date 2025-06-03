package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddUser_Page_Objects {
	WebDriver driver;
	public AddUser_Page_Objects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		}
	
	@FindBy(xpath="//span[text()=\"Add User\"]")
	public  WebElement adduserButton;
	@FindBy(xpath="//div[contains(@class,\"absolute border-border border\")]")
	public  WebElement adduserDialogBox;
	@FindBy(xpath="//h2[text()=\"Add User\"]")
	public  WebElement addUserTittle;
	@FindBy(xpath="//label[@for=\"First Name\"]")
	public  WebElement labelFirstName;
	@FindBy(xpath="(//input[@class=\"p-inputtext p-component\"])[1]")
	public  WebElement firstNameTextbox;
	@FindBy(xpath="//label[@for=\"Last Name\"]")
	public WebElement labelLastName;
	@FindBy(xpath="(//input[@class=\"p-inputtext p-component\"])[1]")
	public WebElement lastNameTextbox;
	@FindBy(xpath="//label[@for=\"Email\"]")
	public WebElement email;
	@FindBy(xpath="(//input[@class=\"p-inputtext p-component\"])[1]")
	public WebElement emailTextbox;
	@FindBy(xpath="//label[@for=\"Phone\"]")
	public WebElement Phone;
	@FindBy(xpath="(//input[@class=\"p-inputtext p-component\"])[1]")
	public WebElement phoneTextbox;
	@FindBy(xpath="//button[text()=\"Add User\"]")
	public WebElement userButton;
	
	

}
