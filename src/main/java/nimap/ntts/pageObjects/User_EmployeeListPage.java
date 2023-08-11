package nimap.ntts.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import nimap.ntts.pageComponents.PageComponents;

public class User_EmployeeListPage extends PageComponents {
	WebDriver driver;

	public User_EmployeeListPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[contains(text(),'Masters')]")
	private WebElement mastersBtn;
	public WebElement getMastersMenu() {
		return mastersBtn;
	}
	
	@FindBy(xpath = "//h1")
	private WebElement addEmpPageTitle;
	public WebElement getAddEmpPageTitle() {
		return addEmpPageTitle;
	}
	
	@FindBy(xpath = "//h3")
	private WebElement empListTitle;
	public WebElement getEmpListTitle() {
		return empListTitle;
	}
	
	@FindBy(xpath = "//h4")
	private WebElement empDetailsTitle;
	public WebElement getEmpDetailsTitle() {
		return empDetailsTitle;
	}
	
	@FindBy(xpath = "//span[contains(text(),'Email: ')]/following-sibling::span")
	private WebElement empDetailsEmail;
	public WebElement getEmpDetailsEmail() {
		return empDetailsEmail;
	}
	
	@FindBy(xpath = "//span[contains(text(),'Status: ')]/following-sibling::span")
	private WebElement empDetailsStatus;
	public WebElement getEmpDetailsStatus() {
		return empDetailsStatus;
	}
	
	@FindBy(css = "a[href='/apps/master/user']")
	private WebElement userMenu;
	public WebElement getUserMenu() {
		return userMenu;
	}
	
	@FindBy(xpath = "//div[@class='sc-fqkvVR sc-dcJsrY sc-iGgWBj ffYoNC bfnFLK brkkzl rdt_TableCell'] [1]")
	private List<WebElement> empNames;
	public List<WebElement> getEmpNames() {
		return empNames;
	}

	@FindBy(xpath = "//div[@class='sc-fqkvVR sc-dcJsrY sc-iGgWBj ffYoNC iumvLf brkkzl rdt_TableCell']")
	private List<WebElement> empEmails;
	public List<WebElement> getEmpEmails() {
		return empEmails;
	}
	
	@FindBy(xpath = "//button[contains(text(),'Add Employee')]")
	private WebElement addEmpBtn;
	public WebElement getAddEmpBtn() {
		return addEmpBtn;
	}
	
	@FindBy(xpath = "(//button[contains(text(),'Add Employee')]) [2]")
	private WebElement addNewEmpBtn;
	public WebElement getAddNewEmpBtn() {
		return addNewEmpBtn;
	}
	
	@FindBy(xpath = "//input[@value='Filter']")
	private WebElement filterBtn;
	public WebElement getFilterBtn() {
		return filterBtn;
	}
	
	@FindBy(css = "button[type='reset']")
	private WebElement filterClearBtn;
	public WebElement getFilterClearBtn() {
		return filterClearBtn;
	}
	
	
	@FindBy(css = "button[type='submit']")
	private WebElement filterSubmitBtn;
	public WebElement getFilterSubmitBtn() {
		return filterSubmitBtn;
	}
	
	@FindBy(xpath = "(//div[@class='select__input-container css-19bb58m']) [1]")
	private WebElement genderFilter;
	public WebElement getGenderFilter() {
		return genderFilter;
	}
	
	@FindBy(xpath = "(//div[@class='select__input-container css-19bb58m']) [2]")
	private WebElement statusFilter;
	public WebElement getStatusFilter() {
		return statusFilter;
	}
	
//	@FindBy(xpath = "//div[@role='status']")
//	private WebElement empAddedSuccessfullyMsg;
//	public WebElement getEmpAddedSuccessfullyMsg() {
//		return empAddedSuccessfullyMsg;
//	}
	
	@FindBy(xpath = "//div[contains(text(),'Roles already assigned to the user')]")
	private WebElement empEditedErrorMsg;
	public WebElement getEmpEditedErrorMsg() {
		return empEditedErrorMsg;
	}
	
	@FindBy(xpath = "//div[contains(text(),'User Updated successfully')]")
	private WebElement empEditedSuccessfullyMsg;
	public WebElement getEmpEditedSuccessfullyMsg() {
		return empEditedSuccessfullyMsg;
	}
	
	@FindBy(xpath = "//div[@role='status']")
	private WebElement empIdAlreadyExistMsg;
	public WebElement getEmpIdAlreadyExistMsg() {
		return empIdAlreadyExistMsg;
	}

	@FindBy(xpath = "//div[@class='d-flex align-items-center permissions-actions']/button[@type='button']")
	private List<WebElement> editEmpDetais;
	public List<WebElement> getEditEmpDetais() {
		return editEmpDetais;
	}

	@FindBy(xpath = "//h1")
	private WebElement editEmpPageTitle;
	public WebElement getEditEmpPageTitle() {
		return editEmpPageTitle;
	}

	@FindBy(xpath = "(//div[@class='select__input-container css-19bb58m']) [2]")
	private WebElement rolesDropDown;
	public WebElement getRolesDropDown() {
		return rolesDropDown;
	}

	@FindBy(xpath = "(//div[@class='select__input-container css-19bb58m']) [1]")
	private WebElement technologyDropDown;
	public WebElement getTechnologyDropDown() {
		return technologyDropDown;
	}
	
	@FindBy(css = "#name")
	private WebElement EmpName;
	public WebElement getEmpName() {
		return EmpName;
	}
	
	@FindBy(css = "#email")
	private WebElement EmpEmailId;
	public WebElement getEmpEmailId() {
		return EmpEmailId;
	}

