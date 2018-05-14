package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.HomePage;

import org.testng.annotations.Test;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.Tasks;
import pageObjects
.*;public class MyTasks {
	WebDriver driver;
	LoginPage objLP = new LoginPage(driver);
	HomePage objHP = new HomePage(driver);
	LandingPage objLNP = new LandingPage(driver);
	Tasks objTSK = new Tasks(driver);

	@Given("^User logged in to the ToDo application with \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_logged_in_to_the_ToDo_application_with_and(String username, String password) throws Throwable {
		objHP.click_Login();
		objLP.login_ToDoApp(username, password);

	}

	@When("^User navigates to MyTasks page$")
	public void user_navigates_to_MyTasks_page() throws Throwable {
		Assert.assertTrue(objLNP.verify_HomePg());
		objLNP.click_MyTasks();
	}

	@Then("^message \"([^\"]*)\" should be displayed$")
	public void message_should_be_displayed(String msg) throws Throwable {
		Assert.assertTrue(objTSK.verifyTaskPageOpened());
		Assert.assertTrue(objTSK.verifyDisplayMessage(msg),"Verify the Displayed message in MyTasks page");
		}
	
	@And("User creates a task (.*)$")
	public void user_creates_task(String taskname){
		objTSK.createTask(taskname);
	}
	
	@Then("^\"(.*?)\" Task should not get created$")
	public void task_shouldnot_created(String taskname){
		Assert.assertTrue(!objTSK.verify_task_presence_table(taskname),"Verify that the task is not created");
	}
	
	@And("User navigates to \"([^\"]*)\" SubTasks page")
	public void user_navigates_subtask(String taskname){
		objTSK.user_navigate_ManageSubTask(taskname);
	}

}
