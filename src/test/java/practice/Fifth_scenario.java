package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Fifth_scenario {

	public static void main(String[] args) {
		// launching browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:8888");

		// log in to the app
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementsByName('user_name')[0].value=\"admin\";");
		js.executeScript("document.getElementsByName('user_password')[0].value=\"root\";");
		js.executeScript("document.getElementById('submitButton').click();");
		
		//click on contact link
		driver.findElement(By.xpath("//a[@href='index.php?module=Contacts&action=index']")).click();
		//click on create contact lookup icon
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		//create contact save and verify
		driver.findElement(By.name("lastname")).sendKeys("debasish");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String name=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(name.contains("debasish")) {
			System.out.println("contact created");
		}
		//logout the app
				WebElement ele2=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
				Actions act=new Actions(driver);
				act.moveToElement(ele2).perform();
				driver.findElement(By.xpath("//a[@href='index.php?module=Users&action=Logout']")).click();
				
				//close the browser
				driver.close();

	}

}
