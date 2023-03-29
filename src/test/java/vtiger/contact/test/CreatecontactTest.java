package vtiger.contact.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import practice.Base_classes;
import vtiger.Generalutility.Base_class;
import vtiger.ObjectRepository.Contactspage;
import vtiger.ObjectRepository.CreatingNewContactPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;

public class CreatecontactTest extends Base_classes {

	@Test
	public void createContactTest() throws EncryptedDocumentException, IOException {
		Random r=new Random();
		int random=r.nextInt(1000);
		// read data from property file
		FileInputStream fisp=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties p=new Properties();
		p.load(fisp);
		String URL = p.getProperty("url");
		String BROWSER=p.getProperty("browser");
		String USERNAME=p.getProperty("username");
		String PASSWORD=p.getProperty("password");
		
		//read data from excelsheet
		
		FileInputStream fise=new FileInputStream(".\\src\\test\\resources\\Test data.xlsx");
		Workbook book = WorkbookFactory.create(fise);
		Sheet sh=book.getSheet("contact");
		String LASTNAME=sh.getRow(1).getCell(2).getStringCellValue()+random;
		
		//Step 2: llaunch the browser
		
		WebDriver driver=null;
		if(BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else {
			System.out.println("invalid browser");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URL);
		
		//step 3:login to the app
		
		//driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USERNAME);
		//driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PASSWORD);
		//driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		LoginPage lo=new LoginPage(driver);
		lo.login("admin","root");
		//step 4:click to contact
		
		//driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		HomePage ho=new HomePage(driver);
		ho.clickContact();
		//click on create contact lookup image
		
		//driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		Contactspage co=new Contactspage(driver);
		co.clickoncreatecontacticon();
		//create contact with all mandatory fields
		
		//driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(LASTNAME);
		//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		CreatingNewContactPage cr=new CreatingNewContactPage(driver);
		//cr.enterlastName(LASTNAME);
		//cr.clickpnsave();
		
		
		//comapre the name
		String name=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(name.contains(LASTNAME)) {
			System.out.println("matches");
		}
		//logout the app
		WebElement ele=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act=new Actions(driver);
		act.moveToElement(ele).perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		
		
		//close the browser
		driver.close();
				
		
		
		
		
		
		
		
		
		
		

	}

}
