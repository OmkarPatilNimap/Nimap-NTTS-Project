package nimap.ntts.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import nimap.ntts.pageComponents.PageComponents;

public class UserEmployeeListPage extends PageComponents {
	WebDriver driver;

	public UserEmployeeListPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (css = ".dropdown-user-link")
	private WebElement avatarImg;
	public WebElement getUesrProfileImg() {
		return avatarImg;	
	}
	
	@FindBy(className = "dropdown-item")
	private WebElement logOutBtn;
	public WebElement getLogOutBtn() {
		return logOutBtn;
	}
	
	@FindBy (css = ".rdt_TableRow")
	private List<WebElement> employeeListRows;
	
	@FindBy (css = ".rdt_TableRow")
	private List<WebElement> reviewListRows;
	
	@FindBy (xpath = "//h1[contains(text(),'View')]")
	private WebElement viewReviewTitle;
	
	@FindBy (css = ".add-permission")
	private WebElement addReviewBtn;
	
	@FindBy (xpath = "h4[class='fw-bolder ms-1 me-2 mt-1'] a")
	private WebElement backToEmpListbtn;
	
	@FindBy (css = "#search-permission")
	private WebElement searchTextBox;
	
	@FindBy (xpath = "//h3[@class='text-height ']")
	private WebElement selectedEmpReview;
	
	

	public WebElement selectEmployeeFromEmployeeList() {
		WebElement firstEmp = employeeListRows.get(0);
		return firstEmp;
	}
	
	public WebElement selectedEmpReviewText() {
		return selectedEmpReview;
	}
	
	
}
