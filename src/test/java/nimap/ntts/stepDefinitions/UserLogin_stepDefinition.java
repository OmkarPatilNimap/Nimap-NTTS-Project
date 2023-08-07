package nimap.ntts.stepDefinitions;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import nimap.ntts.pageObjects.DashboardPage;
import nimap.ntts.pageObjects.LandingPage;
import nimap.ntts.pageObjects.LoginPage;
import nimap.ntts.pageObjects.UserEmployeeListPage;
import nimap.ntts.pageObjects.User_EmployeeListPage;
import nimap.ntts.testComponents.BaseTest;
import nimap.ntts.testComponents.ExtentReportClass;

@Listeners(ExtentReportClass.class)
public class UserLogin_stepDefinition extends BaseTest {
	WebDriver driver;
	LoginPage CL;
	LandingPage LP;
	UserEmployeeListPage UE;
	DashboardPage DP;
	WebDriverWait wait;

	User_EmployeeListPage EL;
	String firstEmpName;
	String firstEmpEmail;
	String firstEmpStatus;

	@Given("User Initialize The Browser")
	public void user_initialize_the_browser() {
	}

	@Given("User select the browser")
	public void user_select_the_browser() throws IOException {
		driver = initializeDriver();
		CL = new LoginPage(driver);
		LP = new LandingPage(driver);
		UE = new UserEmployeeListPage(driver);
		DP = new DashboardPage(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@And("User enter a credential {string} {string}")
	public void user_enter_a_credential(String Username, String Password) {
		CL = new LoginPage(driver);
		CL.getEmpId().sendKeys(Username);
		CL.getEmpPwd().sendKeys(Password);
	}

	@Then("Click on Sign in button")
	public void click_on_sign_in_button() {
		CL.getSignInBtn().click();
	}

	@And("Verify Login Success Outcome")
	public void verify_login_success_outcome() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(LP.getloginSuccText()));
		String msg = LP.getloginSuccText().getText();
		try {
			Assert.assertEquals(msg, prop.getProperty("adminLoginSuccessText"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Then("Logout and close the current browser")
	public void Logout_and_close_the_current_browser() throws InterruptedException {
		wait.until(ExpectedConditions.invisibilityOf(LP.getloginSuccText()));
		UE.getUesrProfileImg().click();
		UE.getLogOutBtn().click();
		driver.close();
	}

	@And("User Currently is on Login Page")
	public void user_currently_is_on_login_page() throws IOException {
		driver.get(goToNttsPage());
		String url = driver.getCurrentUrl();
		try {
			Assert.assertEquals(url, prop.getProperty("url") + "login");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("UserIson Loginprotal");
	}

	@When("^User enter valid and invalid credential (.*) (.*)$")
	public void user_enter_valid_and_invalid_credential(String Username, String Password) throws InterruptedException {
		CL = new LoginPage(driver);
		CL.getEmpId().clear();
		CL.getEmpId().sendKeys(Username);
		CL.getEmpPwd().clear();
		CL.getEmpPwd().sendKeys(Password);
		CL.getSignInBtn().click();
		Thread.sleep(1000);
	}

	@And("Verify the Outcome Fail")
	public void verify_the_outcome_fail() throws InterruptedException {
		Thread.sleep(300);
		if (CL.getInvalidEmailOrPwdMsg().isDisplayed()) {
			String errorMsg = CL.getInvalidEmailOrPwdMsg().getText();
			errorMsg.equalsIgnoreCase(prop.getProperty("emailErrMsg"));
			System.out.println("Both Invalid Email and Password");
			System.out.println(CL.getInvalidEmailOrPwdMsg().getText());
			Thread.sleep(200);
		} else if (CL.getLoginPassErrMsg().isDisplayed()) {
			CL.getLoginPassErrMsg().getText().equalsIgnoreCase(prop.getProperty("passErrMsg"));
			System.out.println("Invalid Password");
			System.out.println(CL.getLoginPassErrMsg().getText());
			Thread.sleep(200);
		} else if (CL.getEmpId().isDisplayed()) {
			CL.getEmpId().getText().equalsIgnoreCase(prop.getProperty("emailErrMsg"));
			System.out.println("Empty EmailID Filed Error MEssage");
			Thread.sleep(200);
		} else {
			CL.emptyPwdErrMsg().isDisplayed();
			CL.emptyPwdErrMsg().getText().equalsIgnoreCase(prop.getProperty("emptyPassField"));
			System.out.println("Empty Password Filed Error Msg");
			System.out.println(CL.emptyPwdErrMsg().getText());
			Thread.sleep(200);
		}
	}

	@Then("Close The Browser")
	public void close_the_browser() {
		driver.close();
	}

	@When("User clicks on forgot password link")
	public void user_clicks_on_forgot_password_link() {
		CL.getForgotPassLink().click();
	}

	@And("Enter Email")
	public void enter_email_and_click_on_send_otp() {
		wait.until(ExpectedConditions.visibilityOf(CL.goToEnterEmail()));
		CL.goToEnterEmail().sendKeys(prop.getProperty("email"));
	}

	@And("Click on send OTP Btn")
	public void click_on_send_otp_btn() throws InterruptedException {
		CL.getSendOtpBtn().click();
//		CL.getOtpSendSuccMsg().getText();
//		System.out.println(CL.getOtpSendSuccMsg().getText());
	}

	@And("Verify The OTP Popup")
	public void verify_the_otp_popup() throws InterruptedException {
		Thread.sleep(300);
		if (CL.getOtpSendSuccMsg().isDisplayed()) {
			CL.getOtpSendSuccMsg().getText().equalsIgnoreCase(prop.getProperty("otpSendPopupmsg"));
		} else if (CL.getInvalidEmailMsg().isDisplayed()) {
			CL.getInvalidEmailMsg().getText().equalsIgnoreCase(prop.getProperty("invalidEmailMsg"));
		}
	}

	@And("User Enter Invalid OTP and New Password")
	public void user_enter_invalid_otp_and_new_password() throws InterruptedException {
		for (int i = 1; i <= 6; i++) {
			CL.getOtpBlocks().get(i - 1).sendKeys(prop.getProperty("otpBlock" + i));
			Thread.sleep(200);
		}
		if (CL.getEnterNewPass().isDisplayed()) {
			CL.getEnterNewPass().sendKeys(prop.getProperty("enterNewPass"));
			CL.getSubmitBtn().click();
		}
	}

	@And("Verify OTP Message")
	public void verify_otp_message() throws InterruptedException {
		Thread.sleep(300);
		wait.until(ExpectedConditions.visibilityOf(CL.getInvalidOtpMsg()));
		Assert.assertEquals(CL.getInvalidOtpMsg().getText(), prop.getProperty("otpInvalidMsg"));
	}

	@When("User clicks on Sign In With OTP Link")
	public void user_clicks_on_sign_in_with_otp_link() {
		CL.getSignInWithOtpLnk().click();
	}

	@And("User Enter InValid OTP")
	public void user_enter_in_valid_otp() throws InterruptedException {
		// LoginPage CL = new LoginPage(driver);
		for (int i = 1; i <= 6; i++) {
			CL.getOtpBlocks().get(i - 1).sendKeys(prop.getProperty("otpBlock" + i));
			Thread.sleep(200);
		}
		CL.getSignInBtn1().click();
	}

	@When("Enter Invalid Email")
	public void enter_invalid_email() {
		wait.until(ExpectedConditions.visibilityOf(CL.goToEnterEmail()));
		CL.goToEnterEmail().sendKeys(prop.getProperty("invalidEmail"));
	}
//=====================================EmployeeList========================

	@When("User Clicks on Masters Menu and Select Employee Sub Menu")
	public void user_clicks_on_masters_menu_and_select_employee_sub_menu() {
		EL = new User_EmployeeListPage(driver);
		wait.until(ExpectedConditions.elementToBeClickable(EL.getMastersMenu()));
		EL.getMastersMenu().click();
		wait.until(ExpectedConditions.elementToBeClickable(EL.getUserMenu()));
		EL.getUserMenu().click();
	}

	@Then("Open Employee List Page")
	public void open_employee_list_page() {
		String actualTitle = EL.getEmpListTitle().getText();
		Assert.assertEquals(actualTitle, "Employees List");
	}

	@Then("User Clicks on First Employee From the List")
	public void user_clicks_on_first_employee_from_the_list() throws InterruptedException {
		Thread.sleep(1000);
		firstEmpName = EL.getEmpNames().get(0).getText();
		firstEmpEmail = EL.getEmpEmails().get(0).getText();
		firstEmpStatus = EL.getEmpStatus().get(0).getText();
		wait.until(ExpectedConditions.elementToBeClickable(EL.getEmpNames().get(0)));
		EL.getEmpNames().get(0).click();
	}

	@Then("User Redirect To Selected Employee Detais Page")
	public void user_redirect_to_selected_employee_detais_page() {
		String empName = EL.getEmpDetailsTitle().getText();
		empName.equalsIgnoreCase(firstEmpName);
	}

	@Then("Verify The Employee Detais Are The Same As Selected Employee")
	public void verify_the_employee_detais_are_the_same_as_selected_employee() {
		String actualEmpName = EL.getEmpDetailsTitle().getText();
		String ActualEmpEmail = EL.getEmpDetailsEmail().getText();
		String ActualEmpStatus = EL.getEmpDetailsStatus().getText();
		actualEmpName.equalsIgnoreCase(firstEmpName);
		ActualEmpEmail.equalsIgnoreCase(firstEmpEmail);
		ActualEmpStatus.equalsIgnoreCase(firstEmpStatus);
	}

	@Then("User Clicks on Add Employee button")
	public void user_clicks_on_add_employee_button() {
		wait.until(ExpectedConditions.invisibilityOf(LP.getloginSuccText()));
		EL.getAddEmpBtn().click();
	}

	@Then("User Redirect To Add Employee Page")
	public void user_redirect_to_add_employee_page() {
		EL.getAddEmpPageTitle().getText().equalsIgnoreCase(prop.getProperty("addEmpPageTitle"));
	}

	@Then("User Enter Valid Employee Detais")
	public void user_enter_valid_employee_detais() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(EL.getEmpName()));
		EL.getEmpName().sendKeys(prop.getProperty("newEmpName"));
		Actions a = new Actions(driver);
		a.click(EL.getTechnologyDropDown()).sendKeys("Selenium").keyDown(Keys.ENTER).build().perform();
		a.click(EL.getRolesDropDown()).sendKeys("ADMIN").keyDown(Keys.ENTER).build().perform();
	//	a.click(EL.getGenderDropDown().get(1)).sendKeys("MAIL").keyDown(Keys.ENTER).build().perform();
		Thread.sleep(3000);
	}
}
