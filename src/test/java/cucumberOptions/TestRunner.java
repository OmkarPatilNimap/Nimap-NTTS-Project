package cucumberOptions;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/cucumber", glue = "stepDefinitions", monochrome = true, plugin = { "pretty",
		"html:target/cucumber.html",
		"com.cucumber.listener.ExtentCucumberFormatter:/report.html" }, tags = "@UserLoginTest")
public class TestRunner {

}