package nimap.ntts.stepDefinitions;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
		Thread.sleep(200);
		if (CL.getInvalidEmailOrPwdMsg().isDisplayed()) {
			String errorMsg = CL.getInvalidEmailOrPwdMsg().getText();
			errorMsg.equalsIgnoreCase(prop.getProperty("emailErrMsg"));
			System.out.println("Both Invalid Email and Password");
			System.out.println(CL.getInvalidEmailOrPwdMsg().getText());
		} else if (CL.getLoginPassErrMsg().isDisplayed()) {
			CL.getLoginPassErrMsg().getText().equalsIgnoreCase(prop.getProperty("passErrMsg"));
			System.out.println("Invalid Password");
			System.out.println(CL.getLoginPassErrMsg().getText());
		} else if (CL.getEmpId().isDisplayed()) {
			CL.getEmpId().getText().equalsIgnoreCase(prop.getProperty("emailErrMsg"));
			System.out.println("Empty EmailID Filed Error MEssage");
		} else {
			CL.emptyPwdErrMsg().isDisplayed();
			CL.emptyPwdErrMsg().getText().equalsIgnoreCase(prop.getProperty("emptyPassField"));
			System.out.println("Empty Password Filed Error Msg");
			System.out.println(CL.emptyPwdErrMsg().getText());
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
	public void click_on_send_otp_btn() {
		CL.getSendOtpBtn().click();
		CL.getOtpSendSuccMsg().getText();
		System.out.println(CL.getOtpSendSuccMsg().getText());
	}

	@And("Verify The OTP Popup")
	public void verify_the_otp_popup() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(CL.getOtpSendSuccMsg()));
		if (CL.getOtpSendSuccMsg().isDisplayed()) {
			System.out.println(CL.getOtpSendSuccMsg().getText());
			Assert.assertEquals(CL.getOtpSendSuccMsg().getText(), prop.getProperty("otpSendPopupmsg"));
		} else {
			Assert.assertEquals(CL.getInvalidEmailMsg().getText(), prop.getProperty("invalidEmailMsg"));
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
		Thread.sleep(200);
		wait.until(ExpectedConditions.visibilityOf(CL.getInvalidOtpMsg()));
		Assert.assertEquals(CL.getInvalidOtpMsg().getText(), prop.getProperty("otpInvalidMsg"));
//		else if(CL.getPassResetSuccMsg().isDisplayed()) {
//			Assert.assertEquals(CL.getPassResetSuccMsg().getText(), prop.getProperty("passResetSuccMsg"));
//		}
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

	// ===============================================Dashborad===========================================================

	@When("User Clicks on Dashboard Menu")
	public void user_clicks_on_dashboard_menu() {
		LP = new LandingPage(driver);
		DP = new DashboardPage(driver);
		LP.goDashboard().click();
	}

	@When("User Select Highlited Date as a Start Date in Calander")
	public void user_select_highlited_date_as_a_start_date_in_calander() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(DP.goToCalanderStartDate()));
		DP.goToCalanderStartDate().click();
		wait.until(ExpectedConditions.visibilityOf(DP.getSelectHighlitedStartDate()));
		DP.getSelectHighlitedStartDate().click();
	}

	@When("User Select Today as an End Date in Calander")
	public void user_select_today_date_as_an_end_date_in_calander() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(DP.goToCalanderEndDate()));
		DP.goToCalanderEndDate().click();
		wait.until(ExpectedConditions.visibilityOf(DP.getSelectNextEndDate()));
		DP.getSelectNextEndDate().click();
	}

	@When("User is on Home Page {string} {string}")
	public void user_is_on_home_page(String Username, String Password) {
		driver.get(goToNttsPage());
		CL.getEmpId().sendKeys(Username);
		CL.getEmpPwd().sendKeys(Password);
		CL.getSignInBtn().click();
	}

	@Then("User Select End Date Before Start Date in Calander")
	public void user_select_end_date_before_start_date_in_calander() {
		wait.until(ExpectedConditions.visibilityOf(DP.goToCalanderStartDate()));
		DP.goToCalanderEndDate().click();
		wait.until(ExpectedConditions.visibilityOf(DP.getPreviousMonth()));
		DP.getPreviousMonth().click();
		try {
			wait.until(ExpectedConditions.elementToBeClickable(DP.getSelectDateBeforeStartDate()));
		} catch (TimeoutException e) {
			System.out.println("Date is no Clickable");
		}
		Assert.assertFalse(DP.getSelectDateBeforeStartDate().isEnabled());
		System.out.println("End Date is Not Selectable Before Start Date");
	}

	@When("User is on Home Page")
	public void user_is_on_home_page() {
		driver.navigate().refresh();
	}

	@Then("User Select Previous Month Date as a Start Date in Calander")
	public void user_select_previous_month_date_as_a_start_date_in_calander() {
		wait.until(ExpectedConditions.visibilityOf(DP.goToCalanderStartDate()));
		DP.goToCalanderStartDate().click();
		wait.until(ExpectedConditions.visibilityOf(DP.getPreviousMonth()));
		DP.getPreviousMonth().click();
		wait.until(ExpectedConditions.visibilityOf(DP.getAnotherDate()));
		DP.getAnotherDate().click();
	}
	
	@Then("User Clicks on Top Rating Menu")
	public void user_clicks_on_top_rating_menu() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Verify Employee Records Sorted With Highest Rating at Top and Lowest Rating at Bottom")
	public void verify_employee_records_sorted_with_highest_rating_at_top_and_lowest_rating_at_bottom() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

}
