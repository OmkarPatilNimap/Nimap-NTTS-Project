package nimap.ntts.testComponents;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentSparkReporterConfig;

public class ExtentReportClass extends BaseTest implements ITestListener {
	
	WebDriver driver;
	static ExtentReports extentReports;
	static ExtentTest extentTest;
	ExtentReports extent = extentReports();

	public static  ExtentReports extentReports() {
				File file = new File("report.html");
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);
		ExtentSparkReporterConfig sparkConfig = sparkReporter.config();
		sparkConfig.setDocumentTitle("NTTS Automation Test Reports");
		sparkConfig.setReportName("NTTS Test Results");
		sparkConfig.setTimeStampFormat("dd-MM-yyyy hh:mm:ss");
	
		extentReports = new ExtentReports();
		extentReports.setSystemInfo("OS", "Windows 10 Pro");
		extentReports.setSystemInfo("App Url", "https://ntts-qa.nimapinfotech.com/");
		extentReports.setSystemInfo("Browser", "Chrome Version 115.0.5790.110");
		extentReports.attachReporter(sparkReporter);
		return extentReports;
	}

	@Override
	public void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName + " started!");		
		extentTest=extent.createTest(methodName + " started!");
		extentTest.assignAuthor("Omkar Patil");
		extentTest.assignCategory("Chrome");
		extentTest.pass("first");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extentTest.log(Status.PASS, "Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
//		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
//		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
//		File destFile = new File(("user.dir") + "//Screenshots//ScreenShotOfFailedTest.jpg");
//		try {
//			FileUtils.copyFile(sourceFile, destFile);
//		} catch (IOException e) {
//			e.printStackTrace();
//			extentTest.info(e);
//		}
//		String path = destFile.getAbsolutePath();
//		extentTest.addScreenCaptureFromPath(path, "Screen Shot of Failed Test");
		extentTest.log(Status.FAIL, "Test Failed");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		extentTest.log(Status.SKIP, "Test Skiped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {

	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}

}
