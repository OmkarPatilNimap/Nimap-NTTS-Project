package nimap.ntts.stepDefinitions;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

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
import nimap.ntts.testComponents.TestContextSetup;

public class UserLoginStepDefinition extends BaseTest {
	LoginPage CL;
	LandingPage LP;
	UserEmployeeListPage UE;
	DashboardPage DP;
	WebDriverWait wait;
	TestContextSetup tcs;
	JavascriptExecutor js;
	User_EmployeeListPage EL;
	String firstEmpName;
	String firstEmpEmail;
	String firstEmpStatus;
	Actions a;
	int rows;

	private final TestContextSetup testContextSetup;

    public UserLoginStepDefinition(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }

//	@Given("User Initialize The Browser")
//	public void user_initialize_the_browser() {
//	}

	@Given("User select the browser")
	public void user_select_the_browser() throws IOException {
		testContextSetup.driver = initializeDriver();
		CL = new LoginPage(testContextSetup.driver);
		LP = new LandingPage(testContextSetup.driver);
		UE = new UserEmployeeListPage(testContextSetup.driver);
		DP = new DashboardPage(testContextSetup.driver);
		wait = new WebDriverWait(testContextSetup.driver, Duration.ofSeconds(10));
		a = new Actions(testContextSetup.driver);
	}

	@And("User enter a credential {string} {string}")
	public void user_enter_a_credential(String Username, String Password) {
		CL = new LoginPage(testContextSetup.driver);
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
		testContextSetup.driver.get(goToNttsPage());
		String url = testContextSetup.driver.getCurrentUrl();
		try {
			Assert.assertEquals(url, prop.getProperty("url") + "login");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("User is on Login Protal");
	}

	@When("^User enter valid and invalid credential (.*) (.*)$")
	public void user_enter_valid_and_invalid_credential(String Username, String Password) throws InterruptedException {
		CL = new LoginPage(testContextSetup.driver);
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
			System.out.println("Empty EmailId Failed Error MEssage");
			Thread.sleep(200);
		} else {
			CL.emptyPwdErrMsg().isDisplayed();
			CL.emptyPwdErrMsg().getText().equalsIgnoreCase(prop.getProperty("emptyPassField"));
			System.out.println("Empty Password Failed Error Msg");
			System.out.println(CL.emptyPwdErrMsg().getText());
			Thread.sleep(300);
		}
	}

	@Then("Close The Browser")
	public void close_the_browser() {
		testContextSetup.driver.close();
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

	@And("Verify The OTP Popup After User Enter Invalid mail")
	public void verify_the_otp_popup_after_user_enter_invalid_mail() throws InterruptedException {
		Thread.sleep(300);
		CL.getInvalidEmailMsg().getText().equalsIgnoreCase(prop.getProperty("invalidEmailMsg"));
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
		Thread.sleep(800);
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

	// ================================DashBoard================================

	@When("User Clicks on Dashboard Menu")
	public void user_clicks_on_dashboard_menu() {
		LP = new LandingPage(testContextSetup.driver);
		DP = new DashboardPage(testContextSetup.driver);
		LP.goDashboard().click();
		wait = new WebDriverWait(testContextSetup.driver, Duration.ofSeconds(10));
	}

	@When("User Select Highlited Date as a Start Date in Calander")
	public void user_select_highlited_date_as_a_start_date_in_calander() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(DP.goToCalanderStartDate()));
		Thread.sleep(300);
		DP.goToCalanderStartDate().click();
		wait.until(ExpectedConditions.elementToBeClickable(DP.getSelectHighlitedStartDate().get(0)));
		DP.getSelectHighlitedStartDate().get(0).click();
		;
	}

