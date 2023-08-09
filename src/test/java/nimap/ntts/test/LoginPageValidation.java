//package nimap.ntts.test;
//
//import org.openqa.selenium.support.ui.Select;
//import org.testng.Assert;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.Listeners;
//import org.testng.annotations.Test;
//
//import nimap.ntts.pageComponents.PageComponents;
//import nimap.ntts.pageObjects.LandingPage;
//import nimap.ntts.pageObjects.LoginPage;
//import nimap.ntts.pageObjects.UserEmployeeListPage;
//import nimap.ntts.testComponents.BaseTest;
//import nimap.ntts.testComponents.ExtentReportClass;
//@Listeners(ExtentReportClass.class)
//public class LoginPageValidation extends BaseTest {
//
//	LandingPage landingPage;
//
//	@Test
//	public void openUrlInBrowser() throws IOException {
//		launchApplication();
//	}
//
//	@Test(dependsOnMethods = { "openUrlInBrowser" }, priority = 0)
//	public void loginWithValidCredentials() throws IOException {
//		ExtentReportClass extentReportClass  = new ExtentReportClass();
//		extentReportClass.extentReports().createTest("Login With Valid Credentials");
//		LoginPage loginPage = new LoginPage(driver);
//		loginPage.goToLogin(prop.getProperty("email"), prop.getProperty("password"));
//		loginPage.clickOnSignin();
//		extentReportClass.extentReports().flush();
//		LoginPage loginPage = new LoginPage(WebDriver driver);
//	}
//
//	@Test(dependsOnMethods = { "loginWithValidCredentials" }, priority = 0)
//	public void loginSuccessfulMsgValidation() {
//		landingPage = new LandingPage(driver);
//		String msg = landingPage.loginSuccessfulGetText();
//		Assert.assertEquals(msg, prop.getProperty("adminLoginSuccessText"));
//	}
//
//	@Test(dependsOnMethods = { "loginSuccessfulMsgValidation" }, priority = 0)
//	public void goToMastersMenu() {
//		Assert.assertTrue(landingPage.goToMastersMenu().isDisplayed());
//		landingPage.goToMastersMenu().click();
//	}
//
//	@Test(dependsOnMethods = { "goToMastersMenu" }, priority = 0)
//	public void openUserSubMenu() {
//		Assert.assertTrue(landingPage.goToUserSubMenu().isDisplayed());
//		landingPage.goToUserSubMenu().click();
//	}
//	
//	@Test(dependsOnMethods = { "openUserSubMenu" }, priority = 0)
//	public void openFirstEmployeeDetails() {
//		UserEmployeeListPage userEmployeeListPage = new UserEmployeeListPage(driver);
//		userEmployeeListPage.selectEmployeeFromEmployeeList().click();
//	}
//
//	@Test
//	public void userLogout() throws InterruptedException {
//		PageComponents pageComponents = new PageComponents(driver);
//		pageComponents.logOut();
//		closeCurrentBrowser();
//	}
//
//}
