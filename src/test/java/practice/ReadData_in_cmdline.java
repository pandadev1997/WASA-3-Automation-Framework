package practice;

import org.testng.annotations.Test;

public class ReadData_in_cmdline {
	@Test
	public void readdata() {
		String BROWSER = System.getProperty("browser");
		System.out.println(BROWSER);
		
		String URL = System.getProperty("url");
		System.out.println(URL);
		
		String UN = System.getProperty("username");
		System.out.println(UN);
	}

}
