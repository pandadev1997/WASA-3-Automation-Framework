package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class First_scenario {

	public static void main(String[] args) {
		//step 1:launching browser
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:8888");
		
		//Step 2:login operation
		
		driver.findElement(By.name("user_name")).sendKeys("admin",Keys.TAB,"root",Keys.ENTER);
		
		//step 3:navigate to contact link
		
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		
		
		//step 4:click on create contact lookup image
		
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
		//create contact with mandatory fields
		
	  driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("dev");
		
		//save and verify
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		String name = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(name.contains("dev")) {
			System.out.println("matching");
		}
		else
			System.out.println("not craeted");
		
		//logout
		
		WebElement ele = driver.findElement(By.xpath("(//td[@class='small'])[2]"));
		Actions act=new Actions(driver);
		act.moveToElement(ele).perform();
		driver.findElement(By.xpath("(//td[@style='padding-left:0px;padding-right:10px font-weight:bold'])[2]")).click();
		
		
		
		

	}

}
