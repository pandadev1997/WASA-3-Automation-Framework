package vtiger.Generalutility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class WebDriver_Utility {
	/**
	 * This method maximize our window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	/**
	 * This method minimize oyr window
	 * @param driver
	 */
	public void minimize(WebDriver driver) {
		driver.manage().window().minimize();
		
	}
	/**
	 * This method wait for the webpage load
	 * @param driver
	 */
	public void waitForPage(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	public void waitForElementTobevisible(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public void waitForElementTobeClickable(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * This method will handel dropdown by using value
	 * @param value
	 * @param element
	 */
	public void  handeldropdown(String value,WebElement element) {
		Select sel=new Select(element);
		sel.selectByValue(value);
	}
	/**
	 * this method will handel the dropdown using visible text
	 * @param element
	 * @param text
	 */
	public void handeldropdown(WebElement element,String text) {
		Select sel=new Select(element);
		sel.selectByVisibleText(text);
	}
	/**
	 * This method will perfoorm mouse hover action
	 * @param driver
	 * @param element
	 */
	public void mouseHoverAction(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	/**
	 * This method will right click anywhere in the webpage
	 * @param driver
	 */
	public void mouseHoverAction(WebDriver driver) {
		Actions act=new Actions(driver);
		act.contextClick().perform();
	}
	/**
	 * This method will perforrm right click operation in any porticular element
	 * @param driver
	 * @param element
	 */
	public void rightClickonElement(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
	}
	/**
	 * This method will perform double click operation anywhere in the webpage
	 * @param driver
	 */
	public void doubleClick(WebDriver driver) {
		Actions act=new Actions(driver);
		act.doubleClick().perform();
	}
	/**
	 * This method will perform double click on porticular element
	 * @param driver
	 * @param element
	 */
	public void doubleClickonElement(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.doubleClick(element).perform();
		 
	}
	/**
	 * This method will perform drag and drop operation in a webpage
	 * @param driver
	 * @param sourceE
	 * @param targetE
	 */
	public void dragAndDrop(WebDriver driver,WebElement sourceE,WebElement targetE) {
		Actions act=new Actions(driver);
		act.dragAndDrop(sourceE, targetE).perform();
	}
	
	/**
	 * This method wiil accept the alert
	 * @param driver
	 */
	public void accceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	/**
	 * this method will dissmiss the alert
	 * @param driver
	 */
	public void  dismissAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	/**
	 * This method will capture the text from alert popup
	 * @param driver
	 * @return
	 */
	public String getAlertText(WebDriver driver) {
		return driver.switchTo().alert().getText();
		
	}
	/**
	 * This method will handel frame based on index
	 * @param driver
	 * @param index
	 */
	public void handelFrame(WebDriver driver,int index) {
		driver.switchTo().frame(index);
	}
	/**
	 * this method will handel the frame based on nameorId
	 * @param driver
	 * @param nnameorId
	 */
	public void handelFrame(WebDriver driver,String nnameorId) {
		driver.switchTo().frame(nnameorId);
	}
	/**
	 * this method will handel the frame based on element
	 * @param driver
	 * @param element
	 */
	public void handelFrame(WebDriver driver,WebElement element) {
		driver.switchTo().frame(element);
	}
	/**
	 * this method will return to parentframe
	 * @param driver
	 */
	public void switchToParentframe(WebDriver driver) {
		driver.switchTo().parentFrame();
	}
	/**
	 * this method will return to defaultframe
	 * @param driver
	 */
	public void switchtoDefaultFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	/**
	 * This method will switch the window based on partial window title
	 * @param driver
	 * @param partialWinTitle
	 */
	public void switchtoWindow(WebDriver driver,String partialWinTitle) {
		//step 1: capture all the window ids
		Set<String> winids = driver.getWindowHandles();
		
		//step 2: navigate to each window
		for(String win:winids) {
			//step 3: Switch to window and capture the title
			String winTitle = driver.switchTo().window(win).getTitle();
			
			//step 4:  compare the title with required partial title
			if(winTitle.contains(partialWinTitle)) {
				break;
			}
		}
	}
	/**
	 * This method will take screenshot and save it in folder
	 * @param driver
	 * @param screenshotName
	 * @throws IOException
	 */
	public String takeScreenshot(WebDriver driver,String screenshotName) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File(".\\Screenshot\\"+screenshotName+".png");
		Files.copy(src, dest);
		return dest.getAbsolutePath();//used for extend report
	}
	/**
	 * This method will perform random scroll downwards vertically
	 * @param driver
	 */
	public void scrollAction(WebDriver driver) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", "");
	}
	/**
	 * This method will scroll the element is identified in DOM
	 * @param driver
	 * @param element
	 */
	public void scrollActions(WebDriver driver,WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		int y=element.getLocation().getY();
		js.executeScript("window.scrollBy(0,"+y+")", element);
	}

}
