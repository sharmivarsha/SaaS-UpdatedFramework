package testCases;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.CommonFunctions;
import utils.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.UserMail_Page_Objects;
@Listeners(utils.ExtentReportListener.class)
public class UserMailVerification extends CommonFunctions{
	public WebDriver driver1;
	
	
	@Test
	public void launchMail() throws IOException, InterruptedException {
	//loadProperties();
	String mailbrowser = Constants.mailbrowser;
	String mailurl =  Constants.mailurl;
	
	if(mailbrowser.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver1 = new ChromeDriver();
		
	}
	else if(mailurl.equalsIgnoreCase("firefox")){
		WebDriverManager.firefoxdriver().setup();
		driver1 = new FirefoxDriver();
	}
	driver1.manage().window().maximize();
	driver1.get(mailurl);
	driver1.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	PageFactory.initElements(driver1,UserMail_Page_Objects.class );
	UserMail_Page_Objects.mailUsername.sendKeys(Constants.mailusername);
	UserMail_Page_Objects.nextButton.click();
	UserMail_Page_Objects.password.sendKeys(Constants.mailpassword);
	Thread.sleep(5000);
   WebDriverWait wait = new WebDriverWait(driver1,Duration.ofSeconds(5000));
   wait.until(ExpectedConditions.elementToBeClickable(UserMail_Page_Objects.submitButton));
   UserMail_Page_Objects.submitButton.click();
   WebDriverWait wait1 = new WebDriverWait(driver1,Duration.ofSeconds(5000));
   wait1.until(ExpectedConditions.elementToBeClickable(UserMail_Page_Objects.yesButton));
   UserMail_Page_Objects.yesButton.click();
   
	}
}
	

