package practice;

import org.testng.annotations.Test;

public class TestNg_practice {
	@Test(priority = 1)
	public void sample() {
		System.out.println("baba");
	}
	
	@Test(priority = 2)
	public void basic() {
		System.out.println("apa");
	}

}
