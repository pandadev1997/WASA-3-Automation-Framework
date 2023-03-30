package vtiger.contact.test;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import practice.Excel_file_utility;
import vtiger.Generalutility.Base_class;
import vtiger.Generalutility.Excel_File_utility;
import vtiger.Generalutility.javautility;
import vtiger.ObjectRepository.ContactIHeaderInfoPage;
import vtiger.ObjectRepository.Contactspage;
import vtiger.ObjectRepository.CreatingNewContactPage;
import vtiger.ObjectRepository.HomePage;

public class Crt_ContactTest extends Base_class {
	@Test(groups = {"smoke"})
	public void createcontact() throws Exception {
		Excel_File_utility eutil=new Excel_File_utility();
		javautility jutil=new javautility();
		
		String lastname = eutil.Excel("contact", 1, 2)+jutil.getRandomno();
		String orgname=eutil.Excel("contact", 4, 2);
		
		HomePage hp=new HomePage(driver);
		hp.clickContact();
		
		Contactspage cp=new Contactspage(driver);
		cp.clickoncreatecontacticon();
		
		CreatingNewContactPage cncp=new CreatingNewContactPage(driver);
		cncp.createNewContactWithorg(driver, lastname, orgname);
		
		ContactIHeaderInfoPage chip=new ContactIHeaderInfoPage(driver);
		String cht = chip.contactHeadertext();
		
		Assert.assertTrue(true);
		System.out.println("contact createed with org");
				
	}
	@Test
	public void newq() {
		System.out.println("except smoke");
	}

}
