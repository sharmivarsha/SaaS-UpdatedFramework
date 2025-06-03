package utils;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class WebDriverManager {
	
	
	private static volatile WebDriverManager instance;
	private static ThreadLocal<WebDriver> tldriver = new ThreadLocal<WebDriver>();
	
	private WebDriverManager(){}
	
	private void initDriver(String browser) {
		switch(browser)	{
		case "chrome":
		    ChromeOptions options = new ChromeOptions();
		    options.addArguments("user-data-dir=/tmp/selenium-profile");
		    options.addArguments("--start-maximized");
		    options.addArguments("--disable-popup-blocking");
		    options.addArguments("--safebrowsing-disable-download-protection");
		    options.addArguments("--disable-features=DownloadBubble,DownloadBubbleV2");
		    options.addArguments("--disable-gpu");
		    options.setAcceptInsecureCerts(true);
		    options.addArguments("--disable-save-password-bubble");
		    options.addArguments("--disable-notifications");
		    options.addArguments("--disable-password-generation");
		    options.addArguments("--disable-infobars");
		    options.addArguments("--allow-running-insecure-content");
		    options.addArguments("--disable-web-security");
		    options.addArguments("--ignore-certificate-errors");
		    options.addArguments("--allow-insecure-localhost");
		    options.addArguments("--test-type");
		    options.addArguments("--disable-blink-features=Download");
		    options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
		    Map<String, Object> prefs = new HashMap<>();
		    prefs.put("credentials_enable_service", false);
		    prefs.put("profile.password_manager_enabled", false);
		    options.setExperimentalOption("prefs", prefs);
            //WebDriverManager.chromedriver().clearDriverCache().setup();
            tldriver.set(new ChromeDriver(options));
			break;
		case "firefox":
			FirefoxOptions optionfirefox = new FirefoxOptions();
            optionfirefox.setCapability("marionette", true);
			tldriver.set(new FirefoxDriver(optionfirefox));
			break;
		case "edge":
			tldriver.set(new EdgeDriver());
			break;
			
		default:
			throw new IllegalArgumentException("unsuported browser:" + browser);
			
		}
		WebDriver driver = tldriver.get();
	    if (driver == null) {
	        System.err.println("Failed to initialize WebDriver for browser: " + browser);
	    }

}
	public static WebDriverManager getInstance(String browser) {
		if(instance==null) {
			synchronized(WebDriverManager.class) {
				if(instance==null) {
					instance= new WebDriverManager();
				}
			}
			
		}
		if(tldriver.get()==null) {
			System.out.println("Initializing WebDriver for browser: " + browser);
			instance.initDriver(browser);
		}
		WebDriver driver = tldriver.get();
	    if (driver == null) {
	        System.err.println("WebDriver is null for browser: " + browser);
	    }
		return instance;
	}
	public WebDriver getDriver() {
		return tldriver.get();
	}
	public static void quitBrowser() {
		if(tldriver.get()!= null) {
			tldriver.get().quit();
			tldriver.remove();
		}
	}
}