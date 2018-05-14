package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import src.main.utilities.BaseClass;
import src.main.utilities.WebTable;

public class EditingTasks extends BaseClass{
	WebDriver driver;
	
	By txt_newSubTask = By.id("new_sub_task");
	By txt_DueDate = By.id("dueDate");
	By btn_AddSubTask = By.id("add-subtask");
	By tbl_SubTasks = By.xpath("//h4[text()='SubTasks of this ToDo:']/following-sibling::table");
	
	public EditingTasks(WebDriver driver){
		this.driver = driver;
	}
	
	public void add_subTasks(String subTaskName, String dueDate){
		try{
			WaitForElementPresent(txt_newSubTask, 15);
			SendKeys(txt_newSubTask, subTaskName);
			SendKeys(txt_DueDate, dueDate);
			Click(btn_AddSubTask);
			sleep(2);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public Boolean verify_subtask_added(String subtaskname){
		try{
			WaitForElementPresent(tbl_SubTasks, time);
			WebTable tbl_subTask = new WebTable(getTable(tbl_SubTasks));
			for(int i = 2;i<=tbl_subTask.getRowCount();i++){
				if(tbl_subTask.getCellData(i, 2).equalsIgnoreCase(subtaskname)){
					return true;
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	

}
