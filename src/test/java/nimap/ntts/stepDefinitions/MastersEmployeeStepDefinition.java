package nimap.ntts.stepDefinitions;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import nimap.ntts.pageObjects.DashboardPage;
import nimap.ntts.pageObjects.LandingPage;
import nimap.ntts.pageObjects.LoginPage;
import nimap.ntts.pageObjects.UserEmployeeListPage;
import nimap.ntts.pageObjects.User_EmployeeListPage;
import nimap.ntts.testComponents.BaseTest;
import nimap.ntts.testComponents.TestContextSetup;

public class MastersEmployeeStepDefinition extends BaseTest {
	WebDriver driver;
	LoginPage CL;
	LandingPage LP;
	UserEmployeeListPage UE;
	DashboardPage DP;
	User_EmployeeListPage EL;
	WebDriverWait wait;
	TestContextSetup tcs;
	Actions a;
	
	String firstEmpName;
	String firstEmpEmail;
	String firstEmpStatus;

	public MastersEmployeeStepDefinition(TestContextSetup tcs) {
		this.tcs=tcs;
	}
	
//	@Given("User select the browser")
	public void user_select_the_browser() throws IOException {
		tcs.driver = initializeDriver();
		CL = new LoginPage(tcs.driver);
		LP = new LandingPage(tcs.driver);
		UE = new UserEmployeeListPage(tcs.driver);
		DP = new DashboardPage(tcs.driver);
		wait = new WebDriverWait(tcs.driver, Duration.ofSeconds(10));
		a = new Actions(tcs.driver);
	}
	

	
}
