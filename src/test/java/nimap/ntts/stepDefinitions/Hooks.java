package nimap.ntts.stepDefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.maven.surefire.shared.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import nimap.ntts.testComponents.TestContextSetup;

public class Hooks {
	WebDriver driver;

	TestContextSetup testContextSetup;
	public Hooks(TestContextSetup testContextSetup){
		this.testContextSetup=testContextSetup;	
	}
	
	@AfterStep
	public void AddScreenshot(Scenario scenario) throws IOException {
		if(scenario.isFailed()){
			driver = testContextSetup.baseTest.initializeDriver();
			File sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);
			scenario.attach(fileContent, "image/png", "imageName");
		}
	}
	
}
