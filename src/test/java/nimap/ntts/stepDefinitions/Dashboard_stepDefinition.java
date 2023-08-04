package nimap.ntts.stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import nimap.ntts.pageObjects.DashboardPage;
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
	DashboardPage DP;
	
	@When("User Clicks on Dashboard Menu")
	public void user_clicks_on_dashboard_menu() {
		LP = new LandingPage(driver);
		DP = new DashboardPage(driver);
		LP.goDashboard().click();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@When("User Select Highlited Date as a Start Date in Calander")
	public void user_select_highlited_date_as_a_start_date_in_calander() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(DP.goToCalanderStartDate()));
		Thread.sleep(300);
		DP.goToCalanderStartDate().click();
		wait.until(ExpectedConditions.elementToBeClickable(DP.getSelectHighlitedStartDate().get(0)));
		DP.getSelectHighlitedStartDate().get(0).click();;
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
		if(highestRatingInt==lowestRatingInt) {
			System.out.println("All Employess Rating are Equal");
		} else if(highestRatingInt>lowestRatingInt){
			System.out.println("All Employess Ratings are In Decending Order");
		}else {
			System.out.println("All Employess Ratings are In Ascending Order");
		}
		Assert.assertTrue(highestRatingInt>=lowestRatingInt);
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

}
