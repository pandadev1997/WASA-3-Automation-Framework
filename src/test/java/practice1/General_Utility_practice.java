package practice1;

import java.io.IOException;

import vtiger.GenericUtilityPractice.Java_Utility_practice;

public class General_Utility_practice {

	public static void main(String[] args) throws IOException {
		PropertyFileUtility putil=new PropertyFileUtility();
		String URL = putil.readDataFromProperty("url");
		System.out.println(URL);
		Excel_File_utiliity eutil=new Excel_File_utiliity();
		String lastname = eutil.readDataFromExcel("contact", 1, 2);
		System.out.println(lastname);
		eutil.writeDataintoExcel("contact", 10, 5, "babu");
		String addedvalue = eutil.readDataFromExcel("contact", 10, 5);
		System.out.println("data added"+"-->"+addedvalue);
		
		/*Java_Utility_practice ju=new Java_Utility_practice();
		System.out.println(ju.getRandompractice());
		
		System.out.println(ju.sysdatepractice());
		
		System.out.println(ju.systemdateformatpractice());*/
		

	}

}
