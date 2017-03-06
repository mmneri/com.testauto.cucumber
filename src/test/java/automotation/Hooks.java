package automotation;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import utilities.Constant;
import utilities.ExtentManager;
import utilities.Log;

public class Hooks {
	public static WebDriver driver;
	public static boolean bResult;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static String browser;
	
	@BeforeSuite
	public void BeforeSuite(){
		extent = ExtentManager.getInstance();
	}
	
	@BeforeTest
	@Parameters("browser")
	public void initialiseBrowser(String browser) {
		DOMConfigurator.configure("log4j.xml");
		if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty(Constant.firefox_webdriver, Constant.firefox_webdriver_path);
			driver = new FirefoxDriver();
		}else if (browser.equalsIgnoreCase("chrome")) { 
			System.setProperty(Constant.chrome_webdriver, Constant.chrome_webdriver_path);
			driver = new ChromeDriver();
		}	
		Hooks.browser = browser;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		Log.info("Open Browser");
	}

	@AfterTest
	public void closeBrowser() {
		driver.quit();
		Log.info("Close Browser");
	}
	
	@AfterSuite
	public void AftereSuite(){
		extent.flush();
		extent.close();
	}
}
