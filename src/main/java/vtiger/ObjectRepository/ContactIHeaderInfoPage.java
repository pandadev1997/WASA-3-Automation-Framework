package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactIHeaderInfoPage {
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement ContactHeaderText;

	public ContactIHeaderInfoPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	public WebElement getContactHeaderText() {
		return ContactHeaderText;
	}
	public String contactHeadertext() {
		return ContactHeaderText.getText();
	}
	

}
