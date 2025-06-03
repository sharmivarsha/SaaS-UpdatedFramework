package utils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;
import utils.WebDriverManager;

public class CommonFunctions {

	public static SoftAssert softAssert = new SoftAssert();
	public static WebDriver driver;

	@BeforeSuite
	@Parameters("browser")
	public void setUp(@Optional("chrome") String browser) throws IOException {
		// loadProperties();
		PropertyManager.load("./Globalconfig.properties");
		Constants.initialize();
		String url = Constants.url;
		driver = WebDriverManager.getInstance(browser).getDriver();
		if (driver == null) {
			System.out.println("Driver initialization failed!");
		} else {
			System.out.println("Driver initialized successfully!");
		}
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	@BeforeClass
    public void loadConfig() throws IOException {
        PropertyManager.load("./Globalconfig.properties");
        Constants.initialize();
    }

	public WebDriver getDriver() {
		return driver;
	}

	@AfterSuite
	public void tearDown() {
		driver.quit();
	}

	public String takeScreenshot() throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File src = screenshot.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "Screenshots/screenshot.png";
		File destination = new File(path);
		FileUtils.copyFile(src, destination);
		return path;
	}

}
