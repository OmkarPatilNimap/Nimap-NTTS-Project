package nimap.ntts.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import nimap.ntts.pageComponents.PageComponents;

public class DashboardPage extends PageComponents{
	WebDriver driver;
	public DashboardPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "#startDate")
	private WebElement startDate;
	public WebElement goToCalanderStartDate() {
		return startDate;
	}
	
	@FindBy(css = ".flatpickr-day.selected")
	private WebElement selectHighlitedStartDate;
	public WebElement getSelectHighlitedStartDate() {
		return selectHighlitedStartDate;
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
	
	@FindBy(css = ".nav-link.active")
	private WebElement topRating;
	public WebElement getTopRating() {
		return topRating;
	}
	
	@FindBy(xpath = "//span[@class='flatpickr-prev-month']")
	private WebElement calanderBackBtn;
	public WebElement getPreviousMonth() {
		return calanderBackBtn;
	}
	
	@FindBy(xpath = "//span[@class='flatpickr-next-month']")
	private WebElement calanderForwardBtn;
	public WebElement getNextMonth() {
		return calanderForwardBtn;
	}
	
	@FindBy(xpath = "//span[contains(text(),'18')]")
	private WebElement selectAnotherDate;
	public WebElement getAnotherDate() {
		return selectAnotherDate;
	}
	
	@FindBy(xpath = "//span[@class='flatpickr-day flatpickr-disabled'][contains(text(),'1')][1]")
	private WebElement selectDateBeforeStartDate;
	public WebElement getSelectDateBeforeStartDate() {
		return selectDateBeforeStartDate;
	}
	//span[@class='flatpickr-day flatpickr-disabled'][contains(text(),'1')][1]
	
	//---------------------------------------------------------------------
	
	@FindBy(css = ".sc-dhKdcB.hxYGQY.rdt_TableRow")
	private List<WebElement> topRatingRows;
	public List<WebElement> getTopRatingRows() {
		return topRatingRows;
	}
	//div[@class='sc-feUZmu eguvnT react-dataTable']//div[@id='row-0']
	
	@FindBy(xpath = "//div[@class='sc-fqkvVR sc-dcJsrY sc-iGgWBj ffYoNC fGWgCb brkkzl rdt_TableCell']")
	private WebElement topRatingEmpNames;
	public WebElement getTopRatingEmpNames() {
		return topRatingEmpNames;
	}
	
	@FindBy(xpath = "//div[@class='sc-fqkvVR sc-dcJsrY sc-iGgWBj ffYoNC cLKIlv brkkzl rdt_TableCell']")
	private WebElement topRatingMentorNames;
	public WebElement getTopRatingMentorNames() {
		return topRatingMentorNames;
	}
	
	@FindBy(xpath = "//div[@class='sc-fqkvVR sc-dcJsrY sc-iGgWBj ffYoNC jDFsip brkkzl rdt_TableCell']")
	private WebElement topRatingTechnology;
	public WebElement getTopRatingTechnology() {
		return topRatingTechnology;
	}
	
}