	@When("User Select Today as an End Date in Calander")
	public void user_select_today_date_as_an_end_date_in_calander() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(DP.goToCalanderEndDate()));
		DP.goToCalanderEndDate().click();
		wait.until(ExpectedConditions.elementToBeClickable(DP.getSelectNextEndDate()));
		DP.getSelectNextEndDate().click();
	}

	@When("User is on Home Page {string} {string}")
	public void user_is_on_home_page(String Username, String Password) {
		testContextSetup.driver.get(goToNttsPage());
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
		DP.getTopRating().click();
	}

	@Then("Verify Employee Records Sorted With Highest Rating at Top and Lowest Rating at Bottom")
	public void verify_employee_records_sorted_with_highest_rating_at_top_and_lowest_rating_at_bottom() {
		wait.until(ExpectedConditions.visibilityOfAllElements(DP.getTopRatingCol()));
		int rows = DP.getTopRatingCol().size();
		String highestRating = DP.getTopRatingCol().get(0).getText();
		highestRating = highestRating.substring(1, highestRating.length() - 1);
		int highestRatingInt = Integer.parseInt(highestRating);
		String lowestRating = DP.getTopRatingCol().get(rows - 1).getText();
		lowestRating = lowestRating.substring(1, lowestRating.length() - 1);
		int lowestRatingInt = Integer.parseInt(highestRating);
		if (highestRatingInt == lowestRatingInt) {
			System.out.println("All Employess Rating are Equal");
		} else if (highestRatingInt > lowestRatingInt) {
			System.out.println("All Employess Ratings are In Decending Order");
		} else {
			System.out.println("All Employess Ratings are In Ascending Order");
		}
		Assert.assertTrue(highestRatingInt >= lowestRatingInt);
//		String LastEmpName = DP.getTopRatingEmpNames().get(rows - 1).getText();
//		String LastMentorName = DP.getTopRatingMentorNames().get(rows-1).getText();
//		String LastTechName = DP.getTopRatingTechnology().get(rows-1).getText();		
	}

	@Then("User clicks on First Employee Name")
	public void user_clicks_on_first_employee_name() {
		String FirstEmpName = DP.getTopRatingEmpNames().get(0).getText();
		String FirstMentorName = DP.getTopRatingMentorNames().get(0).getText();
		String FirstTechName = DP.getTopRatingTechnology().get(0).getText();
		DP.getTopRatingRows().get(0).click();
	}

	@Then("User Redirect to Selected Employee Details Page")
	public void user_redirect_to_selected_employee_details_page() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

//=====================================EmployeeList========================

	@When("User Clicks on Masters Menu and Select Employee Sub Menu")
	public void user_clicks_on_masters_menu_and_select_employee_sub_menu() {
		EL = new User_EmployeeListPage(testContextSetup.driver);
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

	@Then("User Clicks on Active Employee Slider")
	public void user_clicks_on_active_employee_slider() {
		EL.getActiveEmpSlider().click();
	}

	@Then("User Scroll Down and Clicks on Show First {int} Entries")
	public void user_scroll_down_and_clicks_on_show_first_entries(Integer int1) throws InterruptedException {
		Thread.sleep(3000);
		js = (JavascriptExecutor) testContextSetup.driver;
		js.executeScript("window.scrollBy(0,250)");
		rows = EL.getEmpNames().size();
		System.out.println("No of Rows Before Pagenation in Employee List : " + rows);
		Select options = new Select(EL.getShowListDropDown());
		options.selectByValue("25");
		rows = EL.getEmpNames().size();
		System.out.println("No of Rows After Pagenation in Employee List : " + rows);
	}

	@Then("User Scroll Up and Verify The {int} Rows Are Loaded in Employee List")
	public void user_scroll_up_and_verify_the_rows_are_loaded_in_employee_list(Integer int1) {
		js.executeScript("window.scrollBy(250,0)");
		if (rows <= 25) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

	@Then("User Type Existing Employee Name and Click on Search button")
	public void user_type_existing_employee_name_and_click_on_search_button() {
		EL.getSearchTextBox().sendKeys(prop.getProperty("existingEmpName"));
	}

	@Then("Only one Search Entry is Available Verify the Actual Searched Name With Available Employee Search Name")
	public void only_one_search_entry_is_available_verify_the_actual_searched_name_with_available_employee_search_name() {
		wait.until(ExpectedConditions.visibilityOf(EL.getEmpNames().get(0)));
		String actualSearchedName = prop.getProperty("existingEmpName");
		String availableName = EL.getEmpNames().get(0).getText();
		System.out.println("Name Searched In Search Box : " + actualSearchedName);
		System.out.println("Name After Searched : " + availableName);
		Assert.assertEquals(availableName, actualSearchedName);
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

	@Then("User Clicks on Add New Employee button")
	public void user_clicks_on_add_new_employee_button() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(EL.getAddNewEmpBtn()));
		EL.getAddNewEmpBtn().click();
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOf(EL.getEmpAddedSuccMsg()));
		String actualSuccMsg = EL.getEmpAddedSuccMsg().getText();
		String expectedSuccMsg = prop1.getProperty("userAddedSuccMsg");
		Assert.assertEquals(actualSuccMsg, expectedSuccMsg);
		// System.out.println(EL.getEmpAddedSuccessfullyMsg());
	}

	@Then("User Redirect To Add Employee Page")
	public void user_redirect_to_add_employee_page() {
		EL.getAddEmpPageTitle().getText().equalsIgnoreCase(prop.getProperty("addEmpPageTitle"));
	}

	@Then("User Enter Valid Employee Details")
	public void user_enter_valid_employee_details() throws InterruptedException {
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(EL.getEmpName()));
		EL.getEmpName().sendKeys(prop1.getProperty("empName"));
		a = new Actions(driver);
		wait.until(ExpectedConditions.elementToBeClickable(EL.getTechnologyDropDown()));
		a.click(EL.getTechnologyDropDown()).sendKeys(prop1.getProperty("TechName")).keyDown(Keys.ENTER).build()
				.perform();
		wait.until(ExpectedConditions.elementToBeClickable(EL.getRolesDropDown()));
		a.click(EL.getRolesDropDown()).sendKeys(prop1.getProperty("roles")).keyDown(Keys.ENTER).build().perform();
		a.click(EL.getGenderDropDown()).sendKeys(prop1.getProperty("gender")).keyDown(Keys.ARROW_DOWN)
				.keyDown(Keys.ENTER).build().perform();
		EL.getEmpEmailId().sendKeys(prop1.getProperty("email"));
		EL.getEmpNum().sendKeys(prop1.getProperty("empNum"));

