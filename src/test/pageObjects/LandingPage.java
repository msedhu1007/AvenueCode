package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import src.main.utilities.BaseClass;

public class LandingPage extends BaseClass{

	WebDriver driver;
	By lnk_SignIn = By.xpath("//a[text()='Home']");
	By btn_MyTask = By.xpath("//a[text()='My Tasks' and @role='button']");
	
	
	public LandingPage(WebDriver driver){
		this.driver = driver;
	}
	
	//Verify Landing Page
	public Boolean verify_HomePg(){
		Boolean strValue = false;
		try{
			WaitForElementPresent(lnk_SignIn,30);
				return true;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return strValue;
	}
	
	public void click_MyTasks(){
		try{
			WaitForElementPresent(btn_MyTask, 10);
			Click(btn_MyTask);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
