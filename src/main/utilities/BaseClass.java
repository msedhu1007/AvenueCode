package src.main.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.thoughtworks.selenium.Selenium;

public class BaseClass {

	public static WebDriver driver = null;
	public static String ieDriver = ".//IEDriverServer.exe";
	public static String chromeDriver = ".//chromedriver.exe";
	public static int time = 30;
	public static Selenium rc = null;
	public static String baseUrl = "https://qa-test.avenuecode.com/";
	public static String Browser = "CH";
	
	

	public void openBrowser(String browser) throws Exception {
		try {
			if (browser.equalsIgnoreCase("FF")) {
				driver = new FirefoxDriver();
			} else if (browser.equalsIgnoreCase("CH")) {
				System.setProperty("webdriver.chrome.driver",
						".//chromedriver.exe");
				driver = new ChromeDriver();
			} else if (browser.equalsIgnoreCase("IE")) {
				System.setProperty("webdriver.ie.driver",
						".//IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			}
			sleep(4);
			loadURL();

		} catch (WebDriverException e) {
			System.out.println(e.getMessage());
		}

	}

	
	public static void tearDownApp() {
		driver.close();
		driver.quit();
	}
	
	public static void Click(By objname) {
		try {
			driver.findElement(objname).click();
			reportInfo("clicked on '" + objname + "'");
		} catch (Exception e) {
			reportFail("element '" + objname + "' is not displayed");
			Assert.fail("element '" + objname + "' is not displayed");
		}
	}
	
	public static void reportPass(String message){
		System.err.println(message);
		Reporter.log(message);
	}
	
	
	/** report information */
	public static void reportInfo(String message) {
		System.out.println(message);
		Reporter.log(message);
	}

	/** report fail */
	public static void reportFail(String message) {
		System.out.println("Fail: " + message);
		Reporter.log("Fail: " + message);
	}
	
	
	public static void SelectTextByValue(By objname, String value) {
		try {
			Select select = new Select(driver.findElement(objname));
			reportInfo("dropdown '" + objname + "' is selected");

			select.selectByValue(value);
			reportInfo("text '" + value + "' is selected from the dropdown '"
					+ objname + "'");
		} catch (Exception e) {
			reportFail("'" + objname + "' is not present or text '" + value
					+ "' is not selected");
			Assert.fail("'" + objname + "' is not present or text '" + value
					+ "' is not selected");
		}

	}
	
	
	public static void WaitForElementPresent(By objname, int time) {
		try{
			WebDriverWait newWait = new WebDriverWait(driver, time);
			newWait.until(ExpectedConditions.presenceOfElementLocated(objname));
		}catch(Exception e){
			Assert.fail("timeout error: element '" + objname + "' not present");
		}
	}
	
	public static void loadURL() {
		try{
			driver.manage().window().maximize();
			rc = new com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium(driver, baseUrl);
			driver.get(baseUrl);
		}catch(Exception e){
			reportFail("Unable to load Url '" + baseUrl + "'");
			Assert.fail("Unable to load Url '" + baseUrl + "'");
		}
	}
	
	public static void SendKeys(By objname, String value) {
		try {
			driver.findElement(objname).clear();
			driver.findElement(objname).sendKeys(value);
			reportInfo("'" + value + "' is entered in '" + objname + "'");
		} catch (Exception e) {
			reportFail("element '" + objname + "' is not displayed");
			Assert.fail("element '" + objname + "' is not displayed");
		}
	}


	public static void sleep(int time) throws Exception {
		Thread.sleep(time*1000);
	}
	
	public static String getText(By objname){
		String strValue = "";
		try{
			strValue = driver.findElement(objname).getText();
		}	
		catch (Exception e) {
			e.printStackTrace();
		}
		return strValue;
	}
	
	public static WebElement getTable(By objname){
		WebElement ele = null;
		try{
		 return driver.findElement(objname);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return ele;
	}
	
}
