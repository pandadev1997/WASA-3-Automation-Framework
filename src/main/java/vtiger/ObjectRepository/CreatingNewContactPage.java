package vtiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.Generalutility.WebDriver_Utility;

public class CreatingNewContactPage extends WebDriver_Utility {
	@FindBy(xpath="//input[@name='lastname']")
	private WebElement Lastname;
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(xpath="//input[@name='account_name']/following-sibling::img[@alt='Select']")
	private WebElement orglookupicon;
	
	@FindBy(name="search_text")
	private WebElement searchtext;
	
	@FindBy(name="search")
	private WebElement searchBtn;
	
	public CreatingNewContactPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	public WebElement getLastname() {
		return Lastname;
	}
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	public WebElement getOrhlookupicon() {
		return orglookupicon;
	}
	public WebElement getSearchtext() {
		return searchtext;
	}
	
	public WebElement getSearchBtn() {
		return searchBtn;
	}
	public void createNewContact(String lastname) {
		Lastname.sendKeys(lastname);
		saveBtn.click();
	}
	/**
	 * This method will contact with Organaization
	 * @param driver
	 * @param lastname
	 * @param orgname
	 */
	
	public void createNewContactWithorg(WebDriver driver,String lastname, String orgname) {
		Lastname.sendKeys(lastname);
		orglookupicon.click();
		switchtoWindow(driver, "Accounts");
		searchtext.sendKeys(orgname);
		searchBtn.click();
		driver.findElement(By.xpath("//a[text()='"+orgname+"']")).click();
		switchtoWindow(driver, "Contacts");
		saveBtn.click();
		
		
	}
	
	
	

}
