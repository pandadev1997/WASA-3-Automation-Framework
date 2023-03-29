package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Second_scenario {

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
		
		driver.findElement(By.name("accountname")).sendKeys("DAGS PVT LTD");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String name=driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();
		if(name.contains("DAGS PVT LTD")) {
			System.out.println("matching");
		}
		
		//logout the app
		WebElement ele=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act=new Actions(driver);
		act.moveToElement(ele).perform();
		driver.findElement(By.xpath("//a[@href='index.php?module=Users&action=Logout']")).click();
		
		//close the browser
		driver.close();

	}

}
