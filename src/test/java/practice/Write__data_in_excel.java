package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Write__data_in_excel {
	public static void main(String[] args) throws Exception {
		
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\Test data.xlsx");
		  Workbook book = WorkbookFactory.create(fis);
		  Sheet sh = book.getSheet("org");
		  sh.createRow(3).createCell(4).setCellValue("babu");
		  FileOutputStream fo=new FileOutputStream(".\\\\src\\\\test\\\\resources\\\\Test data.xlsx");
		  book.write(fo);
		  System.out.println("pass");
		  
	}

}
