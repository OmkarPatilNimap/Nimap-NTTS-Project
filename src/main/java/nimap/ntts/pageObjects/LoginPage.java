package nimap.ntts.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import nimap.ntts.pageComponents.PageComponents;

public class LoginPage extends PageComponents {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "input[name='loginEmail']")
	private WebElement loginEmail;
	public WebElement getEmpId() {
		return loginEmail;
	}
	
	@FindBy(xpath = "//div[contains(text(),'Email')]")
	WebElement loginEmailErrMsg;
	public WebElement getLoginEmailErrMsg() {
		return loginEmailErrMsg;
	}
	
	@FindBy(css = "input[name='password']")
	WebElement loginPass;
	public WebElement getEmpPwd() {
		return loginPass;
	}
	
	@FindBy(xpath = "//div[contains(text(),'Invalid password or email')]")
	WebElement invalidEmailOrPwdMsg;
	public WebElement getInvalidEmailOrPwdMsg() {
		return invalidEmailOrPwdMsg;
	}
	
	@FindBy(xpath = "//div[contains(text(),'Please enter your Password')]")
	WebElement emptyPwdErrMsg;
	public WebElement emptyPwdErrMsg() {
		return emptyPwdErrMsg;
	}
	
	@FindBy(xpath = "//div[contains(text(),'ust Contain 8 Characters')]")
	WebElement loginPassErrMsg;
	public WebElement getLoginPassErrMsg() {
		return loginPassErrMsg;
	}

	@FindBy(id = "remember-me")
	WebElement checkBox;
	public WebElement getCheckBox() {
		return checkBox;
	}

	@FindBy(css = ".btn1")
	WebElement signinBtn;
	public WebElement getSignInBtn() {
		return signinBtn;
	}
	@FindBy(css = ".btn")
	WebElement signinBtn1;
	public WebElement getSignInBtn1() {
		return signinBtn1;
	}

	@FindBy(css = ".cursor-pointer")
	WebElement eyeBtn;
	public WebElement getEyeBtn() {
		return eyeBtn;
	}

	@FindBy(xpath = "//small[contains(text(),'Forgot')]")
	WebElement forgotPassLnk;
	public WebElement getForgotPassLink() {
		return forgotPassLnk;
	}

	@FindBy(xpath = "//small[contains(text(),'Sign')]")
	WebElement signInWithOtpLink;
	public WebElement getSignInWithOtpLnk() {
		return signInWithOtpLink;
	}
	
	@FindBy(xpath = "//input[@placeholder='john@example.com']")
	private WebElement enterEmail;
	public WebElement goToEnterEmail() {
		return enterEmail;
	}
	
	@FindBy(css = ".btn")
	private WebElement sendOtpBtn;
	public WebElement getSendOtpBtn() {
		return sendOtpBtn;
	}
	
	@FindBy(xpath = "//h6[normalize-space()='OTP SENT!']")
	private WebElement otpSendSuccMsg;
	public WebElement getOtpSendSuccMsg() {
		return otpSendSuccMsg;
	}
	
	@FindBy(xpath = "//div[@role='status']")
	private WebElement invalidEmailMsg;
	public WebElement getInvalidEmailMsg() {
		return invalidEmailMsg;
	}
	
	@FindBy(xpath = "//input[@class='form-control']")
	private WebElement enterNewPass;
	public WebElement getEnterNewPass() {
		return enterNewPass;
	}
	
	@FindBy(css = ".auth-input")
	private List<WebElement> otpBlocks;
	public List<WebElement> getOtpBlocks() {
		return otpBlocks;
	}
	
	@FindBy(xpath = "//button[contains(text(),'Submit')]")
	private WebElement submitBtn;
	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	
	@FindBy(xpath = "//div[@role='status']")
	private WebElement invalidOtpMsg;
	public WebElement getInvalidOtpMsg() {
		return invalidOtpMsg;
	}
	
	@FindBy(xpath = "//h6[contains(text(),'Password Changed Successfuly')]")
	private WebElement passResetSuccMsg;
	public WebElement getPassResetSuccMsg() {
		return passResetSuccMsg;
	}
	//strong[normalize-space()='Please Login with New Password']
	//strong[contains(text(),'Please Login with New Password')]
	
	
	@FindBy(xpath = "//small[contains(text(),'Sign in with OTP')]")
	private WebElement signInWithOtp;
	public WebElement getSignInWithOtp() {
		return signInWithOtp;
	}
	
	
	

//	public void initializeDriver() {
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver = new ChromeDriver();
//		driver.findElement(By.cssSelector("input[name='loginEmail']"));
//	}

//	public String getLoginPageTitle() {
//		return driver.getTitle();
//	}
//
//	public String getLoginUrl() {
//		return driver.getCurrentUrl();
//	}
//
//	public WebElement isForgotPwdLinkExist() {
//		return forgotPassLnk;
//		//a[contains(@href,'forgot')]
//	}
//
//	public WebElement signInWithOtpLinkExist() {
//		return signInWithOtpLnk;
//	}
//	
//	public void clickOnSignin() {
//		signinBtn.click();
//	}
//
//	public void goToLogin(String email, String pwd) {
//		loginEmail.sendKeys(email);
//		loginPass.sendKeys(pwd);
//		checkBox.click();	
//	}
	
}
