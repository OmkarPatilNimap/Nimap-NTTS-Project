package nimap.ntts.stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import nimap.ntts.pageObjects.LandingPage;
import nimap.ntts.pageObjects.LoginPage;
import nimap.ntts.pageObjects.UserEmployeeListPage;
import nimap.ntts.testComponents.BaseTest;

public class Dashboard_stepDefinition extends BaseTest {
	WebDriver driver;
	LoginPage CL;
	LandingPage LP;
	UserEmployeeListPage UE;
	WebDriverWait wait;
}
