package nimap.ntts.stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import nimap.ntts.pageObjects.DashboardPage;
import nimap.ntts.pageObjects.LandingPage;
import nimap.ntts.pageObjects.LoginPage;
import nimap.ntts.pageObjects.UserEmployeeListPage;
import nimap.ntts.testComponents.BaseTest;
import nimap.ntts.testComponents.TestContextSetup;

public class DashboardStepDefinition extends BaseTest {
	WebDriver driver;
	LoginPage CL;
	LandingPage LP;
	UserEmployeeListPage UE;
	WebDriverWait wait;
	DashboardPage DP;
	TestContextSetup tcs;
	
	public DashboardStepDefinition(TestContextSetup tcs) {
		this.tcs=tcs;
	}
	
	
}
