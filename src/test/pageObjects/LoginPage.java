package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import src.main.utilities.BaseClass;

public class LoginPage extends BaseClass{

	WebDriver driver;
	By txt_email = By.id("user_email");
	By txt_password = By.id("user_password");
	By btn_SignIn = By.xpath("//input[@class='btn btn-primary']");
	
	
	public LoginPage(WebDriver driver){
		this.driver = driver;
	}
	
	public Boolean login_ToDoApp(String username, String password){
		Boolean strbln = false;
		try{
			WaitForElementPresent(txt_email, time);
			SendKeys(txt_email, username);
			SendKeys(txt_password, password);
			Click(btn_SignIn);
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return strbln;
	}
}
