package nimap.ntts.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import nimap.ntts.pageComponents.PageComponents;

public class TopicPage extends PageComponents{

	WebDriver driver;

	public TopicPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "a[href='/apps/master/topic']")
	private WebElement topicMenu;
	public WebElement getTopicMenu() {
		return topicMenu;
	}
	
	@FindBy(css = "#search-permission")
	private WebElement searchTextBox;
	public WebElement getSearchTextBox() {
		return searchTextBox;
	}
	
	@FindBy(css = "#cell-2-undefined")
	private List<WebElement> technologyNames;
	public List<WebElement> getTechnologyNames() {
		return technologyNames;
	}
	
	@FindBy(xpath = "//a[@aria-label='Previous page']")
	private WebElement prevPage;
	public WebElement getPrevPage() {
		return prevPage;
	}
	
	@FindBy(xpath = "//a[@aria-label='Next page']")
	private WebElement nextPage;
	public WebElement getNextPage() {
		return nextPage;
	}
	
	@FindBy(css = "#rows-per-page")
	private WebElement showListDropDown;
	public WebElement getShowListDropDown() {
		return showListDropDown;
	}
	
	@FindBy(xpath = "//div[@class='d-flex align-items-center permissions-actions']/button[@type='button'][1]")
	private List<WebElement> editTopicDetais;
	public List<WebElement> getEditTopicDetais() {
		return editTopicDetais;
	}
	
	@FindBy(xpath = "//button[@class='btn btn-icon actionHover btn btn-transparent btn-sm'] [2]")
	private List<WebElement> deleteEmpBtns;
	public List<WebElement> getDeleteEmpBtns() {
		return deleteEmpBtns;
	}
	
	@FindBy(xpath = "//button[contains(text(),'Import')]")
	private WebElement importBtn;
	public WebElement getImportBtn() {
		return importBtn;
	}
	
	@FindBy(xpath = "//button[contains(text(),'Export')]")
	private WebElement exportBtn;
	public WebElement getExportBtn() {
		return exportBtn;
	}
	
	@FindBy(xpath = "//input[@value='Filter']")
	private WebElement filterBtn;
	public WebElement getFilterBtn() {
		return filterBtn;
	}
	
	@FindBy(xpath = "//button[contains(text(),'Add Topic')]")
	private WebElement addTopicBtn;
	public WebElement getAddTopicBtn() {
		return addTopicBtn;
	}
	
	@FindBy(xpath = "//span[@class='btn-icon actionHover']")
	private List<WebElement> eyeBtns;
	public List<WebElement> getEyeBtns() {
		return eyeBtns;
	}
	
	@FindBy(xpath = "//button[contains(text(),'Discard')]")
	private WebElement discardBtn;
	public WebElement getDiscardBtn() {
		return discardBtn;
	}
	
	@FindBy(xpath = "//input[@id='file']")
	private WebElement uploadFile;
	public WebElement getUploadFile() {
		return uploadFile;
	}
	
	@FindBy(css = "button[type='submit']")
	private WebElement submitBtn;
	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	
	@FindBy(xpath = "//div[@class='invalid-feedback']")
	private WebElement invalidFeedbackMsg;
	public WebElement getInvalidFeedbackMsg() {
		return invalidFeedbackMsg;
	}
	
	@FindBy(css = "a[href='/csv/TopicBulkUpload.xlsx']")
	private WebElement uploadSampleFile;
	public WebElement getUploadSampleFile() {
		return uploadSampleFile;
	}
	
	@FindBy(xpath = "//h1")
	private WebElement addNewTopicPageTitle;
	public WebElement getAddNewTopicPageTitle() {
		return addNewTopicPageTitle;
	}
	
	@FindBy(css = "#topicname")
	private WebElement topicName;
	public WebElement getTopicName() {
		return topicName;
	}
	
	@FindBy(xpath = "//input[@name='priority']")
	private WebElement priority;
	public WebElement getPriority() {
		return priority;
	}
	
	@FindBy(xpath = "//input[@name='file']")
	private WebElement newTopicUploadFile;
	public WebElement getNewTopicUploadFile() {
		return newTopicUploadFile;
	}
	
	@FindBy(css = "textarea[name='description']")
	private WebElement description;
	public WebElement getDescription() {
		return description;
	}
	
	@FindBy(css = "input[name='topicUrl']")
	private WebElement enterUrl;
	public WebElement getEnterUrl() {
		return enterUrl;
	}
	
	@FindBy(css = "button[class='btn btn-secondary']")
	private WebElement addUrlBtn;
	public WebElement getAddUrlBtn() {
		return addUrlBtn;
	}
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement addNewTopicBtn;
	public WebElement getAddNewTopicBtn() {
		return addNewTopicBtn;
	}
	
	@FindBy(xpath = "//div[@class='select__input-container css-19bb58m']")
	private WebElement techName;
	public WebElement getTechName() {
		return techName;
	}
	
	@FindBy(xpath = "//h3")
	private WebElement topicListTitle;
	public WebElement getTopicListTitle() {
		return topicListTitle;
	}
	
	@FindBy(xpath = "//div[contains(text(),'Topic added successfully')]")
	private WebElement topicAddedSuccMsg;
	public WebElement getTopicAddedSuccMsg() {
		return topicAddedSuccMsg;
	}
	
	
}
