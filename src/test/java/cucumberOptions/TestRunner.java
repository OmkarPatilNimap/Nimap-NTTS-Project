package cucumberOptions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/cucumber", glue = "stepDefinitions", monochrome = true, plugin = { "pretty",
		"html:target/cucumber.html",
		"com.cucumber.listener.ExtentCucumberFormatter:/report.html","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:/report.html" }, tags = "@UserLoginTest")
public class TestRunner {

}

//(plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})