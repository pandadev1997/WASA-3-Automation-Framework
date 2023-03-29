package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//Create a POM class for every webpage
public class LoginPage {
	@FindBy(name="user_name")
	private WebElement usernameEdt;
	@FindAll({@FindBy(name="user_password"),@FindBy(xpath="//input[@type='password']")})
	private WebElement passwordEdt;
	@FindBy(xpath="//input[@id=\"submitButton\"]")
	private WebElement loginBtn;
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	public WebElement getUsernameEdt() {
		return usernameEdt;
	}
	public WebElement getPasswordEdt() {
		return passwordEdt;
	}
	public WebElement getLoginBtn() {
		return loginBtn;
	}
	public void login(String username,String password) {
		getUsernameEdt().sendKeys(username);
		getPasswordEdt().sendKeys(password);
		getLoginBtn().click();
	}
	
	

}
