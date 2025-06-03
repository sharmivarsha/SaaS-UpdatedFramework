package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserMail_Page_Objects {
	@FindBy(name="loginfmt")
    public static WebElement mailUsername;
	@FindBy(id="idSIButton9")
	public static WebElement nextButton;
	@FindBy (name="passwd")
	public static WebElement password;
	@FindBy(xpath="//input[@type='submit']")
	public static WebElement submitButton;
	@FindBy(xpath="//input[@type='submit']")
	public static WebElement yesButton;
}
