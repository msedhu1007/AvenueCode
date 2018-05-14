package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.And;
import src.main.utilities.BaseClass;
import src.main.utilities.WebTable;

public class Tasks extends BaseClass{
	
	WebDriver driver;

	By txt_newTask = By.id("new_task");
	By ele_heading = By.xpath("//h1");
	By btn_AddTask = By.cssSelector("span.input-group-addon.glyphicon.glyphicon-plus");
	By tbl_Task = By.cssSelector("table.table");
	
	
	public Tasks(WebDriver driver){
		this.driver = driver;
	}
	
	public Boolean verifyTaskPageOpened(){
		try{
			WaitForElementPresent(txt_newTask, 15);
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	public Boolean verifyDisplayMessage(String value){
		try{
			if(getText(ele_heading).equalsIgnoreCase(value)){
				return true;
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	public void createTask(String task){
		try{
			SendKeys(txt_newTask,task);
			Click(btn_AddTask);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public boolean verify_task_presence_table(String taskname){
		Boolean flag = false;
		try{
			WebTable tbl_task = new WebTable(getTable(tbl_Task));
			for(int i=2;i<=tbl_task.getRowCount();i++){
				if(tbl_task.getCellData(i, 2).equalsIgnoreCase(taskname)){
					flag = true;
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}
	

	
	public void user_navigate_ManageSubTask(String taskname){
		try{
			WebTable tbl_task = new WebTable(getTable(tbl_Task));
			for(int i=2;i<=tbl_task.getRowCount();i++){
				if(tbl_task.getCellData(i, 2).equalsIgnoreCase(taskname)){
					tbl_task.getCell(i,4).click();
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
}
