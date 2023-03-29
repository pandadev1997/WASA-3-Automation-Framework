package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Retry_Analyser_practice {
	@Test(retryAnalyzer = practice.I_Retry_Analyser.class)
	public void practice() {
		Assert.fail();
		System.out.println("pass");
	}

}
