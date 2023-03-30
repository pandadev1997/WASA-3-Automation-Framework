package vtiger.organaisation.test;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vtiger.Generalutility.Base_class;
import vtiger.Generalutility.Excel_File_utility;
import vtiger.Generalutility.javautility;
import vtiger.ObjectRepository.Create_OrganaizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.OrganaizationHeaderinfoPage;
import vtiger.ObjectRepository.Organaizationpage;
@Listeners(vtiger.Generalutility.ListnersImplementtion.class)
public class CreatorganaisationTest extends Base_class {
    
	@Test(groups = {"smoke","regression"})
	public void crtOrganaizationTest() throws Exception {
		
		//PropertyFile_utility putil=new PropertyFile_utility();
		Excel_File_utility eutil=new Excel_File_utility();
		//WebDriver_Utility wutil=new WebDriver_Utility();
		javautility jutil=new javautility();
		/*String URL=putil.readDataFromPropertyFile("url");
		String UN=putil.readDataFromPropertyFile("username");
		String PW=putil.readDataFromPropertyFile("password");
		String BROWSER=putil.readDataFromPropertyFile("browser");*/
		
		//String LASTNAME=eutil.Excel("contact", 2, 1);
		String ORGNAME=eutil.Excel("contact", 4, 2)+jutil.getRandomno();
		String INDUSTRYDD=eutil.Excel("org", 1, 2);
		
		//WebDriver driver=null;
		
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
		
		HomePage hp=new HomePage(driver);
		hp.clickOrgnazation();
		
		Organaizationpage op=new Organaizationpage(driver);
		op.clickOrgLookupIcon();
		
		Create_OrganaizationPage cp=new Create_OrganaizationPage(driver);
		cp.CreateOrg(ORGNAME, INDUSTRYDD);
		
		OrganaizationHeaderinfoPage ohip=new OrganaizationHeaderinfoPage(driver);
		String orgheader = ohip.orgHeader();
		
		if(orgheader.contains(ORGNAME)) {
			System.out.println("validate");
		}
		else
			System.out.println("not validate");
		
		
		
		
		
	}

}
