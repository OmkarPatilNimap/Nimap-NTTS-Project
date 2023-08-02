package nimap.ntts.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import nimap.ntts.pageComponents.PageComponents;

public class LandingPage extends PageComponents {
	WebDriver driver;

	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[contains(text(),'successfully')]")
	private WebElement loginSuccessMsg;
	public WebElement getloginSuccText() {
		return loginSuccessMsg;
	}

	@FindBy(xpath = "//span[contains(text(),'Masters')]")
	private WebElement mastersMenu;
	public WebElement goToMastersMenu() {
		return mastersMenu;
	}

	@FindBy(css = ".d-flex.align-items-center.active")
	private WebElement userSubMenu;
	public WebElement goToUserSubMenu() {
		return userSubMenu;
	}
	
	@FindBy (css = "")
	private WebElement logOutBtn;
	
	@FindBy(xpath = "//span[contains(text(),'Dashboard')]")
	private WebElement dashboard;
	public WebElement goDashboard() {
		return dashboard;
	}
	
	@FindBy(css = "#startDate")
	private WebElement startDate;
	public WebElement goToCalanderStartDate() {
		return startDate;
	}
	
	@FindBy(css = ".flatpickr-day.selected")
	private WebElement selectCurrentStartDate;
	public WebElement getSelectCurrentStartDate() {
		return selectCurrentStartDate;
	}

	@FindBy(css = "#endDate")
	private WebElement endDate;
	public WebElement goToCalanderEndDate() {
		return endDate;
	}
	
	@FindBy(xpath = "//span[@class='flatpickr-day today selected']")
	private WebElement selectNextEndDate;
	public WebElement getSelectNextEndDate() {
		return selectNextEndDate;
	}
	
	
	

}
