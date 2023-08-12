package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import nimap.ntts.stepDefinitions.UserLoginStepDefinition;
import nimap.ntts.testComponents.TestContextSetup;

@CucumberOptions(features = "src/test/java/features", glue = "nimap.ntts.stepDefinitions", monochrome = true, tags = "@UserLoginTest or @EmployeeListVerificationTest", plugin = {
		"html:target/cucumber.html", "json:target/cucumber.json",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "rerun:target/failed_scenarios.txt" })
public class TestNGTestRunner extends AbstractTestNGCucumberTests {

	private final TestContextSetup testContextSetup = new TestContextSetup();
	private final UserLoginStepDefinition userLoginStepDefinition = new UserLoginStepDefinition(testContextSetup);

//	@Override
//	@DataProvider(parallel=true)
//	public Object[][] scenarios()
//	{
//		return super.scenarios();
//	}

}