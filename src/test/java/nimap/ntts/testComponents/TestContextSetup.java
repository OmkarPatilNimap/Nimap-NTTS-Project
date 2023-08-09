package nimap.ntts.testComponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import nimap.ntts.pageObjects.DashboardPage;
import nimap.ntts.pageObjects.LandingPage;
import nimap.ntts.pageObjects.LoginPage;
import nimap.ntts.pageObjects.UserEmployeeListPage;
import nimap.ntts.pageObjects.User_EmployeeListPage;

public class TestContextSetup {

	public WebDriver driver;
	public LoginPage CL;
	public LandingPage LP;
	public UserEmployeeListPage UE;
	public DashboardPage DP;
	public WebDriverWait wait;
	public User_EmployeeListPage EL;
}
