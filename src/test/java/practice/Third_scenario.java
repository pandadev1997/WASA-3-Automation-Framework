package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Third_scenario {
		public static void main(String[] args) throws Exception {
			//launching browser
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("http://localhost:8888");
			
			//log in to the app
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("document.getElementsByName('user_name')[0].value=\"admin\";");
			js.executeScript("document.getElementsByName('user_password')[0].value=\"root\";");
			js.executeScript("document.getElementById('submitButton').click();");
			Thread.sleep(3000);
			//click on organization link
			
			driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
			
			//click on create organization lookup image
			
			driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
			
			//create organization save and verify
			
			driver.findElement(By.name("accountname")).sendKeys("DASE PVT LTD");
			WebElement ele=driver.findElement(By.xpath("//select[@name='industry']"));
			ele.click();
			Select se=new Select(ele);
			se.selectByValue("Chemicals");
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			String name = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			if(name.contains("DASE PVT LTD")) {
				System.out.println("created successfully");
				
			}
			//logout the app
			WebElement ele1=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			Actions act=new Actions(driver);
			act.moveToElement(ele1).perform();
			driver.findElement(By.xpath("//a[@href='index.php?module=Users&action=Logout']")).click();
			
			//close the browser
			driver.close();

	}

}
