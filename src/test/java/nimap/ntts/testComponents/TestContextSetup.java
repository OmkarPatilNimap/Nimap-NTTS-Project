package nimap.ntts.testComponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import nimap.ntts.pageObjects.PageObjectManager;

public class TestContextSetup {
	
	 public WebDriver driver;

	    public WebDriver getWebDriver() throws IOException {
	        if (driver == null) {
	            driver = new BaseTest().initializeDriver();
	        }
	        return driver;
	    }
}
