package practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import vtiger.Generalutility.javautility;
import vtiger.ObjectRepository.Create_OrganaizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.OrganaizationHeaderinfoPage;
import vtiger.ObjectRepository.Organaizationpage;

public class Create_multiple_org_witgh_data_oprovider {
	Excel_file_utility eutil=new Excel_file_utility();
	@Test(dataProvider = "getData")
	public void readmultipledata() {
		javautility jutil=new javautility();
		/*String URL=putil.readDataFromPropertyFile("url");
		String UN=putil.readDataFromPropertyFile("username");
		String PW=putil.readDataFromPropertyFile("password");
		String BROWSER=putil.readDataFromPropertyFile("browser");*/
		
		//String LASTNAME=eutil.Excel("contact", 2, 1);
		//String ORGNAME=eutil.Excel("contact", 4, 2)+jutil.getRandomno();
	//	String INDUSTRYDD=eutil.Excel("org", 1, 2);
		
		WebDriver driver=null;
		
		/*if(BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		
		
		wutil.maximizeWindow(driver);
		wutil.waitForPage(driver);
		driver.get(URL);
		
		LoginPage lop=new LoginPage(driver);
		lop.login(UN, PW);*/
		
		HomePage homp=new HomePage(driver);
		homp.clickOrgnazation();
		Reporter.log("home page is clicking");
		Organaizationpage op=new Organaizationpage(driver);
		op.clickOrgLookupIcon();
		
		Create_OrganaizationPage cop=new Create_OrganaizationPage(driver);
		cop.CreateOrg(ORGNAME, INDUSTRYDD);
		
		OrganaizationHeaderinfoPage orhip=new OrganaizationHeaderinfoPage(driver);
		String orgheader = orhip.orgHeader();
		
		if(orgheader.contains(ORGNAME)) {
			System.out.println(orgheader+"organaization created");
		}
		else
			System.out.println("organaization not created");
		
		
		
		
		
	}
	@DataProvider
	public Object[][] getData() throws EncryptedDocumentException, IOException{
		Object[][] data=eutil.readMultipledata("Sheet1");
		return data;
	}

}
