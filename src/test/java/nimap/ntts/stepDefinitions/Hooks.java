package nimap.ntts.stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import nimap.ntts.testComponents.TestContextSetup;

public class Hooks {
	
	private WebDriver driver;

    public Hooks(TestContextSetup testContextSetup) throws IOException {
        this.driver = testContextSetup.getWebDriver();
    }

    @AfterStep
    public void addScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshotBytes, "image/png", "screenshot");
        }
    }

}
