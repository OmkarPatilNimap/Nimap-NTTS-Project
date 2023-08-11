package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "@target/failed_scenarios.txt", glue = "nimap.ntts.stepDefinitions", monochrome = true, plugin = {
		"html:target/cucumber.html", "json:target/cucumber.json",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" })
public class FailedTestRunner extends AbstractTestNGCucumberTests {
//
//	@Override
//	@DataProvider(parallel=true)
//	public Object[][] scenarios()
//	{
//		return super.scenarios();
//	}

}

//(plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})

//"com.cucumber.listener.ExtentCucumberFormatter:target/report.html",
//"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:target/report.html" 