package vtiger.Generalutility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListnersImplementtion implements ITestListener {

	public void onTestStart(ITestResult result) {
		String methodname=result.getMethod().getMethodName();
		System.out.println(methodname+"---executionstart");
	}

	public void onTestSuccess(ITestResult result) {
		String methodname=result.getMethod().getMethodName();
		System.out.println(methodname+"---pass");
	}

	public void onTestFailure(ITestResult result) {
		javautility jutil=new javautility();
		WebDriver_Utility wutil=new WebDriver_Utility();
	
		String methodname=result.getMethod().getMethodName();
		System.out.println(methodname+"---fail");
		
		String screenshotName=methodname+"-"+jutil.getSystemDateInFormat1();
		try {
			wutil.takeScreenshot(Base_class.sdriver, screenshotName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		String methodname=result.getMethod().getMethodName();
		System.out.println(methodname+"---skip");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		System.out.println("suite level execution start");
	}

	public void onFinish(ITestContext context) {
		System.out.println("suite level execution finish");
	}
	

}
