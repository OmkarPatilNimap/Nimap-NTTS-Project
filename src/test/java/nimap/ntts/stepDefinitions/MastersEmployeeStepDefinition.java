package nimap.ntts.stepDefinitions;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import nimap.ntts.pageObjects.DashboardPage;
import nimap.ntts.pageObjects.LandingPage;
import nimap.ntts.pageObjects.LoginPage;
import nimap.ntts.pageObjects.UserEmployeeListPage;
import nimap.ntts.pageObjects.User_EmployeeListPage;
import nimap.ntts.testComponents.BaseTest;
import nimap.ntts.testComponents.TestContextSetup;

public class MastersEmployeeStepDefinition extends BaseTest {
	LoginPage CL;
	LandingPage LP;
	UserEmployeeListPage UE;
	DashboardPage DP;
	WebDriverWait wait;
	JavascriptExecutor js;
	User_EmployeeListPage EL;
	String firstEmpName;
	String firstEmpEmail;
	String firstEmpStatus;
	Actions a;
	int rows;
	private final Properties prop;
	private final Properties prop1;

	private final TestContextSetup testContextSetup;

	public MastersEmployeeStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		this.wait = new WebDriverWait(testContextSetup.driver, Duration.ofSeconds(10));
		this.LP = new LandingPage(testContextSetup.driver);
		this.prop = super.prop;
		this.prop1 = super.prop1;
	}

}
