package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import vtiger.Generalutility.All_file_path;

public class Excel_file_utility {
	
	public Object[][] readMultipledata(String sheetname) throws EncryptedDocumentException, IOException{
		FileInputStream fis=new FileInputStream(All_file_path.Excelfilepath);
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh = book.getSheet(sheetname);
		int lastrow = sh.getLastRowNum();
		int lastcell = sh.getRow(0).getLastCellNum();
		Object[][] data=new Object[lastrow][lastcell];
		for(int i=0;i<lastrow;i++) {
			for(int j=0;j<lastcell;j++) {
				data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		return data;
	}

}
