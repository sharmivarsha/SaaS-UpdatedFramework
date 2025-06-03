package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page_Objects {
	 WebDriver driver;

	public Login_Page_Objects(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
	}
	

	@FindBy(xpath="//label[@for='username']")
    public  WebElement usernamelabel;
	@FindBy(xpath="//input[@id='username']")
    public WebElement username;
	@FindBy(xpath="//label[@for='password']")
	public WebElement passwordlabel;
	@FindBy(xpath="//input[@id='password']")
	public WebElement password;
	@FindBy(xpath="//input[@id='kc-login']")
	public WebElement submitbutton;
	@FindBy(xpath="//span[@id='input-error']")
	public WebElement errormessage;
	
	
	
	
}
