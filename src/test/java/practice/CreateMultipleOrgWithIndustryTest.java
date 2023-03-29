package practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import vtiger.Generalutility.Base_class;
import vtiger.ObjectRepository.Create_OrganaizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.OrganaizationHeaderinfoPage;
import vtiger.ObjectRepository.Organaizationpage;

public class CreateMultipleOrgWithIndustryTest extends Base_class {
	@Test(dataProvider = "getData")
	public void createmultipleorgtest(String org,String industry) {
		String Orgname=org+ju.getRandomno();
		HomePage hoo=new HomePage(driver);
		hoo.clickOrgnazation();
		
		Organaizationpage or=new Organaizationpage(driver);
		or.clickOrgLookupIcon();
		
		Create_OrganaizationPage cor=new Create_OrganaizationPage(driver);
		cor.CreateOrg(Orgname, industry);
		
		OrganaizationHeaderinfoPage orgi=new OrganaizationHeaderinfoPage(driver);
		String headername = orgi.orgHeader();
		
		Assert.assertTrue(headername.contains(Orgname));
	}
	@DataProvider
	public Object[][] getData() throws EncryptedDocumentException, IOException{
		Object[][] data=eutil.readMultipledata("multiple");
		return data;
	}

}
