package nimap.ntts.pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {

	WebDriver driver;
	DashboardPage DP;
	LoginPage CL;
	LandingPage LP;
	UserEmployeeListPage UE;
	User_EmployeeListPage EL;
	
	
	public PageObjectManager(WebDriver driver)
	{
		this.driver = driver;
	}
		
	public DashboardPage getDashboardPage() {
		DP = new DashboardPage(driver);
		return DP;	
	}
	
	public LoginPage getLoginPage() {
		CL = new LoginPage(driver);
		return CL;	
	}
	
	public LandingPage getLandingPage() {
		LP = new LandingPage(driver);
		return LP;	
	}
	
	public UserEmployeeListPage getUserEmployeeListPage() {
		UE = new UserEmployeeListPage(driver);
		return UE;	
	}
	
	public User_EmployeeListPage getUser_EmployeeListPage() {
		EL = new User_EmployeeListPage(driver);
		return EL;
	}
	
}
