package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Read_data_from_excel {

	public static void main(String[] args) throws Exception {
		// step 1 open the document in java readable format
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\Test data.xlsx");
		
		//step 2 create a workbook
		
		Workbook book = WorkbookFactory.create(fis);
		
		//step 3 get controll of sheet
		
		Sheet sh = book.getSheet("contact");
		
		//step 4 get controll of row
		
		Row row = sh.getRow(4);
		
		//step 5 get controll of cell
		
		Cell cell = row.getCell(3);
		
		//step 6 read the data inside the cell
		
		String value = cell.getStringCellValue();
		System.out.println(value);
		
		
	}

}
