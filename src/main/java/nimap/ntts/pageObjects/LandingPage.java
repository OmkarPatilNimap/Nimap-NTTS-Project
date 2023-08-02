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
	

	

}
