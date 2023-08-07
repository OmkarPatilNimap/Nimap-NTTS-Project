package nimap.ntts.stepDefinitions;

import java.io.IOException;
import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import nimap.ntts.pageObjects.DashboardPage;
import nimap.ntts.pageObjects.LandingPage;
import nimap.ntts.pageObjects.LoginPage;
import nimap.ntts.pageObjects.UserEmployeeListPage;
import nimap.ntts.pageObjects.User_EmployeeListPage;
import nimap.ntts.testComponents.BaseTest;

public class MastersEmployee extends BaseTest {
	WebDriver driver;
	LoginPage CL;
	LandingPage LP;
	UserEmployeeListPage UE;
	DashboardPage DP;
	User_EmployeeListPage EL;
	WebDriverWait wait;
	String firstEmpName;
	String firstEmpEmail;
	String firstEmpStatus;

	
//	@Given("User select the browser")
	public void user_select_the_browser() throws IOException {
		driver = initializeDriver();
		CL = new LoginPage(driver);
		LP = new LandingPage(driver);
		UE = new UserEmployeeListPage(driver);
		DP = new DashboardPage(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	

}
