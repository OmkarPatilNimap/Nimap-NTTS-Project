package nimap.ntts.testComponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import nimap.ntts.pageObjects.PageObjectManager;

public class TestContextSetup {

	public WebDriver driver;
	
	public BaseTest baseTest;
	public PageObjectManager pageObjectManager;
	
	public TestContextSetup() throws IOException
	{
		baseTest = new BaseTest();
		//pageObjectManager = new PageObjectManager(baseTest.initializeDriver());
	}
}
