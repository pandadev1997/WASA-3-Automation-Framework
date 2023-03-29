package practice;

import vtiger.Generalutility.Excel_File_utility;
import vtiger.Generalutility.PropertyFile_utility;
import vtiger.Generalutility.javautility;

public class General_Utility_practice {

	public static void main(String[] args) throws Exception {
		PropertyFile_utility p=new PropertyFile_utility();
		String URL = p.readDataFromPropertyFile("url");
		String BROWSER=p.readDataFromPropertyFile("browser");
		String USERNAME=p.readDataFromPropertyFile("username");
		String PASSWORD=p.readDataFromPropertyFile("password");
		System.out.println(URL+"\n"+BROWSER+"\n"+USERNAME+"\n"+PASSWORD);
	
		Excel_File_utility ex=new Excel_File_utility();
		String lastname = ex.Excel("contact", 1, 2);
		String orgname = ex.Excel("contact", 4, 2);
		String leadsourcedropdown = ex.Excel("contact", 7, 3);
		String industrydropdown = ex.Excel("org", 1, 2);
		String industrydropE = ex.Excel("org", 4, 2);
		String typedrop = ex.Excel("org", 4, 3);
		System.out.println(lastname+"\n"+orgname);
		
		System.out.println(ex.getlastrow("contact"));
		ex.writeDataIntoExcel("contact", 5, 6, "babuuu");
		System.out.println(ex.Excel("contact", 5, 6));
		
		javautility ju=new javautility();
		System.out.println(ju.getSystemDateInFormat());
		System.out.println(ju.getSystemDateInFormat1());
		System.out.println(ju.getRandomno());
		
		
	}
}



