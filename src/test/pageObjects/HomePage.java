package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import src.main.utilities.BaseClass;

public class HomePage extends BaseClass{
	
	WebDriver driver;
	By lnk_SignIn = By.xpath("//a[text()='Sign In']");
	By lnk_Register = By.linkText("Register");
	
	public HomePage(WebDriver driver){
		this.driver = driver;
	}
	
	//click Login link
	public void click_Login(){
		WaitForElementPresent(lnk_SignIn, 20);
		Click(lnk_SignIn);
	}
	
	
}
