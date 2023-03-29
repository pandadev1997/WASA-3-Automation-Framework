package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Vtiger_scenario_automate {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium folder\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin",Keys.TAB,"root",Keys.ENTER);
		driver.findElement(By.xpath("(//a[text()='Leads'])[1]")).click();
		driver.findElement(By.xpath("//td[@class='tabSelected']")).click();
		driver.findElement(By.xpath("(//td[@align=\"left\"])[2]")).click();
		driver.findElement(By.xpath("//td[@class='tabSelected']")).click();
		WebElement ele=driver.findElement(By.xpath("//select[@id='viewname']"));
		Select se=new Select(ele);
		se.selectByIndex(2);
		

	}

}
