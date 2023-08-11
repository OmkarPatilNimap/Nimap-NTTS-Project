package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/features", glue = "nimap.ntts.stepDefinitions", monochrome = true, tags = "@UserLoginTest", plugin = {
		"html:target/cucumber.html", "json:target/cucumber.json",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "rerun:target/failed_scenarios.txt" })
public class TestNGTestRunner extends AbstractTestNGCucumberTests {

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