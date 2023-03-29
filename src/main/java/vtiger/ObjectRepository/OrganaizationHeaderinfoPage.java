package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganaizationHeaderinfoPage {
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement OrgHeaderText;

	public OrganaizationHeaderinfoPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	public WebElement getOrgHeaderText() {
		return OrgHeaderText;
	}
	/**
	 * This method will capture the text from org header and return it to a caller
	 * @return
	 */
	public String orgHeader() {
		return OrgHeaderText.getText();
	}
	
	

}
