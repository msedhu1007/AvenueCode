package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.EditingTasks;

public class SubTasks {
	
	WebDriver driver;
	EditingTasks objET = new EditingTasks(driver);
	
	@When("^User creates a SubTask \"([^\"]*)\" with \"([^\"]*)\"$")
	public void user_creates_a_SubTask(String subTaskName, String dueDate) throws Throwable {
	   objET.add_subTasks(subTaskName, dueDate);
	}

	@Then("^SubTask \"([^\"]*)\" should be created$")
	public void subtask_should_be_created(String subtaskname) throws Throwable {
	   Assert.assertTrue(objET.verify_subtask_added(subtaskname));
	}
	
	@Then("^SubTask \"([^\"]*)\" should not be created$")
	public void subtask_should_not_be_created(String subtaskname) throws Throwable {
		 Assert.assertFalse(objET.verify_subtask_added(subtaskname));
	}

}
