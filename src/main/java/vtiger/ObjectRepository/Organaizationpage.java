package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Organaizationpage {
	
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement orglookupicon;

	public Organaizationpage(WebDriver driver) {
		PageFactory.initElements(driver,this);
		
	}

	public WebElement getOrglookupicon() {
		return orglookupicon;
	}
	
	public void clickOrgLookupIcon() {
		orglookupicon.click();
	}

}
