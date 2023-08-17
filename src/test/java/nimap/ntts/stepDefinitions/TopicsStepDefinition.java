package nimap.ntts.stepDefinitions;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import nimap.ntts.pageObjects.LandingPage;
import nimap.ntts.pageObjects.LoginPage;
import nimap.ntts.pageObjects.TopicPage;
import nimap.ntts.pageObjects.User_EmployeeListPage;
import nimap.ntts.testComponents.BaseTest;
import nimap.ntts.testComponents.TestContextSetup;

public class TopicsStepDefinition extends BaseTest {
	private User_EmployeeListPage EL;
	private TopicPage TP;
	private WebDriverWait wait;
	private LoginPage CL;
	private LandingPage LP;
	Actions a;
	WebDriver driver;
	private final TestContextSetup testContextSetup;

	public TopicsStepDefinition(TestContextSetup testContextSetup) throws IOException {
		this.testContextSetup = testContextSetup;
	}

	@Given("User Login With Valid Credentials {string} {string}")
	public void user_login_with_valid_credentials(String Username, String Password) throws IOException {
		testContextSetup.driver = initializeDriver();
		EL = new User_EmployeeListPage(testContextSetup.driver);
		TP = new TopicPage(testContextSetup.driver);
		CL = new LoginPage(testContextSetup.driver);
		LP = new LandingPage(testContextSetup.driver);
		a = new Actions(testContextSetup.driver);
		wait = new WebDriverWait(testContextSetup.driver, Duration.ofSeconds(10));
		testContextSetup.driver.get(goToNttsPage());
		LoginPage CL = new LoginPage(testContextSetup.driver);
		CL.getEmpId().sendKeys(Username);
		CL.getEmpPwd().sendKeys(Password);
		CL.getSignInBtn().click();
	}

	@Given("User Refresh The Browser")
	public void user_refresh_the_browser() {
		testContextSetup.driver.navigate().refresh();
	}

	@Given("User Currently is on Masters Topic Module")
	public void user_currently_is_on_masters_topic_module() {
		String actualTitle = TP.getTopicListTitle().getText();
		String expectedTitle = prop2.getProperty("topicListTitle");
		Assert.assertEquals(actualTitle, expectedTitle);
	}

	@When("User Clicks on Add Topic button")
	public void user_clicks_on_add_topic_button() {
		wait.until(ExpectedConditions.invisibilityOf(LP.getloginSuccText()));
		TP.getAddTopicBtn().click();
	}

	@When("User Clicks on Add New Topic button")
	public void user_clicks_on_add_new_topic_button() {
		TP.getAddNewTopicBtn().click();
	}

	@When("User Enter All The Required Fields")
	public void user_enter_all_the_required_fields() throws InterruptedException {
		Thread.sleep(2000);
		TP.getTopicName().sendKeys(prop2.getProperty("topicName"));
//		a.click(TP.getTechName()).sendKeys(prop2.getProperty("TechName")).keyDown(Keys.ENTER).keyUp(Keys.ENTER).build().perform();
		a.click(TP.getTechName()).sendKeys(prop2.getProperty("techName")).keyDown(Keys.ENTER).build().perform();
		TP.getPriority().clear();
		TP.getPriority().sendKeys(prop2.getProperty("priority"));
		String file = prop2.getProperty("uploadFilePath");
		TP.getNewTopicUploadFile().sendKeys(file);
		TP.getDescription().sendKeys(prop2.getProperty("desc"));
		TP.getEnterUrl().sendKeys(prop2.getProperty("topicUrl"));
		TP.getAddUrlBtn().click();
	}

	@Then("User Clicks on Masters Menu and Select Topic Sub Menu")
	public void user_clicks_on_masters_menu_and_select_topic_sub_menu() throws InterruptedException {
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(EL.getMastersMenu()));
		EL.getMastersMenu().click();
		wait.until(ExpectedConditions.elementToBeClickable(TP.getTopicMenu()));
		TP.getTopicMenu().click();
	}

	@Then("User Search Java Technology")
	public void user_search_java_technology() {
		TP.getSearchTextBox().sendKeys(prop2.getProperty("technology1"));
	}

	@Then("Verify only Java Technology Appears on the Page")
	public void verify_only_java_technology_appears_on_the_page() {
		for (int i = 0; i < TP.getTechnologyNames().size(); i++) {
			String actualTechName = TP.getTechnologyNames().get(i).getText();
			String expectedTechName = prop2.getProperty("technology1");
			Assert.assertEquals(actualTechName, expectedTechName);
		}
	}

	@Then("Verify The Topic Added Successfully")
	public void verify_the_topic_added_successfully() {
		wait.until(ExpectedConditions.visibilityOf(TP.getTopicAddedSuccMsg()));
		String actualSuccMsg = TP.getTopicAddedSuccMsg().getText();
		String expectedSuccMsg = prop2.getProperty("topicAddedSuccMsg");
		Assert.assertEquals(actualSuccMsg, expectedSuccMsg);
	}

}
