package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.Generalutility.WebDriver_Utility;

public class HomePage extends WebDriver_Utility {
	@FindBy(xpath="//a[text()='Contacts']")
	private WebElement contactLink;
	
	@FindBy(xpath="//a[@href='index.php?module=Accounts&action=index']")
	private WebElement orglink;
	
	@FindBy(linkText="Opportunities")
	private WebElement opportunitieslink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorimage;
	
	@FindBy(xpath="//a[@href='index.php?module=Users&action=Logout']")
	private WebElement signout;
	

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}

	public WebElement getContactLink() {
		return contactLink;
	}

	public WebElement getOrglink() {
		return orglink;
	}

	public WebElement getOpportunitieslink() {
		return opportunitieslink;
	}

	public WebElement getAdministratorimage() {
		return administratorimage;
	}
	
	public WebElement getSignout() {
		return signout;
	}

	public void clickContact() {
		contactLink.click();
	}
	
	public void clickOrgnazation() {
		orglink.click();
	}
	
	public void logOutApp(WebDriver driver) {
		mouseHoverAction(driver, administratorimage);
		signout.click();
		
		
	}
	
	

	
	
	 

}
