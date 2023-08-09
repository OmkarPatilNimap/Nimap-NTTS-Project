package nimap.ntts.testComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import nimap.ntts.pageObjects.LoginPage;

public class BaseTest {

	public WebDriver driver;
	public Properties prop;
	public Properties prop1;

	public WebDriver initializeDriver() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\nimap\\ntts\\resources\\GlobalData.properties");
		prop.load(fis);
		
		prop1 = new Properties();
		FileInputStream fis1 = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\nimap\\ntts\\resources\\AddNewEmployeeDetails.properties");
		prop1.load(fis1);
		String browserName = prop.getProperty("browser");
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {
			System.out.println("Please Pass The Right Browser :" + browserName);
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}

	public WebDriver launchApplication() throws IOException {
		driver = initializeDriver();
		return driver;
	}

	public String goToNttsPage() {
		String url = prop.getProperty("url");
		return url;
	}
	
	public void excelFile() throws IOException {
		FileInputStream fis = new FileInputStream(("user.dir")+"\\src\\test\\java\\ExcelFiles\\DataSheet.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
                  int rowCount=   sheet.getPhysicalNumberOfRows();
                  XSSFRow row=sheet.getRow(0);
                  
	}
	
	//@AfterClass(alwaysRun=true)
	public void closeCurrentBrowser() {
		driver.close();
	}
}