	@FindBy(css = "#employeeNumber")
	private WebElement EmpNum;
	public WebElement getEmpNum() {
		return EmpNum;
	}

	@FindBy(xpath = "//div[@class='flatpickr-calendar animate open arrowLeft arrowBottom']//select[@aria-label='Month']")
	private WebElement monthPickerDropDown;
	public WebElement getMonthPickerDropDown() {
		return monthPickerDropDown;
	}

	@FindBy(xpath = "(//div[@class='numInputWrapper']) [1]")
	private WebElement calanderYear;
	public WebElement getCalanderYear() {
		return calanderYear;
	}

	@FindBy(xpath = "//span[@class='flatpickr-prev-month']")
	private WebElement calanderBackBtn;
	public WebElement getPreviousMonth() {
		return calanderYear;
	}

	@FindBy(xpath = "//span[@class='flatpickr-next-month']")
	private WebElement calanderForwardBtn;
	public WebElement getNextMonth() {
		return calanderForwardBtn;
	}

	@FindBy(xpath = "//input[@name='dateOfJoining']")
	private WebElement joiningDate;
	public WebElement getJoiningDate() {
		return joiningDate;
	}
	
	@FindBy(xpath = "(//span[contains(text(),'20')]) [1]")
	private WebElement selectFirstJoiningDate;
	public WebElement getFirstJoiningDate() {
		return selectFirstJoiningDate;
	}

	@FindBy(xpath = "//input[@name='benchDate']")
	private WebElement benchDate;
	public WebElement getBenchDate() {
		return benchDate;
	}

	
	@FindBy(css = "#phoneNumber")
	private WebElement empPhoneNo;
	public WebElement getEmpPhoneNo() {
		return empPhoneNo;
	}
	
	@FindBy(css = "#addressLine1")
	private WebElement empAddress;
	public WebElement getEmpAddress() {
		return empAddress;
	}
	
	@FindBy(xpath = "(//div[@class='select__input-container css-19bb58m'])[3]")
	private WebElement genderDropDown;
	public WebElement getGenderDropDown() {
		return genderDropDown;
	}
	
	@FindBy(xpath = "(//div[@class='select__input-container css-19bb58m'])[4]")
	private WebElement countryDropDown;
	public WebElement getCountryDropDown() {
		return countryDropDown;
	}
	
	@FindBy(xpath = "(//div[@class='select__input-container css-19bb58m'])[5]")
	private WebElement stateDropDown;
	public WebElement getStateDropDown() {
		return stateDropDown;
	}
	
	@FindBy(xpath = "(//div[@class='select__input-container css-19bb58m'])[6]")
	private WebElement cityDropDown;
	public WebElement getCityDropDown() {
		return cityDropDown;
	}
	
	@FindBy(xpath = "//span[@class='text-capitalize ']")
	private List<WebElement> empStatus;
	public List<WebElement> getEmpStatus() {
		return empStatus;
	}
	
	@FindBy(xpath = "//div[@class='sc-fqkvVR sc-dcJsrY sc-iGgWBj ffYoNC bfnFLK brkkzl rdt_TableCell'] [2]")
	private List<WebElement> empGender;
	public List<WebElement> getEmpGender() {
		return empGender;
	}
	
	@FindBy(xpath = "//div[@class='select__value-container select__value-container--is-multi select__value-container--has-value css-1dyz3mf']//div[@class='select__input-container css-19bb58m']")
	private WebElement editEmpDetailsRoles;
	public WebElement getEditEmpDetailsRoles() {
		return editEmpDetailsRoles;
	}
	
	@FindBy(css = "button[type='submit']")
	private WebElement editEmpDetailBtn;
	public WebElement getEditEmpDetailBtn() {
		return editEmpDetailBtn;
	}
	
	@FindBy(css = "#rows-per-page")
	private WebElement showListDropDown;
	public WebElement getShowListDropDown() {
		return showListDropDown;
	}
	
	@FindBy(xpath = "//div[contains(text(),'Active Employees')]")
	private WebElement activeEmpSlider;
	public WebElement getActiveEmpSlider() {
		return activeEmpSlider;
	}
	
	
	@FindBy(xpath = "//div[contains(text(),'Deleted Employees')]")
	private WebElement deletedEmpSlider;
	public WebElement getDeletedEmpSlider() {
		return deletedEmpSlider;
	}
	
	@FindBy(css = "#search-permission")
	private WebElement searchTextBox;
	public WebElement getSearchTextBox() {
		return searchTextBox;
	}
	
	@FindBy(xpath = "//button[@class='btn btn-icon actionHover btn btn-transparent btn-sm'] [2]")
	private List<WebElement> deleteEmpBtns;
	public List<WebElement> getDeleteEmpBtns() {
		return deleteEmpBtns;
	}
	
	@FindBy(xpath = "//button[@class='me-1 btn btn-primary']")
	private WebElement confirmDeleteBtn;
	public WebElement getConfirmDeleteBtn() {
		return confirmDeleteBtn;
	}
	
	@FindBy(xpath = "//div[@class='alert-body']")
	private WebElement deleteWarningMsg;
	public WebElement getDeleteWarningMsg() {
		return deleteWarningMsg;
	}
	
	@FindBy(xpath = "//div[contains(text(),'User Deleted successfully')]")
	private WebElement deletedSuccessfullyMsg;
	public WebElement getDeletedSuccessfullyMsg() {
		return deletedSuccessfullyMsg;
	}
	
	@FindBy(xpath = "//div[contains(text(),'User Added successfully')]")
	private WebElement empAddedSuccessfullyMsg;
	public WebElement getEmpAddedSuccMsg() {
		return empAddedSuccessfullyMsg;
	}
	
	
}
