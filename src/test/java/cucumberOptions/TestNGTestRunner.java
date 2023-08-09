package cucumberOptions;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features",glue ="stepDefinitions"
,monochrome=true, tags ="@PlaceOrder or @OffersPage",
plugin= {"html:target/cucumber.html", "json:target/cucumber.json"})
public class TestNGTestRunner extends AbstractTestNGCucumberTests{

	@Override
	@DataProvider(parallel=true)
	public Object[][] scenarios()
	{
		return super.scenarios();
	}
	
}

//(plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})

//"com.cucumber.listener.ExtentCucumberFormatter:target/report.html",
//"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:target/report.html" 