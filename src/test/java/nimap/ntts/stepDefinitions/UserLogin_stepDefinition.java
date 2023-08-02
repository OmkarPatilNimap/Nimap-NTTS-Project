package nimap.ntts.stepDefinitions;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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

	@Given("User select the browser")
	public void user_select_the_browser() throws IOException {
		driver = initializeDriver();
	}

	@When("User is on NTTS login Portal")
	public void user_is_on_ntts_login_portal() {
		driver.get(goToNttsPage());
		CL = new LoginPage(driver);
		String url = driver.getCurrentUrl();
		try {
			Assert.assertEquals(url, prop.getProperty("url") + "login");
		} catch (Exception e) {
			e.printStackTrace();
		}
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
		LP = new LandingPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOf(LP.getloginSuccText()));
		UE = new UserEmployeeListPage(driver);
		UE.getUesrProfileImg().click();
		UE.getLogOutBtn().click();
		driver.close();
	}

	@Given("User Currently is on Login Page")
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
	public void verify_the_outcome_fail() {
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
		// TODO Auto-generated method stub
		driver.close();
	}

	@When("User clicks on forgot password link")
	public void user_clicks_on_forgot_password_link() {
		LoginPage CL = new LoginPage(driver);
		CL.getForgotPassLink().click();
	}

	@And("Enter Email")
	public void enter_email_and_click_on_send_otp() {
		LoginPage CL = new LoginPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(CL.goToEnterEmail()));
		CL.goToEnterEmail().sendKeys(prop.getProperty("email"));
	}

	@And("Click on send OTP Btn")
	public void click_on_send_otp_btn() {
		LoginPage CL = new LoginPage(driver);
		CL.getSendOtpBtn().click();
		CL.getOtpSendSuccMsg().getText();
		System.out.println(CL.getOtpSendSuccMsg().getText());
	}

	@And("Verify The OTP Popup")
	public void verify_the_otp_popup() throws InterruptedException {
		LoginPage CL = new LoginPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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
		LoginPage CL = new LoginPage(driver);
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
		LoginPage CL = new LoginPage(driver);
		Thread.sleep(200);
		Assert.assertEquals(CL.getInvalidOtpMsg().getText(), prop.getProperty("otpInvalidMsg"));
//		else if(CL.getPassResetSuccMsg().isDisplayed()) {
//			Assert.assertEquals(CL.getPassResetSuccMsg().getText(), prop.getProperty("passResetSuccMsg"));
//		}
	}

	@And("User clicks on Sign In With OTP Link")
	public void user_clicks_on_sign_in_with_otp_link() {
		LoginPage CL = new LoginPage(driver);
		CL.getSignInWithOtpLnk().click();
	}

	@And("User Enter InValid OTP")
	public void user_enter_in_valid_otp() throws InterruptedException {
		LoginPage CL = new LoginPage(driver);
		for (int i = 1; i <= 6; i++) {
			CL.getOtpBlocks().get(i - 1).sendKeys(prop.getProperty("otpBlock" + i));
			Thread.sleep(200);
		}
		CL.getSignInBtn1().click();
	}

}
