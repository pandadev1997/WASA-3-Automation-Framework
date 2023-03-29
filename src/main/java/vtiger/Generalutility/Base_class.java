package vtiger.Generalutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;

public class Base_class {
	public WebDriver_Utility wu=new WebDriver_Utility();
	public Excel_File_utility eutil=new Excel_File_utility();
	public javautility ju=new javautility();
	public PropertyFile_utility pu=new PropertyFile_utility();
	public static WebDriver sdriver;//for listners only
	public WebDriver driver;
	@BeforeSuite
	public void database() {
		System.out.println("----Data base connection happen sucessfully---");
	}
	
	@BeforeClass
	public void launching() throws Exception {
		String BROWSER = pu.readDataFromPropertyFile("browser");
		String URL = pu.readDataFromPropertyFile("url");
		
		if(BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else {
			System.out.println("invalid browser");
		}
		sdriver=driver;//listners
		wu.maximizeWindow(driver);
		wu.waitForPage(driver);
		driver.get(URL);
		
	}
	
	
	@BeforeMethod
	public void login() throws Exception {
		String UN = pu.readDataFromPropertyFile("username");
		String PW = pu.readDataFromPropertyFile("password");
		LoginPage lop=new  LoginPage(driver);
		lop.login(UN, PW);
		//Thread.sleep(5000);
	}
	
	@AfterMethod
	public void logout() {
		HomePage ho=new HomePage(driver);
		ho.logOutApp(driver);	
	}
	
	@AfterClass
	public void closebrowser() {
		driver.quit();
	}
	@AfterSuite
	public void closeDB() {
		System.out.println("database connection closed");
	}

}
