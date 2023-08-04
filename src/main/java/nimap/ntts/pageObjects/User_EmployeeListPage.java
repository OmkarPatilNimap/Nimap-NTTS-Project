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
	
	@FindBy(xpath = "a[class='d-flex align-items-center active'] span[class='menu-item text-truncate']")
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

	@FindBy(css = "//div[@class='select__value-container select__value-container--is-multi select__value-container--has-value css-1dyz3mf']")
	private WebElement rolesDropDown;
	public WebElement getRolesDropDown() {
		return rolesDropDown;
	}

	@FindBy(css = "#name")
	private WebElement EmpName;
	public WebElement getEmpName() {
		return EmpName;
	}

	@FindBy(css = "#employeeNumber")
	private WebElement EmpNum;
	public WebElement getEmpNum() {
		return EmpNum;
	}

	@FindBy(css = "div[class='flatpickr-calendar animate arrowTop arrowLeft open'] select[aria-label='Month']")
	private WebElement monthPickerDropDown;
	public WebElement getMonthPickerDropDown() {
		return monthPickerDropDown;
	}

	@FindBy(xpath = "//div[@class='numInputWrapper']")
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

	@FindBy(xpath = "//span[contains(text(),'24')]")
	private WebElement joiningDate;
	public WebElement getJoiningDate() {
		return joiningDate;
	}

	@FindBy(xpath = "//span[contains(text(),'18')]")
	private WebElement benchDate;
	public WebElement getBenchDate() {
		return benchDate;
	}

	@FindBy(css = "#phoneNumber")
	private WebElement phoneNo;
	public WebElement getPhoneNo() {
		return phoneNo;
	}
	
	@FindBy(css = "#addressLine1")
	private WebElement empAddress;
	public WebElement getEmpAddress() {
		return empAddress;
	}
	
	@FindBy(css = "div[class='select__single-value css-1dimb5e-singleValue']")
	private List<WebElement> genderDropDown;
	public List<WebElement> getGenderDropDown() {
		return genderDropDown;
	}
	
	@FindBy(css = "div[class='select__single-value css-1dimb5e-singleValue']")
	private List<WebElement> countryDropDown;
	public List<WebElement> getCountryDropDown() {
		return countryDropDown;
	}
	
	@FindBy(css = "#react-select-54-placeholder")
	private WebElement stateDropDown;
	public WebElement getStateDropDown() {
		return stateDropDown;
	}
	
	@FindBy(xpath = "//span[@class='text-capitalize ']")
	private List<WebElement> empStatus;
	public List<WebElement> getEmpStatus() {
		return empStatus;
	}
	
	
	
}
