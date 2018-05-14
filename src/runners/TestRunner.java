package src.runners;

import java.io.File;

import org.junit.runner.RunWith;
import org.testng.annotations.AfterClass;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		strict = false, features = "src/test/features", glue = {"stepDefinitions","src.test.utilities"},
		plugin = {"pretty","com.cucumber.listener.ExtentCucumberFormatter:output/report.html", "html:target/cucumber-html-report","json:target/cucumber.json"}, tags = {"@subtask, @mytask"}, monochrome = false)

public class TestRunner {
	@AfterClass
	public static void teardown() {

		Reporter.loadXMLConfig(new File("target/extent-config.xml"));
		Reporter.setSystemInfo("user", System.getProperty("user.name"));
		Reporter.setSystemInfo("os", "Windows 10");
		Reporter.setTestRunnerOutput("Avenue Code message");
	}

}
