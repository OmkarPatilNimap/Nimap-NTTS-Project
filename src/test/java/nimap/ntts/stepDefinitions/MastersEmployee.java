package nimap.ntts.stepDefinitions;

import org.junit.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import nimap.ntts.pageObjects.User_EmployeeListPage;
import nimap.ntts.testComponents.BaseTest;

public class MastersEmployee extends BaseTest {
	User_EmployeeListPage EL;
	String firstEmpName;
	String firstEmpEmail;
	String firstEmpStatus;

	// Change User to Employee
	@When("User Clicks on Masters Menu and Select Employee Sub Menu")
	public void user_clicks_on_masters_menu_and_select_employee_sub_menu() {
		EL = new User_EmployeeListPage(driver);
		EL.getMastersMenu().click();
		EL.getUserMenu().click();
	}

	@Then("Open Employee List Page")
	public void open_employee_list_page() {
		String actualTitle = EL.getEmpListTitle().getText();
		Assert.assertEquals(actualTitle, "Employees List");
	}

	@Then("User Clicks on First Employee From the List")
	public void user_clicks_on_first_employee_from_the_list() {
		firstEmpName = EL.getEmpNames().get(0).getText();
		firstEmpEmail = EL.getEmpEmails().get(0).getText();
		firstEmpStatus = EL.getEmpStatus().get(0).getText();
		EL.getEmpNames().get(0).click();
	}

	@Then("User Redirect To Selected Employee Detais Page")
	public void user_redirect_to_selected_employee_detais_page() {
		String empName = EL.getEmpDetailsTitle().getText();
		Assert.assertEquals(empName, firstEmpName);
	}

	@Then("Verify The Employee Detais Are The Same As Selected Employee")
	public void verify_the_employee_detais_are_the_same_as_selected_employee() {
		String actualEmpName = EL.getEmpDetailsTitle().getText();
		String ActualEmpEmail = EL.getEmpDetailsEmail().getText();
		String ActualEmpStatus = EL.getEmpDetailsStatus().getText();
		Assert.assertEquals(actualEmpName, firstEmpName);
		Assert.assertEquals(ActualEmpEmail, firstEmpEmail);
		Assert.assertEquals(ActualEmpStatus, firstEmpStatus);
	}

}