//		EL.getJoiningDate().click();
//		wait.until(ExpectedConditions.elementToBeClickable(EL.getMonthPickerDropDown()));
//		EL.getMonthPickerDropDown().click();
//		Select options = new Select(EL.getMonthPickerDropDown());
//		options.selectByVisibleText("July");
//		EL.getCalanderYear().sendKeys("2023");
//		EL.getFirstJoiningDate().click();

		EL.getEmpPhoneNo().sendKeys(prop1.getProperty("empPhoneNum"));
		EL.getEmpAddress().sendKeys(prop1.getProperty("empAddress"));
		a.click(EL.getCountryDropDown()).sendKeys(prop1.getProperty("countryName")).keyDown(Keys.ARROW_DOWN)
				.keyDown(Keys.ENTER).build().perform();
		a.click(EL.getStateDropDown()).sendKeys(prop1.getProperty("state")).keyDown(Keys.ENTER).build().perform();
		a.click(EL.getCityDropDown()).sendKeys(prop1.getProperty("city")).keyDown(Keys.ENTER).build().perform();
	}

	@Then("User Clicks on Filter button")
	public void user_clicks_on_filter_button() throws InterruptedException {
		wait.until(ExpectedConditions.invisibilityOf(LP.getloginSuccText()));
		EL.getFilterBtn().click();
	}

	@Then("User Select Filter By Gender and Filter By Status")
	public void user_select_filter_by_gender_and_filter_by_status() throws InterruptedException {
		a = new Actions(driver);
		a.click(EL.getGenderFilter()).sendKeys(prop1.getProperty("gender")).keyDown(Keys.ARROW_DOWN).keyDown(Keys.ENTER)
				.build().perform();
		a.click(EL.getStatusFilter()).sendKeys(prop1.getProperty("status")).keyDown(Keys.ARROW_DOWN)
				.keyDown(Keys.ARROW_DOWN).keyDown(Keys.ENTER).build().perform();
	}

	@Then("User Clicks on Submit Filter button")
	public void user_clicks_on_submit_filter_button() throws InterruptedException {
		EL.getFilterSubmitBtn().click();
	}

	@Then("User Verify the Filter Condition is Apply as per inputs Provided")
	public void user_verify_the_filter_condition_is_apply_as_per_inputs_provided() throws InterruptedException {
		firstEmpName = EL.getEmpNames().get(0).getText();
		for (int i = 0; i < EL.getEmpStatus().size(); i++) {
			String EmpGender = EL.getEmpGender().get(i).getText();
			System.out.println(EmpGender);
			String EmpStatus = EL.getEmpStatus().get(i).getText();
			System.out.println(EmpStatus);
			Assert.assertTrue(EmpGender.equalsIgnoreCase(prop1.getProperty("gender")));
			Assert.assertTrue(EmpStatus.equalsIgnoreCase(prop1.getProperty("actualStatus")));
			// Bug Present Under Training Spelling Mistakes in filter
		}
	}

	@Then("User Search Newly Added Employee")
	public void user_search_newly_added_employee() {
		EL.getSearchTextBox().sendKeys(prop1.getProperty("empName"));
	}

	@Then("User Search Newly Edited Employee Name")
	public void user_search_newly_edited_employee_name() {
		EL.getSearchTextBox().sendKeys(prop1.getProperty("editedEmpName"));
	}

	@Then("User Clicks on Edit Employee Details button")
	public void user_clicks_on_edit_employee_details_button() {
		wait.until(ExpectedConditions.visibilityOf(EL.getEmpNames().get(0)));
		String newlyAddedEmpName = EL.getEmpNames().get(0).getText();
		System.out.println(newlyAddedEmpName);
		Assert.assertEquals(newlyAddedEmpName, prop1.getProperty("empName"));
		EL.getEditEmpDetais().get(0).click();
	}

	@Then("User Edits Few Fields")
	public void user_edits_few_fields() {
		System.out.println(EL.getEditEmpPageTitle().getText());
		// Assert.assertTrue(EL.getEditEmpPageTitle().getText().equalsIgnoreCase("Edit
		// Employee"));
		a.click(EL.getEditEmpDetailsRoles()).sendKeys(prop1.getProperty("editedRoles")).keyDown(Keys.ENTER).build()
				.perform();
		EL.getEmpName().clear();
		EL.getEmpName().sendKeys(prop1.getProperty("editedEmpName"));
		EL.getEmpNum().clear();
		EL.getEmpNum().sendKeys(prop1.getProperty("editedEmpNum"));
		EL.getEmpPhoneNo().clear();
		EL.getEmpPhoneNo().sendKeys(prop1.getProperty("editedEmpPhoneNum"));
		EL.getEmpAddress().clear();
		EL.getEmpAddress().sendKeys(prop1.getProperty("editedEmpAddress"));
	}

	@Then("User Clicks on Edit Employee button and save the Details")
	public void user_clicks_on_edit_employee_button_and_save_the_details() {
		EL.getEditEmpDetailBtn().click();
	}

	@Then("User Verify Employee Details Edited Successfully")
	public void user_verify_employee_details_edited_successfully() throws InterruptedException {
		Thread.sleep(300);
		if (EL.getEmpEditedSuccessfullyMsg().isDisplayed()) {
			System.out.println(EL.getEmpEditedSuccessfullyMsg().getText());
			Assert.assertEquals(EL.getEmpEditedSuccessfullyMsg().getText(), prop1.getProperty("empEditSuccessMsg"));
		} else {
			System.out.println(EL.getEmpEditedErrorMsg().getText());
			Assert.assertEquals(EL.getEmpEditedErrorMsg().getText(), prop1.getProperty("empEditErrorMsg"));
		}
	}

	@Then("User Clicks on Delete Employee button")
	public void user_clicks_on_delete_employee_button() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(EL.getDeleteEmpBtns().get(0)));
		EL.getDeleteEmpBtns().get(0).click();
		Thread.sleep(500);
		String actualWarningMsg = EL.getDeleteWarningMsg().getText();
		String expectedWarningMsg = prop1.getProperty("deleteEmpWarningMsg");
		Assert.assertEquals(actualWarningMsg, expectedWarningMsg);
		EL.getConfirmDeleteBtn().click();
	}

	@Then("User Search Newly Added Employee and Verify Employee Deleted Successfully")
	public void user_search_newly_added_employee_and_verify_employee_deleted_successfully() {
		wait.until(ExpectedConditions.visibilityOf(EL.getDeletedSuccessfullyMsg()));
		String empDeletedSuccMsg = EL.getDeletedSuccessfullyMsg().getText();
		String expectedEmpDeletedSuccMsg = prop1.getProperty("empDeletedSuccMsg");
		Assert.assertEquals(empDeletedSuccMsg, expectedEmpDeletedSuccMsg);
		System.out.println(empDeletedSuccMsg);
	}

	@Then("User Clicks on Deleted Employee Slider")
	public void user_clicks_on_deleted_employee_slider() {
		EL.getDeletedEmpSlider().click();
	}

	@Then("User Type Recently Deleted Employee Name and Click on Search button")
	public void user_type_recently_deleted_employee_name_and_click_on_search_button() {
		EL.getSearchTextBox().sendKeys(prop1.getProperty("editedEmpName"));
	}

	@Then("Verify Search Entry is Available in Deleted Employee Page Verify the Actual Searched Name With Available Employee Search Name")
	public void verify_search_entry_is_available_in_deleted_employee_page_verify_the_actual_searched_name_with_available_employee_search_name() {
		wait.until(ExpectedConditions.visibilityOf(EL.getEmpNames().get(0)));
		String actualSearchedName = prop1.getProperty("editedEmpName");
		String availableName = EL.getEmpNames().get(0).getText();
		System.out.println("Name Searched In Search Box : " + actualSearchedName);
		System.out.println("Name After Searched : " + availableName);
		Assert.assertEquals(availableName, actualSearchedName);
	}

}
