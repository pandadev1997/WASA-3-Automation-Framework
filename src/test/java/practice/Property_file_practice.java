package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class Property_file_practice {

	public static void main(String[] args) throws Exception {
		// step 1: open the file in java readable format
		
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		
		//step 2:create object of properties from java.util package
		
		Properties p=new Properties();
		
		//step 3: load the properties fileinputstream into properties
		
		p.load(fis);
		
		//step 4: Access the value
		
		String URL = p.getProperty("url");
		String UN = p.getProperty("username");
		String PW = p.getProperty("password");
		
		
		System.out.println(URL+"\n"+UN);

	}

}
