package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.Generalutility.WebDriver_Utility;

public class Create_OrganaizationPage extends WebDriver_Utility {
	@FindBy(xpath="//input[@name='accountname']")
	private WebElement orgnameEdt;
	
	@FindBy(name="industry")
	private WebElement IndustryDropdown;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	public Create_OrganaizationPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
		
	}

	public WebElement getOrgnameEdt() {
		return orgnameEdt;
	}

	public WebElement getIndustryDropdown() {
		return IndustryDropdown;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public void CreateOrg(String orgname,String IndustryType) {
		orgnameEdt.sendKeys(orgname);
		handeldropdown(IndustryDropdown, IndustryType);
		saveBtn.click();
		
	}
	
	

}
